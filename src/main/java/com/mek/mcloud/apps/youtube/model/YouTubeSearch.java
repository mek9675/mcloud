/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mek.mcloud.apps.youtube.model;

import com.mek.mcloud.config.ConfigMapper;

/**
 *
 * @author root
 */
public class YouTubeSearch {
    
    private String q;
    private String duration;
    private String sort;
    private String features;
    private String resultType;
    private String uploadDate;
//    private String maxResults = ConfigMapper.getYoutubeResource().getProperty("youtube.search.maxresults.count");
    private Long maxResults;

    public Long getMaxResults() {
        return maxResults;
    }

    public void setMaxResults(Long maxResults) {
        this.maxResults = maxResults;
    }

//    public String getMaxResults() {
//        return maxResults;
//    }
//
//    public void setMaxResults(String maxResults) {
//        this.maxResults = maxResults;
//    }
    
    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }
    
    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }
    
}
