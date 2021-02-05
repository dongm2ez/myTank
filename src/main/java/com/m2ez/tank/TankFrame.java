package com.m2ez.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {

    Tank myTank = new Tank(200, 200, Dir.DOWN);

    public TankFrame() {
        setSize(800, 600);
        setResizable(false);
        setTitle("tank war");
        setVisible(true);

        addKeyListener(new MyKeyListener());

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });


    }

    @Override
    public void paint(Graphics g) {
        myTank.paint(g);
    }

    class MyKeyListener extends KeyAdapter {

        boolean bL = false;
        boolean bU = false;
        boolean bR = false;
        boolean bD = false;

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            switch (key) {
                case KeyEvent.VK_LEFT:
                case KeyEvent.VK_A:
                    bL = true;
                    break;
                case KeyEvent.VK_UP:
                case KeyEvent.VK_W:
                    bU = true;
                    break;
                case KeyEvent.VK_RIGHT:
                case KeyEvent.VK_D:
                    bR = true;
                    break;
                case KeyEvent.VK_DOWN:
                case KeyEvent.VK_S:
                    bD = true;
                    break;
                default:
                    break;
            }

            setMainTankDir();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                case KeyEvent.VK_A:
                    bL = false;
                    break;
                case KeyEvent.VK_UP:
                case KeyEvent.VK_W:
                    bU = false;
                    break;
                case KeyEvent.VK_RIGHT:
                case KeyEvent.VK_D:
                    bR = false;
                    break;
                case KeyEvent.VK_DOWN:
                case KeyEvent.VK_S:
                    bD = false;
                    break;
                default:
                    break;
            }

            setMainTankDir();
        }

        private void setMainTankDir() {
            if (bL) myTank.setDir(Dir.LEFT);
            if (bU) myTank.setDir(Dir.UP);
            if (bR) myTank.setDir(Dir.RIGHT);
            if (bD) myTank.setDir(Dir.DOWN);
        }

    }
}
