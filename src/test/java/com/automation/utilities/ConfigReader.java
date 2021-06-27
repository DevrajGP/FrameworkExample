package com.automation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    Properties property;

    public ConfigReader(){
        File src = new File("./Config/Config.properties");
        try {
            FileInputStream fis = new FileInputStream(src);
            property = new Properties();
            property.load(fis);
        } catch (Exception e) {
            System.out.println("not able to read Config file " + e.getMessage());
        }
    }

    public String getDataFromConfig(String key){
        return  property.getProperty(key);
    }

    public String getBrowser(){
        return  property.getProperty("browser");
    }

    public String getUrl(){
        return  property.getProperty("url");
    }
}
