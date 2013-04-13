/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mek.mcloud.apps.youtube.model;

import com.google.api.client.util.Key;
import com.google.common.primitives.UnsignedLong;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author root
 */
public class YouTubeSearchDisplayBean {
    
    private String etag;
    private String id;
    private String kind;
    
    private ContentDetails contentDetails;
    
    private Player player;
    
    private Snippet snippet;
    
    private Statistics statistics;
    
    private Status status;
    
    private Topic topicDetails;

    public Snippet getSnippet() {
        return snippet;
    }

    public void setSnippet(Snippet snippet) {
        this.snippet = snippet;
    }

    public Statistics getStatistics() {
        return statistics;
    }

    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Topic getTopicDetails() {
        return topicDetails;
    }

    public void setTopicDetails(Topic topicDetails) {
        this.topicDetails = topicDetails;
    }

    public ContentDetails getContentDetails() {
        return contentDetails;
    }

    public void setContentDetails(ContentDetails contentDetails) {
        this.contentDetails = contentDetails;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }
        
    public class ContentDetails {
        
        private String duration;
        private String dimension;
        private String definition;
        private String caption;
        private String licensedContent;
        
        //specific for playlistitem
        private String videoId;
        
        private RelatedPlayList relatedPlaylists;

        public String getVideoId() {
            return videoId;
        }

        public void setVideoId(String videoId) {
            this.videoId = videoId;
        }

        public RelatedPlayList getRelatedPlaylists() {
            return relatedPlaylists;
        }

        public void setRelatedPlaylists(RelatedPlayList relatedPlaylists) {
            this.relatedPlaylists = relatedPlaylists;
        }
        
        public String getCaption() {
            return caption;
        }

        public void setCaption(String caption) {
            this.caption = caption;
        }

        public String getDefinition() {
            return definition;
        }

        public void setDefinition(String definition) {
            this.definition = definition;
        }

        public String getDimension() {
            return dimension;
        }

        public void setDimension(String dimension) {
            this.dimension = dimension;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public String getLicensedContent() {
            return licensedContent;
        }

        public void setLicensedContent(String licensedContent) {
            this.licensedContent = licensedContent;
        }
        
        public class RelatedPlayList {
            private String uploads;
            

            public String getUploads() {
                return uploads;
            }

            public void setUploads(String uploads) {
                this.uploads = uploads;
            }
        }
        
    }
    
    public class Player {
        
        private String embedHtml;

        public String getEmbedHtml() {
            return embedHtml;
        }

        public void setEmbedHtml(String embedHtml) {
            this.embedHtml = embedHtml;
        }        
        
    }
    
    public class Snippet {
        private String categoryId;
        private String channelId;
        private String description;
        private String publishedAt;
        private Thumbnail thumbnails;
        private String title;
        private String channelTitle;
        private String position;
        
        //specific for playlist
        private String playlistId;
        private Resource resourceId;

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public Resource getResourceId() {
            return resourceId;
        }

        public void setResourceId(Resource resourceId) {
            this.resourceId = resourceId;
        }

        public String getPlaylistId() {
            return playlistId;
        }

        public void setPlaylistId(String playlistId) {
            this.playlistId = playlistId;
        }
        
        public String getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(String categoryId) {
            this.categoryId = categoryId;
        }

        public String getChannelId() {
            return channelId;
        }

        public void setChannelId(String channelId) {
            this.channelId = channelId;
        }

        public String getChannelTitle() {
            return channelTitle;
        }

        public void setChannelTitle(String channelTitle) {
            this.channelTitle = channelTitle;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public Thumbnail getThumbnails() {
            return thumbnails;
        }

        public void setThumbnails(Thumbnail thumbnails) {
            this.thumbnails = thumbnails;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
        
        public class Thumbnail {
            
            @Key(value = "default")
            private Default youtubeDefault;
            private Medium medium;
            private High high;

            public High getHigh() {
                return high;
            }

            public void setHigh(High high) {
                this.high = high;
            }

            public Medium getMedium() {
                return medium;
            }

            public void setMedium(Medium medium) {
                this.medium = medium;
            }

            public Default getDefault() {
                return youtubeDefault;
            }

            public void setDefault(Default youtubeDefault) {
                this.youtubeDefault = youtubeDefault;
            }
             
             
            public class Default {
                
                
                private String url;

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
                
            }
            public class Medium {
                
                
                private String url;

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
                
            }
            public class High {
                
                
                private String url;

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
                
            }
            
        }
        
        public class Resource {
            
            private String kind;
            private String videoId;

            public String getKind() {
                return kind;
            }

            public void setKind(String kind) {
                this.kind = kind;
            }

            public String getVideoId() {
                return videoId;
            }

            public void setVideoId(String videoId) {
                this.videoId = videoId;
            }
            
        }
        
        
    }
    
    public class Statistics {
        
        private String commentCount;
        private String dislikeCount;
        private String favoriteCount;
        private String likeCount;
        private String viewCount;
        
        //specific for Channel
        private String subscriberCount;

        public String getSubscriberCount() {
            return subscriberCount;
        }

        public void setSubscriberCount(String subscriberCount) {
            this.subscriberCount = subscriberCount;
        }
        
        public String getCommentCount() {
            return commentCount;
        }

        public void setCommentCount(String commentCount) {
            this.commentCount = commentCount;
        }

        public String getDislikeCount() {
            return dislikeCount;
        }

        public void setDislikeCount(String dislikeCount) {
            this.dislikeCount = dislikeCount;
        }

        public String getFavoriteCount() {
            return favoriteCount;
        }

        public void setFavoriteCount(String favoriteCount) {
            this.favoriteCount = favoriteCount;
        }

        public String getLikeCount() {
            return likeCount;
        }

        public void setLikeCount(String likeCount) {
            this.likeCount = likeCount;
        }

        public String getViewCount() {
            return viewCount;
        }

        public void setViewCount(String viewCount) {
            this.viewCount = viewCount;
        }
        
        
    }

    public class Status {
        
        public String privacyStatus;
        public String uploadStatus;
        public String license;
        public String embeddable;
        public String publicStatsViewable;

        public String getEmbeddable() {
            return embeddable;
        }

        public void setEmbeddable(String embeddable) {
            this.embeddable = embeddable;
        }

        public String getLicense() {
            return license;
        }

        public void setLicense(String license) {
            this.license = license;
        }

        public String getPrivacyStatus() {
            return privacyStatus;
        }

        public void setPrivacyStatus(String privacyStatus) {
            this.privacyStatus = privacyStatus;
        }

        public String getPublicStatsViewable() {
            return publicStatsViewable;
        }

        public void setPublicStatsViewable(String publicStatsViewable) {
            this.publicStatsViewable = publicStatsViewable;
        }

        public String getUploadStatus() {
            return uploadStatus;
        }

        public void setUploadStatus(String uploadStatus) {
            this.uploadStatus = uploadStatus;
        }
    }

    public class Topic {
        
        private List<String> topicIds = new ArrayList<String>();

        public List<String> getTopicIds() {
            return topicIds;
        }

        public void setTopicIds(List<String> topicIds) {
            this.topicIds = topicIds;
        }
        
    }
}
