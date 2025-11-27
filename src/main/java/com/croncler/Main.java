package com.croncler;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {
    public static void main(String[] args) throws AWTException, InterruptedException {
        File imageFile = new File("testimg.png");
        Tesseract instance = new Tesseract();

        Robot robot = new Robot();

        while (true) {

            Thread.sleep(1000);
            Point mousePos = MouseInfo.getPointerInfo().getLocation();

            int height = 200;
            int width = 300;
            Rectangle mouseBox = new Rectangle(mousePos.x - width / 2,mousePos.y - height / 2,width,height);


            BufferedImage image = robot.createScreenCapture(mouseBox);
            try {
                String result = instance.doOCR(image);
                System.out.println(result);
            } catch (TesseractException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}