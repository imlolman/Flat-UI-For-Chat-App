package com.satyam.lolman.listview.Chats;

/**
 * Created by satya on 23-Mar-18.
 */

public class Message {
    String msg;
    Boolean sentByYou;

    public void setAll(String msg, Boolean sentByYou){
        this.msg = msg;
        this.sentByYou = sentByYou;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Boolean getSentByYou() {
        return sentByYou;
    }

    public void setSentByYou(Boolean sentByYou) {
        this.sentByYou = sentByYou;
    }
}
