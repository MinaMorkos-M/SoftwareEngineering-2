package com.example.NotificationApi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.lang.NonNull;

import java.util.UUID;


public class NotificationTemplate {
    private final UUID ID ;
    @NonNull
    private String subject;
    @NonNull
    private String content;
    @NonNull
    private NotificationLanguage language;

    public NotificationTemplate( UUID ID,@JsonProperty("subject") String subject ,@JsonProperty("content") String content ,@JsonProperty("language") NotificationLanguage language){

            this.ID = ID;
            this.subject=subject;
            this.content=content;
            this.language=language;
    }

    public UUID getID(){
        return ID;
    }

    public void setSubject(String subject){
        this.subject=subject;
    }
    public String getSubject(){
        return subject;
    }

    public void setContent(String content){
        this.content=content;
    }
    public String getContent(){
        return content;
    }

    public void setLanguage(NotificationLanguage language){
        this.language=language;
    }
    public NotificationLanguage getLanguage(){
        return language;
    }
}
