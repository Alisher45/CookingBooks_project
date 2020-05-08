package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static java.awt.Color.black;
import static java.awt.Color.gray;

public class AdminListPage extends Container {
    private JTable table;
    private JLabel label;
    private JTextField textField;
    private JButton back;

    public AdminListPage(){
        setLayout(null);
        setSize(900,900);

        back=new JButton("BACK");
        back.setForeground(black);
        back.setBackground(gray);
        back.setBounds(450,500,100,50);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Admin.showMenuPage();
            }
        });
        add(back);

    }


    public void updateArea(ArrayList<book> books){

        String columnNames[] =new String[]{"ID",  "NAME", "AUTHOR","GENRE","DESCRIPTION","PRICE","COUNT","SOLD","GRADUATE"};

        String data[][] = new String[books.size()][9];

        int i = 0;
        for(book st : books){
            data[i][0] = String.valueOf(st.getId());
            data[i][1] = st.getName();
            data[i][2] = st.getAuthor();
            data[i][3]=st.getGenre();
            data[i][4]=st.getDescription();
            data[i][5] = String.valueOf(st.getPrice());
            data[i][6]=String.valueOf(st.getCount());
            data[i][7]=String.valueOf(st.getSold());
            data[i][8]=String.valueOf(st.getGraduate());

            i++;
        }

        table = new JTable(data, columnNames);
        table.setBounds(70,80,500,500);

        add(table);
        repaint();
    }
}
