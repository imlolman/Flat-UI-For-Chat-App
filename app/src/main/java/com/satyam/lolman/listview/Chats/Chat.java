package com.satyam.lolman.listview.Chats;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Handler;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.satyam.lolman.listview.OthersProfile;
import com.satyam.lolman.listview.R;
import com.satyam.lolman.listview.Recents.AdapterForRecentsList;
import com.satyam.lolman.listview.Recents.Recent_Chats;

import java.util.ArrayList;

public class Chat extends AppCompatActivity {


    ArrayList<Message> myList = new ArrayList<Message>();
    Message msg;
    TextView name;
    ImageView profilepic;
    ListView listView;
    boolean doubleBackToExitPressedOnce = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        setContent();
        name = findViewById(R.id.name);
        name.setText(getIntent().getStringExtra("name"));
        profilepic = findViewById(R.id.profilepic);
        profilepic.setImageBitmap(getCroppedBitmap(BitmapFactory.decodeResource(getBaseContext().getResources(),getIntent().getIntExtra("profilepic",R.drawable.small_profile))));
        listView = findViewById(R.id.chatListView);
        listView.setAdapter(new AdapterForChat(getBaseContext(), myList));

        profilepic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(getBaseContext(), OthersProfile.class);
                i2.putExtra("name",getIntent().getStringExtra("name"));
                i2.putExtra("profilepic",getIntent().getIntExtra("profilepic",R.drawable.small_profile));
                startActivity(i2);
                overridePendingTransition( R.anim.enter_from_right, R.anim.exit_to_left );
            }
        });
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

    @Override
    public void onBackPressed() {
        Intent i2 = new Intent(this, Recent_Chats.class);
        startActivity(i2);
        overridePendingTransition(R.anim.enter_from_left, R.anim.exit_to_right);
    }

    public void onBackPressed(View view) {
        onBackPressed();
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
