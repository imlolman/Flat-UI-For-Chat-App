package com.satyam.lolman.listview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by satya on 22-Mar-18.
 */

public class AdapterForRecentsList extends BaseAdapter {

    ArrayList<DataForRecent> myList;
    LayoutInflater inflater;
    Context context;

    public AdapterForRecentsList(Context context, ArrayList myList) {
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
        ViewHolderForRecentsList viewHolder;
        if(view == null) {
            view = inflater.inflate(R.layout.list_row, viewGroup, false);
            viewHolder = new ViewHolderForRecentsList(view);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolderForRecentsList) view.getTag();
        }
        DataForRecent dataforsingle = (DataForRecent) getItem(i);
        viewHolder.profilePic.setImageResource(dataforsingle.getProfilePic());
        viewHolder.name.setText(dataforsingle. getName());
        viewHolder.lastMessage.setText(((dataforsingle.lastMessageIsYours)?"You: ":"")+dataforsingle.getLastMessage());
        if(dataforsingle.online) {
            viewHolder.online.setBackgroundResource(R.drawable.online);
        }else{
            viewHolder.online.setBackgroundResource(R.drawable.offline);
        }
        viewHolder.lastMessageTime.setText(dataforsingle. getLastMessageTime());

        return view;
    }


    public static Bitmap getBitmapFromURL(String src) {
        try {
            Log.e("src",src);
            URL url = new URL(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            Log.e("Bitmap","returned");
            return myBitmap;
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("Exception",e.getMessage());
            return null;
        }
    }

}
