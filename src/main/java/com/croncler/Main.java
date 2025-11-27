package com.croncler;

import org.apache.commons.logging.impl.Slf4jLogFactory;
import org.slf4j.helpers.Slf4jEnvUtil;

import java.awt.*;

public class Main {
    public static void main(String[] args) throws AWTException, InterruptedException {



        while (true) {

            Thread.sleep(1000);
            Point mousePos = MouseInfo.getPointerInfo().getLocation();

            int height = 400;
            int width = 600;
            Rectangle mouseBox = new Rectangle(mousePos.x - width / 2, mousePos.y - height / 2, width, height);
            String stuffOnScreen = ScreenReader.readAtRect(mouseBox);
            System.out.println(stuffOnScreen);
        }
    }
}