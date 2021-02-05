package com.m2ez.tank.test;

import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ImageTest {

    @Test
    void test() {
        try {
            BufferedImage image = ImageIO.read(new File("src/main/resources/images/0.gif"));
            assertNotNull(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
