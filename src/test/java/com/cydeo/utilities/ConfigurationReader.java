package com.cydeo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    //create the object of Properties
    private static Properties properties = new Properties(); // inaccessible for any class and make it static so it runs before everything else

    static {
        FileInputStream file = null;
        try {
            // open file in java memory
            file = new FileInputStream("configuration.properties");
            //load properties object using FileInputStream Object
            properties.load(file);
            // close the file
            file.close(); // close from java memory, it is more structured this way
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File not found in the configurationReader cllass");
        }//using try catch because this is a reusable code
    }

    //return the value of the key
    public static String getProperty(String keyword){
        return properties.getProperty(keyword); // when we call this method, all the other things in the static block has happened as static runs before everything else
    }
}
