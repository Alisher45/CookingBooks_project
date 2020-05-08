package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Color.black;
import static java.awt.Color.gray;

public class AdminAddPage extends Container {
    private JLabel name;
    private JTextField textName;
    private JLabel Author;
    private JTextField textAuthor;
    private JLabel labelPrice;
    private JTextField textPrice;
    private JLabel description;
    private JTextField textDescription;
    private JLabel count;
    private JTextField textGraduate;
    private JLabel graduate;
    private JTextField textCount;
    private JLabel genre;
    private JComboBox comboBoxGenre;

    private JButton addBooks;
    private JButton back;

    public AdminAddPage() {
        setLayout(null);
        setSize(700, 700);

        name = new JLabel("Name:");
        name.setBounds(250, 150, 80, 40);
        add(name);
        textName = new JTextField();
        textName.setBounds(340, 150, 100, 40);
        add(textName);

        Author = new JLabel("Autor:");
        Author.setBounds(250, 200, 80, 40);
        add(Author);

        textAuthor = new JTextField();
        textAuthor.setBounds(340, 200, 100, 40);
        add(textAuthor);

        labelPrice = new JLabel("Price:");
        labelPrice.setBounds(250, 250, 80, 40);
        add(labelPrice);

        textPrice = new JTextField();
        textPrice.setBounds(340, 250, 100, 40);
        add(textPrice);

        description = new JLabel("Description:");
        description.setBounds(250, 300, 80, 40);
        add(description);

        textDescription = new JTextField();
        textDescription.setBounds(340, 300, 200, 80);
        add(textDescription);

        count = new JLabel("Rating:");
        count.setBounds(250, 400, 80, 40);
        add(count);

        textCount = new JTextField();
        textCount.setBounds(340, 400, 100, 40);
        add(textCount);


        graduate = new JLabel("Graduate:");
        graduate.setBounds(250, 450, 80, 40);
        add(graduate);

        textGraduate = new JTextField();
        textGraduate.setBounds(340, 450, 100, 40);
        add(textGraduate);

        genre = new JLabel("Genre");
        genre.setBounds(250, 500, 80, 40);
        add(genre);

        comboBoxGenre = new JComboBox();
        comboBoxGenre.setBounds(340, 500, 100, 40);
        comboBoxGenre.addItem("C");
        comboBoxGenre.addItem("D");
        comboBoxGenre.addItem("F");
        comboBoxGenre.addItem("H");
        comboBoxGenre.addItem("H");
        comboBoxGenre.addItem("M");
        comboBoxGenre.addItem("R");
        add(comboBoxGenre);


        addBooks = new JButton("Add");
        addBooks.setBounds(250, 550, 100, 50);
        addBooks.setForeground(black);
        addBooks.setBackground(gray);
        addBooks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                try {
                    book book = new book(null, textName.getText(), "Book",0,comboBoxGenre.getSelectedItem().toString(),  Integer.parseInt(textCount.getText()), Integer.parseInt(textPrice.getText()),textAuthor.getText(), Integer.parseInt(textGraduate.getText()),textDescription.getText());
                    Admin.addBooks(book);
                    textName.setText("");
                    textCount.setText("");
                    textPrice.setText("");
                    textAuthor.setText("");
                    textGraduate.setText("");
                    textDescription.setText("");
                    textPrice.setText("");

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        add(addBooks);

        back = new JButton("Back");
        back.setForeground(black);
        back.setBackground(gray);
        back.setBounds(360, 600, 100, 50);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Admin.frame.addBooks.setVisible(false);
                Admin.frame.listBooks.setVisible(false);
                Admin.frame.deletePage.setVisible(false);
                Admin.frame.menu.setVisible(true);
                Admin.frame.repaint();
            }
        });
        add(back);
    }
}

