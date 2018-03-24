package com.satyam.lolman.listview;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.satyam.lolman.listview.Chats.Chat;
import com.satyam.lolman.listview.Recents.Recent_Chats;

public class OthersProfile extends AppCompatActivity {


    TextView name;
    ImageView profilepic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_profile);

        profilepic = findViewById(R.id.profilepic);
        name = findViewById(R.id.name);
        name.setText(getIntent().getStringExtra("name"));
        profilepic = findViewById(R.id.profilepic);
        profilepic.setImageBitmap(getCroppedBitmap(BitmapFactory.decodeResource(getBaseContext().getResources(),getIntent().getIntExtra("profilepic",R.drawable.small_profile))));
    }

    public void onBackPressed(View view) {
        onBackPressed();
    }


    @Override
    public void onBackPressed() {
        Intent i2 = new Intent(this, Chat.class);
        i2.putExtra("name",getIntent().getStringExtra("name"));
        i2.putExtra("profilepic",getIntent().getIntExtra("profilepic",R.drawable.small_profile));
        startActivity(i2);
        overridePendingTransition( R.anim.enter_from_left, R.anim.exit_to_right );
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
