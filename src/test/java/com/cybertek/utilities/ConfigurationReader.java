package com.cybertek.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    /*
     In this class we will be creating a re-usable method that will be reading
     from configuration.reader file
     private == to Encapsulation
      */
    //#1 create properties object
    private  static Properties properties = new Properties();

    // static runs before anything else
    static{

        try {
            //    #2 Load the file into FileInputStream
            FileInputStream file = new FileInputStream("configuration.properties");

            //#3 load properties object with the file (configuration.properties)
            properties.load(file);
        } catch (IOException e) {
            System.out.println("File not found in Configuration properties.");
        }

    }
// USE TH ABOVE CREATED LOGIC TO CREATE A RE-USABLE STATIC METHOD

    public static String getProperty(String keyWord){
        return properties.getProperty(keyWord);
    }

}


