/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mek.mcloud.apps.youtube.model;

import com.google.api.services.youtube.model.PageInfo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author root
 */
public class YouTubeSearchDisplayBeanArray {
    
    private List<YouTubeSearchDisplayBean> arr = new ArrayList<YouTubeSearchDisplayBean>();
    private PageInfo pageInfo;
    private String nextPageToken;
    private String prevPageToken;
    
    public List<YouTubeSearchDisplayBean> getArr() {
        return arr;
    }

    public void setArr(List<YouTubeSearchDisplayBean> arr) {
        this.arr = arr;
    }

    public String getNextPageToken() {
        return nextPageToken;
    }

    public void setNextPageToken(String nextPageToken) {
        this.nextPageToken = nextPageToken;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public String getPrevPageToken() {
        return prevPageToken;
    }

    public void setPrevPageToken(String prevPageToken) {
        this.prevPageToken = prevPageToken;
    }
    
}
