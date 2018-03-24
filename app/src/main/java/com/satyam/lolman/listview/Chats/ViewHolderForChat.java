package com.satyam.lolman.listview.Chats;

import android.view.View;
import android.widget.TextView;

import com.satyam.lolman.listview.R;

import org.w3c.dom.Text;

/**
 * Created by satya on 23-Mar-18.
 */

public class ViewHolderForChat {

    TextView msgText;

    public ViewHolderForChat(View item){
        msgText = item.findViewById(R.id.msgText);
    }
}
