package com.satyam.lolman.listview.Login;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.satyam.lolman.listview.R;

public class LoginActivity extends AppCompatActivity {

    FragmentActivity fragmentActivity;

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
        transaction.addToBackStack(String.valueOf(fragment_enter_number));
        transaction.commit();
    }
}
