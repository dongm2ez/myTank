package com.m2ez.tank;

import java.awt.*;
import java.util.Random;

public class Tank {
    public static final int WIDTH = ResourceMgr.goodTankD1.getWidth();
    public static final int HEIGHT = ResourceMgr.goodTankD1.getHeight();
    private static final int SPEED = 5;
    private final TankFrame tf;

    private final Random random = new Random();
    private int x, y;
    private boolean living = true;
    private Group group = Group.BAD;
    private Dir dir = Dir.DOWN;
    private boolean moving = true;

    public Tank(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public void paint(Graphics g) {

        if (!living) tf.tanks.remove(this);

        switch (dir) {
            case LEFT:
                g.drawImage(this.group == Group.GOOD ? (random.nextInt(2) % 2 == 0 ? ResourceMgr.goodTankL1 : ResourceMgr.goodTankL2) : (random.nextInt(2) % 2 == 0 ? ResourceMgr.badTankL1 : ResourceMgr.badTankL2), x, y, null);
                break;
            case UP:
                g.drawImage(this.group == Group.GOOD ? (random.nextInt(2) % 2 == 0 ? ResourceMgr.goodTankU1 : ResourceMgr.goodTankU2) : (random.nextInt(2) % 2 == 0 ? ResourceMgr.badTankU1 : ResourceMgr.badTankU2), x, y, null);
                break;
            case RIGHT:
                g.drawImage(
                        this.group == Group.GOOD ? (random.nextInt(2) % 2 == 0 ? ResourceMgr.goodTankR1 : ResourceMgr.goodTankR2) : (random.nextInt(2) % 2 == 0 ? ResourceMgr.badTankR1 : ResourceMgr.badTankR2), x, y, null);
                break;
            case DOWN:
                g.drawImage(this.group == Group.GOOD ? (random.nextInt(2) % 2 == 0 ? ResourceMgr.goodTankD1 : ResourceMgr.goodTankD2) : (random.nextInt(2) % 2 == 0 ? ResourceMgr.badTankD1 : ResourceMgr.badTankD2), x, y, null);
                break;
        }

        move();
    }

    private void move() {

        if (!moving) return;

        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
        }

        if (random.nextInt(100) > 95 && this.group == Group.BAD) {
            this.fire();
            this.randomDir();
        }
    }

    private void randomDir() {
        this.dir = Dir.values()[random.nextInt(4)];
    }

    public void fire() {
        int bx = this.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int by = this.y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        tf.bulletList.add(new Bullet(bx, by, dir, group, tf));
    }

    public void die() {
        this.living = false;
    }


}
