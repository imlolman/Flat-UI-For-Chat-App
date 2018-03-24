package com.satyam.lolman.listview.Recents;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.satyam.lolman.listview.R;

import java.util.ArrayList;

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
        DataForRecent dataforsingle = (DataForRecent) getItem(i);
        if(view == null) {
            if(dataforsingle.unread){
                view = inflater.inflate(R.layout.list_row_unread, viewGroup, false);
            }else {
                view = inflater.inflate(R.layout.list_row, viewGroup, false);
            }
            viewHolder = new ViewHolderForRecentsList(view);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolderForRecentsList) view.getTag();
        }
        viewHolder.profilePic.setImageBitmap(getCroppedBitmap(BitmapFactory.decodeResource(context.getResources(),dataforsingle.getProfilePic())));;
        viewHolder.name.setText(dataforsingle. getName());
        viewHolder.lastMessage.setText(((dataforsingle.lastMessageIsYours)?"You: ":"")+dataforsingle.getLastMessage());
        if(dataforsingle.unread){
            viewHolder.unreadCount.setText(Integer.toString(dataforsingle. getUnreadCount()));
        }
        if(dataforsingle.online) {
            viewHolder.online.setBackgroundResource(R.drawable.online);
        }else{
            viewHolder.online.setBackgroundResource(R.drawable.offline);
        }
        viewHolder.lastMessageTime.setText(dataforsingle. getLastMessageTime());

        return view;
    }


    public Bitmap getCroppedBitmap(Bitmap bitmap) {
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
                bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        // canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
        canvas.drawCircle(bitmap.getWidth() / 2, bitmap.getHeight() / 2,
                bitmap.getWidth() / 2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        //Bitmap _bmp = Bitmap.createScaledBitmap(output, 60, 60, false);
        //return _bmp;
        return output;
    }

}
