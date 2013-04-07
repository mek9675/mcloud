/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mek.mcloud.config;

import java.util.Properties;
import org.apache.ibatis.io.Resources;
import org.apache.log4j.Logger;

/**
 *
 * @author root
 */
public class YouTubeConfiguration {
    
    private static Logger LOG = Logger.getLogger(YouTubeConfiguration.class.getName());
    private static Properties youtubeResource = new Properties();

    static {

        try {
            
            youtubeResource.load(Resources.getResourceAsStream("youtube.properties"));
            
        } catch (Exception e) {
            
            LOG.error(e.toString(), e);
            
        } finally {
            
        }

    }

    public static Properties getYoutubeResource() {
        return youtubeResource;
    }
}
