/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mek.mcloud.apps.youtube.service;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mek.mcloud.apps.youtube.controller.YouTubeController;
import com.mek.mcloud.apps.youtube.model.YouTubeSearch;
import com.mek.mcloud.apps.youtube.model.YouTubeSearchDisplayBean;
import com.mek.mcloud.apps.youtube.model.YouTubeSearchDisplayBeanArray;
import com.mek.mcloud.config.ConfigMapper;
import java.io.IOException;
import java.util.*;
import org.apache.log4j.Logger;

/**
 *
 * @author root
 */
public class YouTubeSearchImpl {
    
    /** Global instance of the HTTP transport. */
    private final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
    
    /** Global instance of the JSON factory. */
    private final JsonFactory JSON_FACTORY = new JacksonFactory();
    
    /** Global instance of Youtube object to make all API requests. */
    private YouTube youtube;
    
    /** Global instance of Youtube API Key. */
    private static String apiKey;
    
    private static Logger LOG = Logger.getLogger(YouTubeSearchImpl.class.getName());
    
    public YouTubeSearchImpl() {
        
         youtube = new YouTube.Builder(HTTP_TRANSPORT, JSON_FACTORY, new HttpRequestInitializer() {

            public void initialize(HttpRequest request) throws IOException {
            }
            
        }).setApplicationName("mCloud").build();
         
        // set you tube api key
        apiKey = ConfigMapper.getYoutubeResource().getProperty("youtube.apikey");
         
    }
    
    
    public YouTubeSearchDisplayBeanArray getSearchResult(YouTubeSearch searchBean) {
        
        List<SearchResult> searchResultList=null;
        StringBuilder allIds;
        Map channels = new HashMap() ;
        Map playLists = new HashMap() ;
        Map videos = new HashMap() ;
        
        YouTubeSearchDisplayBeanArray returnObj = new YouTubeSearchDisplayBeanArray();
        YouTubeSearchDisplayBean resultObj;
        List<YouTubeSearchDisplayBean> arrObj = new ArrayList<YouTubeSearchDisplayBean>();
        
        try {
                     
            YouTube.Search.List search = youtube.search().list("id,snippet");
            
            //for set youtube api key
            search.setKey(apiKey);
            
            //for set search key
            search.setQ(searchBean.getQ());
            
            //set search type
            if(searchBean.getResultType() != null && searchBean.getResultType().trim().length() > 0) {
                if (searchBean.getResultType().trim().equalsIgnoreCase("Video")
                        || searchBean.getResultType().equalsIgnoreCase("Channel")
                        || searchBean.getResultType().equalsIgnoreCase("Playlist")) {
                    
                    search.setType(searchBean.getResultType().trim().toLowerCase());
                    
                }
            }
            
            //set no of video per page
            search.setMaxResults(searchBean.getMaxResults());
            
            SearchListResponse searchResponse = search.execute();
            
            searchResultList = searchResponse.getItems();
            
             //for set pageInfo
            returnObj.setPageInfo(searchResponse.getPageInfo());
            returnObj.setNextPageToken(searchResponse.getNextPageToken());
            returnObj.setPrevPageToken(searchResponse.getNextPageToken());           
            //for set pageInfo
            
            for(SearchResult result : searchResultList) {
                
                if(result.getId().getKind().equalsIgnoreCase("youtube#video")) {
                    
                    videos.put(result.getId().getVideoId(), result.getId().getVideoId());
                    
                } else if(result.getId().getKind().equalsIgnoreCase("youtube#channel")) {
                    
                    channels.put(result.getId().getChannelId(), result.getId().getChannelId());
                    
                } else if(result.getId().getKind().equalsIgnoreCase("youtube#playlist")) {
                    
                    playLists.put(result.getId().getPlaylistId(), result.getId().getPlaylistId());
                    
                }
                
            }
            
            //to get all videos
            if(!videos.isEmpty()) {
                
                //to set all ids as comma seprated
                allIds = new StringBuilder();
                Set<String> set = videos.keySet();
                for(String s : set) {
                    allIds.append(s).append(",");
                }

                YouTube.Videos.List video = youtube.videos().list("", "id,snippet,contentDetails,statistics,player,status,topicDetails,recordingDetails");
                video.setKey(apiKey);
                video.setId(allIds.toString());
                VideoListResponse videolistResponse = video.execute();
                List<Video>  videoData = videolistResponse.getItems();
                
                for(Video v : videoData) {
                    
                    try {
                        resultObj = new Gson().fromJson(v.toString(), YouTubeSearchDisplayBean.class);
                        
                        //to set manually default url
//                        resultObj.getSnippet().getThumbnails().getDefault().setUrl(v.getSnippet().getThumbnails().get("default").toString());
                        
                        arrObj.add(resultObj);
                        
                    } catch (Exception e) {
                        LOG.error("Error to add all video in objects ",e);
                    }
                    
                }
            }
            
            
            //to get all channels
            if(!channels.isEmpty()) {
                
                //to set all ids as comma seprated
                allIds = new StringBuilder();
                Set<String> set = channels.keySet();
                for(String s : set) {
                    allIds.append(s).append(",");
                }

                YouTube.Channels.List channel  =youtube.channels().list("id,snippet,contentDetails,statistics,topicDetails");
                
                channel.setId(allIds.toString());
                channel.setKey(apiKey);
                
                ChannelListResponse channelResponse = channel.execute();
                List<Channel> channelList = channelResponse.getItems();
                
                for(Channel c : channelList) {
                    
                    try {
                        resultObj = new Gson().fromJson(c.toString(), YouTubeSearchDisplayBean.class);
                        
                        //to set manually default url
//                        resultObj.getSnippet().getThumbnails().getDefault().setUrl(c.getSnippet().getThumbnails().get("default").toString());
                        
                       arrObj.add(resultObj);
                        
                    } catch (Exception e) {
                        LOG.error("Error to add all channel in objects ",e);
                    }   
                    
                }
                
            }
            
            //to get all play list
            if(!playLists.isEmpty()) {
                
                //to set all ids as comma seprated
                allIds = new StringBuilder();
                Set<String> set = playLists.keySet();
                for(String s : set) {
                    allIds.append(s).append(",");
                }

                YouTube.Playlists.List playlist = youtube.playlists().list("id,snippet,status");
                
                playlist.setId(allIds.toString());
                playlist.setKey(apiKey);
                
                PlaylistListResponse playListResponse = playlist.execute();
                List<Playlist> playListData = playListResponse.getItems();
                
                for(Playlist p : playListData) {
                    
                    try {
                        resultObj = new Gson().fromJson(p.toString(), YouTubeSearchDisplayBean.class);
                        
                        //to set manually default url
//                        resultObj.getSnippet().getThumbnails().getDefault().setUrl(p.getSnippet().getThumbnails().get("default").toString());
                        
                        arrObj.add(resultObj);
                        
                    } catch (Exception e) {
                        LOG.error("Error to add all play list in objects ",e);
                    }   
                    
                }
                
            }
            
            
        } catch (Exception e) {
            LOG.error(e.toString(),e);
        }
        returnObj.setArr(arrObj);
        return returnObj;
    }
    
}
