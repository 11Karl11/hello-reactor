package com.karl.reactor.reactiveweb;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static com.karl.reactor.utils.Util1.println;


/**
 * 异步+非阻塞
 * @author karl xie
 */
public class AsyncNonBlockingGUIDemo {

    public static void main(String[] args) {

        //Swing java gui类库

        //创建一个窗口
        JFrame jFrame = new JFrame();

        jFrame.setTitle("简单GUI程序");


        jFrame.setBounds(300,300,400,300);
        //增加一个窗口关闭事件
        //非阻塞
        //异步：线程main-》AWT-EventQueue
        //reactive
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                println("销毁当前窗口");
                jFrame.dispose();
            }

            @Override
            public void windowClosed(WindowEvent e) {
                println("窗口被关闭，退出程序");
                System.exit(0);//Jvm进程退出
            }
        });

        //增加鼠标事件监听
        jFrame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                println("当前鼠标位置，x："+e.getX()+"y:"+e.getY());
            }
        });


        println("启动一个JFrame窗口");

        //设置可视
        jFrame.setVisible(true);

    }
}