package com.satyam.lolman.listview;

import android.content.res.Resources;

/**
 * Created by satya on 22-Mar-18.
 */

public class DataForRecent {
    int profilePic;
    String name;
    String lastMessage;
    Boolean lastMessageIsYours;
    String lastMessageTime;

    Boolean online;

    public void setAll(int profilePic, String name, String lastMessage, Boolean lastMessageIsYours,String lastMessageTime, Boolean online) {
        this.profilePic = profilePic;
        this.name = name;
        this.lastMessage = lastMessage;
        this.lastMessageIsYours = lastMessageIsYours;
        this.lastMessageTime = lastMessageTime;
        this.online = online;
    }

    public int getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(int profilePic) {
        this.profilePic = profilePic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public Boolean getLastMessageIsYours() {
        return lastMessageIsYours;
    }

    public void setLastMessageIsYours(Boolean lastMessageIsYours) {
        this.lastMessageIsYours = lastMessageIsYours;
    }

    public String getLastMessageTime() {
        return lastMessageTime;
    }

    public void setLastMessageTime(String lastMessageTime) {
        this.lastMessageTime = lastMessageTime;
    }

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }
}
