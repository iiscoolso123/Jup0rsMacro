package com.croncler;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ScreenReader {


    private static Robot robot;
    private static Tesseract instance;

    public static String readAtPos(int x,int y, int width, int height) throws AWTException {
        Rectangle rect = new Rectangle(x,y,width,height);
        String result = null;
        if (robot == null) {
            robot = new Robot();
        }
        if (instance == null) {
            instance = new Tesseract();
            instance.setVariable("user_defined_dpi", "96");
        }
        BufferedImage image = robot.createScreenCapture(rect);
        try {
            result = instance.doOCR(image);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
        return result;
    }

    public static String readAtRect(Rectangle rect) throws AWTException {
        String result = null;
        if (robot == null) {
            robot = new Robot();
        }
        if (instance == null) {
            instance = new Tesseract();
            instance.setVariable("user_defined_dpi", "96");
        }
        BufferedImage image = robot.createScreenCapture(rect);

        try {
            result = instance.doOCR(image);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
        return result;
    }
}
