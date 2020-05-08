package com.company;
import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.*;

public class ServerThread extends Thread {
    private Connection connection;
    private Socket socket;
    ObjectInputStream inputStream;
    ObjectOutputStream outputStream;
    public static Long id = null;

    public ServerThread(Socket socket, Connection connection) {
        this.socket = socket;
        this.connection = connection;
        try {
            inputStream = new ObjectInputStream(this.socket.getInputStream());
            outputStream = new ObjectOutputStream(this.socket.getOutputStream());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void run() {
        try {
            PackageData pd = null;
            while ((pd = (PackageData) inputStream.readObject()) != null) {

                if (pd.getOperationType().equals("Add_Book")) {
                    try {
                        book book = pd.getBook();
                        addBook(book);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }   else if(pd.getOperationType().equals("Add_Orders")){
                    try {
                        Orders orders= pd.getOrders().get(0);
                        addOrdersToDb(orders);

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                else if (pd.getOperationType().equals("List_Books")) {
                    ArrayList<book> rooms = getAllBooks();
                    PackageData resp = new PackageData();
                    resp.setBooks(rooms);
                    outputStream.writeObject(resp);
                }
                else if (pd.getOperationType().equals("List_Users")) {
                    ArrayList<UserData> users = getAllUsers();
                    PackageData resp = new PackageData();
                    resp.setUsers(users);
                    outputStream.writeObject(resp);
                }
                else if(pd.getOperationType().equals("List_Orders")){
                    ArrayList<Orders>orders=getOrders();
                    PackageData pd2=new PackageData();
                    pd2.setOrders(orders);
                    outputStream.writeObject(pd2);
                }
                else if (pd.getOperationType().equals("Edit")) {
                    Long id=pd.getId();
                    edit(id);
                }
                else if (pd.getOperationType().equals("Delete_Books")) {
                    Long id = pd.getId();
                    deleteBookToDB(id);
                } else if (pd.getOperationType().equals("Add_User")) {
                    try {
                        UserData user = pd.getUser();
                        addUser(user);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void addUser(UserData user) {
        try {

            PreparedStatement ps = connection.prepareStatement("INSERT INTO user (login, password,address,telephoneNumber) VALUES(?,?,?,?)");
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getAddress());
            ps.setString(4, user.getTelephoneNumber());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void addBook(book book) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO book (id, name,author,genre,description,price,count,sold,graduate) VALUES(NULL, ?, ?,?,?,?,?,?,?)");
            ps.setString(1, book.getName());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getGenre());
            ps.setString(4, book.getDescription());
            ps.setInt(5, book.getPrice());
            ps.setInt(6, book.getCount());
            ps.setInt(7, book.getSold());
            ps.setInt(8, book.getGraduate());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Orders> getOrders() {
        ArrayList<Orders> orders = new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            String sql = "SELECT * FROM orders";
            ResultSet res = st.executeQuery(sql);
            while(res.next()){
                orders.add(new Orders(res.getLong("id"), res.getInt("booksId"), res.getString("name"), res.getString("surname")));
            }
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orders;
    }

    public  void addOrdersToDb(Orders orders) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into orders(id,booksId,name,surname) values(null,?,?,?)");

            ps.setInt(1,orders.getBooksId());
            ps.setString(2,orders.getName());
            ps.setString(3,orders.getSurname());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<UserData> getAllUsers() {
        ArrayList<UserData> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * from user");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String login = rs.getString("login");
                String password = rs.getString("password");
                String address = rs.getString("address");
                String telephoneNumber = rs.getString("telephoneNumber");
                list.add(new UserData(login,password,address,telephoneNumber));
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }



    public ArrayList<book> getAllBooks(){
        ArrayList<book> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * from book");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Long id = rs.getLong("id");
                String name = rs.getString("name");
                int sold = rs.getInt("sold");
                String author = rs.getString("author");
                String genre=rs.getString("genre");
                int price=rs.getInt("price");
                int count= rs.getInt("count");
                int graduate=rs.getInt("graduate");
                String desc=rs.getString("description");
                list.add(new book(id,name,"Book",sold,genre,count,price,author,graduate,desc));
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void deleteBookToDB(Long id){
        try{
            PreparedStatement ps=connection.prepareStatement("DELETE FROM book WHERE id=?");
            ps.setLong(1,id);
            int rows= ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void edit (Long id){
        String update = "UPDATE book SET count=count-1 ,sold = sold+1 WHERE id = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(update);

            ps.setLong(1,id);
            ps.executeUpdate();

            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
