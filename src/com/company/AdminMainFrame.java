package com.company;
import javax.swing.*;

public class AdminMainFrame extends JFrame {
    public AdminAddPage addBooks;
    public AdminListPage listBooks;
    public AdminDeletePage deletePage;
    public AdminMainMenu menu;
    public Welcome welcome;
    public AdminMainFrame(){
        setTitle("ADMIN");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,700);
        setLayout(null);
        setLocationRelativeTo(null);


        menu = new AdminMainMenu();
        menu.setLocation(0,0);
        menu.setVisible(false);
        add(menu);

        welcome = new Welcome();
        welcome.setLocation(0,0);
        welcome.setVisible(true);
        add(welcome);

        addBooks = new AdminAddPage();
        addBooks.setLocation(0,0);
        addBooks.setVisible(false);
        add(addBooks);

        listBooks = new AdminListPage();
        listBooks.setLocation(0,0);
        listBooks.setVisible(false);
        add(listBooks);

        deletePage=new AdminDeletePage();
        deletePage.setLocation(0,0);

        deletePage.setVisible(false);
        add(deletePage);

        repaint();
    }
}
