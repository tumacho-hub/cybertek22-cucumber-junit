package com.cybertek.utilities;

public class BrowserUtils {
    // we are creating a method that will accept integer and "int" wait for given second duration.
    // 1 second = 1000 milli seconds
    // 1 * 1000 = 1000
    public static void sleep(int second) {
        second*=1000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Something happened in the sleep method");
        }

    }
}


