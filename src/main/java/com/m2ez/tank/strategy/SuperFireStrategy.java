package com.m2ez.tank.strategy;

import com.m2ez.tank.Bullet;
import com.m2ez.tank.enums.Dir;
import com.m2ez.tank.Tank;

public class SuperFireStrategy implements FireStrategy{
    @Override
    public void fire(Tank tank) {
        int bx = tank.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int by = tank.getY() + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;

        Dir[] dirs = Dir.values();

        for (int i = 0; i < dirs.length; i++) {
            new Bullet(bx, by, dirs[i], tank.getGroup(), tank.getTf());
        }
    }
}
