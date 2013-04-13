/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mek.mcloud.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.apache.ibatis.io.Resources;
import org.apache.log4j.Logger;

/**
 *
 * @author root
 */
public class StaticResourceCofiguration {

    private static Logger LOG = Logger.getLogger(StaticResourceCofiguration.class.getName());
    private static Properties staticResource = new Properties();

    static {

        try {
            
            staticResource.load(Resources.getResourceAsStream("staticResourceConfig.properties"));
            
        } catch (Exception e) {
            
            LOG.error(e.toString(), e);
            
        } finally {
            
        }

    }

    public static Properties getStaticResource() {
        return staticResource;
    }
    
}
