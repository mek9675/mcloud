/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mek.mcloud.apps.youtube.controller;


import com.google.api.services.youtube.model.SearchResult;
import com.mek.mcloud.apps.youtube.model.YouTubeSearch;
import com.mek.mcloud.apps.youtube.model.YouTubeSearchDisplayBeanArray;
import com.mek.mcloud.apps.youtube.service.YouTubeSearchImpl;
import com.mek.mcloud.config.ConfigMapper;
import com.mek.mcloud.setup.MCloudContextListener;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
            map.put("staticResources", getStaticResource().getProperty("com.mek.mcloud.app.ststicResources"));
            map.put("filter", getYoutubeSearchFilter());
            
            return "youtube/home";
            
	}
        
        @RequestMapping("/search")
	public String search(Map<String, Object> map,final YouTubeSearch search) {
            
            map.put("search", search);
            map.put("staticResources", getStaticResource().getProperty("com.mek.mcloud.app.ststicResources"));
            map.put("filter", getYoutubeSearchFilter());
            YouTubeSearchDisplayBeanArray searchResultList = searchService.getSearchResult(search);
            map.put("result", searchResultList);
            return "youtube/result";
            
	}
    
}
