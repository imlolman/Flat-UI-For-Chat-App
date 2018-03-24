package com.satyam.lolman.listview.Recents;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import com.satyam.lolman.listview.R;
import java.util.ArrayList;
import java.util.Random;

public class Recent_Chats extends AppCompatActivity {


    ListView listView;
    int[] profilePics ={R.drawable.img0,R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5,R.drawable.img6,R.drawable.img7,R.drawable.img8};
    String[] recents = {"Chitransh  Rathore", "Samantha	Oliver", "Lisa	Pullman", "Christopher	Mackay", "Bernadette	Simpson", "Blake	Randall", "Jane	Robertson", "William	Blake", "Dominic	Marshall"};
    String[] msgs = {"Mandir Wahi Banega", "Lorem ipsum dolor sit amet", "In tempor malesuada nibh","at dignissim orci ultricies vestibulum","Nunc sit amet congue justo","vel lobortis metus"," Nulla posuere eget nibh"," Duis accumsan magna erat","Curabitur id mauris vel nisl venenatis"};
    ArrayList<DataForRecent> myList = new ArrayList<DataForRecent>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recent__chats);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        setContent();
        listView = findViewById(R.id.listview);
        listView.setAdapter(new AdapterForRecentsList(getBaseContext(), myList));
    }

    private void setContent() {
        int res = 0;

        for (int i = 1;i<=2;i++) {
            DataForRecent temp = new DataForRecent();
            Random rand = new Random();
            temp.setAll(profilePics[res],recents[res],msgs[res], rand.nextBoolean() ,rand.nextInt(12)+":"+rand.nextInt(50)+" "+((rand.nextBoolean())?"AM":"PM")  ,rand.nextBoolean(), true, rand.nextInt(100));
            res++;
            myList.add(temp);
        }

        for (int i = 4;i<=8;i++) {
            DataForRecent temp = new DataForRecent();
            Random rand = new Random();
            temp.setAll(profilePics[res],recents[res],msgs[res], rand.nextBoolean() ,rand.nextInt(12)+":"+rand.nextInt(50)+" "+((rand.nextBoolean())?"AM":"PM")  ,rand.nextBoolean(),false,rand.nextInt(100));
            res++;
            myList.add(temp);
        }
        for (int i = 9;i<=9;i++) {
            DataForRecent temp = new DataForRecent();
            Random rand = new Random();
            temp.setAll(profilePics[res],recents[res],msgs[res], rand.nextBoolean() ,rand.nextInt(12)+":"+rand.nextInt(50)+" "+((rand.nextBoolean())?"AM":"PM")  ,rand.nextBoolean(),rand.nextBoolean(),rand.nextInt(100));
            res++;
            myList.add(temp);
        }
    }
}
