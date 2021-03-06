package com.satyam.lolman.listview.Recents;

import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.satyam.lolman.listview.R;

/**
 * Created by satya on 22-Mar-18.
 */

public class ViewHolderForRecentsList {

        ImageView profilePic;
        TextView name,lastMessage,lastMessageTime,unreadCount;
        ConstraintLayout online;

        public ViewHolderForRecentsList(View item) {
            profilePic = item.findViewById(R.id.profilePic);
            name = item.findViewById(R.id.name);
            lastMessage = item.findViewById(R.id.lastMessage);
            lastMessageTime = item.findViewById(R.id.lastMessageTime);
            online = item.findViewById(R.id.online);
            unreadCount = item.findViewById(R.id.unreadCount);
        }
}
