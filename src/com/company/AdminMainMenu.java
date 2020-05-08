package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Color.black;
import static java.awt.Color.gray;

public class AdminMainMenu extends Container {
    public JButton addd;
    public JButton list;
    public JButton delete;
    public JButton exit;

    public AdminMainMenu() {
        setSize(700, 700);
        setLayout(null);
        addd = new JButton("Add Book");
        addd.setLocation(200, 150);
        addd.setSize(300, 30);
        addd.setForeground(black);
        addd.setBackground(gray);
        addd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Admin.showAddPage();
            }
        });
        add(addd);

        list = new JButton("List_Books");
        list.setLocation(200, 190);
        list.setSize(300, 30);
        list.setForeground(black);
        list.setBackground(gray);
        list.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Admin.showListPage();
            }
        });
        add(list);

        delete= new JButton("Delete_Books");
        delete.setLocation(200, 230);
        delete.setSize(300, 30);
        delete.setForeground(black);
        delete.setBackground(gray);
        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Admin.showDeletePage();
            }
        });
        add(delete);

        exit = new JButton("Exit");
        exit.setForeground(black);
        exit.setBackground(gray);
        exit.setBounds(200, 310, 300, 30);

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(exit);

    }
}
