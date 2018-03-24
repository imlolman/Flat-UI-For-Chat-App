package com.satyam.lolman.listview.Login;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.satyam.lolman.listview.R;
import com.satyam.lolman.listview.Recents.Recent_Chats;

public class LoginActivity extends AppCompatActivity {

    FragmentActivity fragmentActivity;
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EnterNumber fragment_enter_number = new EnterNumber();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left,R.anim.enter_from_left, R.anim.exit_to_right);
        fragmentTransaction.add(R.id.frameLayout,fragment_enter_number);
        fragmentTransaction.commit();
    }

    public void sendotp(View view) {
        EnterNumber fragment_enter_number = new EnterNumber();
        VerifyOTP fragment_verify_otp = new VerifyOTP();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left,R.anim.enter_from_left, R.anim.exit_to_right);
        transaction.replace(R.id.frameLayout, fragment_verify_otp);
        transaction.commit();
        otpSendingMethod();
    }

    private void otpSendingMethod(){
        // Sending Server a Request To Send OTP
    }

    private boolean otpValidatingMethod(){
        // Validate OTP, return true if validated
        return true;
    }

    public void resendotp(View view) {
        // Check how many times otp has been sent and Create a resending method
    }

    public void setname(View view) {
        // Setname
        gotorecents();
    }

    public void validateotp(View view) {
        if(otpValidatingMethod()){
            EnterName fragment_enter_name = new EnterName();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left,R.anim.enter_from_left, R.anim.exit_to_right);
            transaction.replace(R.id.frameLayout, fragment_enter_name);
            transaction.commit();
            otpSendingMethod();
        }else{
            Toast toast = Toast.makeText(this,"OTP Incorrect, Please Try Again",Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(getApplicationContext(), "Please click BACK again to exit", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }

    public void editnumber(View view) {
        EnterNumber fragment_enter_number = new EnterNumber();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right);
        fragmentTransaction.replace(R.id.frameLayout,fragment_enter_number);
        fragmentTransaction.commit();
    }

    private void gotorecents(){
        Intent i2 = new Intent(this, Recent_Chats.class);
        startActivity(i2);
        overridePendingTransition( R.anim.enter_from_right, R.anim.exit_to_left );
    }
}
