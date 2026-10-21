package com.amaf.imamo;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RaharahaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setGravity(Gravity.CENTER);
        root.setBackgroundColor(Color.parseColor("#0D1220"));

        TextView label = new TextView(this);
        label.setText("RaharahaActivity\n\nMbola tsy vita ity pejy ity.\nHampidirina amin'ny fanavaozana manaraka.");
        label.setTextColor(Color.WHITE);
        label.setTextSize(16);
        label.setGravity(Gravity.CENTER);
        label.setPadding(60, 60, 60, 60);
        root.addView(label);

        setContentView(root);
    }
}
