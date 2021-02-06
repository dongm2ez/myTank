package com.m2ez.tank.mgr;

import java.io.IOException;
import java.util.Properties;

public class PropertyMgr {
    private static final PropertyMgr INSTANCE = new PropertyMgr();
    private static final Properties properties = new Properties();

    static {
        try {
            properties.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private PropertyMgr() {}

    public static PropertyMgr getInstance() {
        return INSTANCE;
    }

    public static Object get(String key) {
        if (properties == null) return null;
        return properties.get(key);
    }
}
