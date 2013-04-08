/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mek.mcloud.apps.youtube.controller;


import com.mek.mcloud.apps.youtube.model.YouTubeSearch;
import com.mek.mcloud.apps.youtube.service.YouTubeSearchImpl;
import com.mek.mcloud.config.ConfigMapper;
import com.mek.mcloud.setup.MCloudContextListener;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Properties;
import org.apache.log4j.Logger;

/**
 *
 * @author root
 */

@Controller
@RequestMapping("/youtube")
public class YouTubeController extends ConfigMapper {
    
        private static Logger LOG = Logger.getLogger(YouTubeController.class.getName());
        public YouTubeSearchImpl searchService = new YouTubeSearchImpl();
        
        @RequestMapping("/")
	public String welcome(Map<String, Object> map) {
            
            LOG.info("this is for info log youtube controller");
            map.put("search", new YouTubeSearch());
            map.put("ststicResources", getStaticResource().getProperty("com.mek.mcloud.app.ststicResources"));
            map.put("filter", getYoutubeSearchFilter());
            
            return "youtube/home";
            
	}
        
        @RequestMapping("/search")
	public String search(Map<String, Object> map,final YouTubeSearch search) {
            
            map.put("search", search);
            map.put("ststicResources", getStaticResource().getProperty("com.mek.mcloud.app.ststicResources"));
            return "youtube/home";
            
	}
    
}
