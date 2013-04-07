/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mek.mcloud.config;

import java.util.Properties;

/**
 *
 * @author root
 */
public class ConfigMapper {
    
    private static Properties staticResource = StaticResourceCofiguration.getStaticResource();
    private static Properties youtubeResource = YouTubeConfiguration.getYoutubeResource();

    public static Properties getStaticResource() {
        return staticResource;
    }

    public static void setStaticResource(Properties staticResource) {
        ConfigMapper.staticResource = staticResource;
    }

    public static Properties getYoutubeResource() {
        return youtubeResource;
    }

    public static void setYoutubeResource(Properties youtubeResource) {
        ConfigMapper.youtubeResource = youtubeResource;
    }
    
}
