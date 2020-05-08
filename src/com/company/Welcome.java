package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Welcome extends Container {
    public JButton aaa;
    public JPanel panel;
    public Welcome() {
        JLabel background;
        setSize(700, 700);
        setLayout(null);
        ImageIcon img = new ImageIcon("1233.jpg");

        background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(0, 0, 1200, 700);
        add(background);
        setVisible(true);

        aaa = new JButton("ADMIN!!!");
        aaa.setLocation(250, 600);
        aaa.setSize(300, 30);
        aaa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Admin.showMenuPage();
            }
        });
        add(aaa);

    }
    int x=0, y=100;
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2 = (Graphics2D)g;
        Font font = new Font("Tahoma",Font.BOLD+Font.PLAIN,100);
        g2.setFont(font);
        g2.setColor(Color.LIGHT_GRAY);
        g2.drawString("Welcome",x,y);
        try{
            Thread.sleep(100);
        }catch (Exception ex){}
        x+=10;
        if(x>this.getWidth()){
            x=0;
        }
        repaint();
    }
}
