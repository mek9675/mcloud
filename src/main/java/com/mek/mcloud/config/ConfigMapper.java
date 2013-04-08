/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mek.mcloud.config;

import java.util.Map;
import java.util.Properties;

/**
 *
 * @author root
 */
public class ConfigMapper {
    
    private static Properties staticResource = StaticResourceCofiguration.getStaticResource();
    private static Properties youtubeResource = YouTubeConfiguration.getYoutubeResource();
    private static Map<String, Map> youtubeSearchFilter = YouTubeConfiguration.getYoutubeSearchFilter();

    public static Properties getStaticResource() {
        return staticResource;
    }

    public static Properties getYoutubeResource() {
        return youtubeResource;
    }

    public static Map<String, Map> getYoutubeSearchFilter() {
        return youtubeSearchFilter;
    }
    
}
