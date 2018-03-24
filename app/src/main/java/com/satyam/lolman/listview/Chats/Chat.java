package com.satyam.lolman.listview.Chats;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.satyam.lolman.listview.R;
import com.satyam.lolman.listview.Recents.AdapterForRecentsList;

import java.util.ArrayList;

public class Chat extends AppCompatActivity {


    ArrayList<Message> myList = new ArrayList<Message>();
    Message msg;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        setContent();
        listView = findViewById(R.id.chatListView);
        listView.setAdapter(new AdapterForChat(getBaseContext(), myList));
    }

    private void setContent() {

        msg = new Message();
        msg.setAll("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas nec turpis at purus porttitor condimentum vitae vel urna. Aliquam blandit, ante vitae viverra dignissim, metus felis semper metus, in euismod mi ipsum at leo. Cras egestas ornare nunc, vel tempor sapien. Proin ac sodales tellus. Morbi et nibh non felis suscipit scelerisque.",false);
        myList.add(msg);
        msg = new Message();
        msg.setAll("Kaam Khraab kar dia",true);
        myList.add(msg);
        msg = new Message();
        msg.setAll("Q kya hua", false);
        myList.add(msg);
        msg = new Message();
        msg.setAll("Project Beech main Atak Gya", true);
        myList.add(msg);
        msg = new Message();
        msg.setAll("Ab Aage Kya?", false);
        myList.add(msg);
        msg = new Message();
        msg.setAll("Mandir wahi banega", true);
        myList.add(msg);
    }
}
