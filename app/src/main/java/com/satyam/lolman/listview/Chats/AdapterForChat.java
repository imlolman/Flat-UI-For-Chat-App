package com.satyam.lolman.listview.Chats;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.satyam.lolman.listview.R;

import java.util.ArrayList;

/**
 * Created by satya on 23-Mar-18.
 */

public class AdapterForChat extends BaseAdapter {

    ArrayList<Message> myList;
    LayoutInflater inflater;
    Context context;

    public AdapterForChat(Context context, ArrayList myList) {
        this.myList = myList;
        this.context = context;
        inflater = LayoutInflater.from(this.context);
    }

    @Override
    public int getCount() {
        return myList.size();
    }

    @Override
    public Object getItem(int position) {
        return myList.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolderForChat viewHolder;
        Message message = (Message) getItem(i);
        if(view == null) {
            if(message.sentByYou){
                view = inflater.inflate(R.layout.chat_right, viewGroup, false);
            }else {
                view = inflater.inflate(R.layout.chat_left, viewGroup, false);
            }
            viewHolder = new ViewHolderForChat(view);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolderForChat) view.getTag();
        }
        viewHolder.msgText.setText(message. getMsg());


        return view;
    }

}
