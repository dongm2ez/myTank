package com.m2ez.tank;

import com.m2ez.tank.enums.Dir;
import com.m2ez.tank.enums.Group;
import com.m2ez.tank.mgr.PropertyMgr;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tf = new TankFrame();

        int initTankCount = Integer.parseInt((String) PropertyMgr.get("initTankCont")) ;
        for (int i = 0; i < initTankCount; i++) {
            tf.tanks.add(new Tank(50 + i * 80, 200, Dir.DOWN, Group.BAD, tf));
        }

        while (true) {
            Thread.sleep(25);
            tf.repaint();
        }
    }
}
