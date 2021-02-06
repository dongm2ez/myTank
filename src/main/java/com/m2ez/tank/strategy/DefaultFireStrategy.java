package com.m2ez.tank.strategy;

import com.m2ez.tank.Bullet;
import com.m2ez.tank.Tank;

public class DefaultFireStrategy implements FireStrategy{
    @Override
    public void fire(Tank tank) {
        int bx = tank.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int by = tank.getY() + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;

        new Bullet(bx, by, tank.getDir(), tank.getGroup(), tank.getTf());
    }
}
