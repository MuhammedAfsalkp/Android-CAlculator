package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button bt1, bt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        bt1 = (Button) findViewById(R.id.btone);
        bt2 = (Button) findViewById(R.id.bttwo);


    }

    public void oneClick(View View) {
        String btext;
        btext = ((Button) View).getText().toString();
        if (btext.equals("OPEN")) {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intent);
        } else if (btext.equals("CREATOR")) {
            Intent ct = new Intent(MainActivity.this, MainActivity3.class);
            startActivity(ct);

        }
    }
}