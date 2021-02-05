package com.m2ez.tank;

import java.awt.*;

public class Explode {
    public static final int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static final int HEIGHT = ResourceMgr.explodes[0].getHeight();
    private int x, y;
    private TankFrame tf = null;
    private boolean living = true;

    private int step = 0;


    public Explode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
    }

    public void paint(Graphics g) {

        if (!living) {
            tf.explodes.remove(this);
        }

        g.drawImage(ResourceMgr.explodes[step++], x, y, null);

        if (step >= ResourceMgr.explodes.length) {
            this.die();
            step = 0;
        }
        ;
    }

    private void die() {
        this.living = false;
    }


}
