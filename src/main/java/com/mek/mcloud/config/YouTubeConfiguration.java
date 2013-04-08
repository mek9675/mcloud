/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mek.mcloud.config;

import com.mek.mcloud.commonfunctions.CommonFunction;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import org.apache.ibatis.io.Resources;
import org.apache.log4j.Logger;

/**
 *
 * @author root
 */
public class YouTubeConfiguration {
    
    private static Logger LOG = Logger.getLogger(YouTubeConfiguration.class.getName());
    private static Properties youtubeResource = new Properties();
    private static Map<String,Map> youtubeSearchFilter = new HashMap<String, Map>();
    
    static {

        try {
            
            youtubeResource.load(Resources.getResourceAsStream("youtube.properties"));
            
            //for set filter creteria
            String mainKey;
            Map<String,String> tmpMap;
            Set<Object> keys = youtubeResource.keySet();
            
            for(Object key : keys) {
                if(key.toString().trim().startsWith("youtube.search.filter")) {
                   mainKey = key.toString().substring(CommonFunction.nthOccurrence(key.toString(), '.', 2)+1);
                   tmpMap = new HashMap<String,String>();
                   for(String str : youtubeResource.getProperty(key.toString()).split(",")) {
                       tmpMap.put(str.split("#")[0], str.split("#")[1]);
                   }
                   youtubeSearchFilter.put(mainKey, tmpMap);
                }
            }
            
        } catch (Exception e) {
            
            LOG.error(e.toString(), e);
            
        } finally {
            
        }

    }

    public static Properties getYoutubeResource() {
        return youtubeResource;
    }

    public static Map<String, Map> getYoutubeSearchFilter() {
        return youtubeSearchFilter;
    }
    
}
