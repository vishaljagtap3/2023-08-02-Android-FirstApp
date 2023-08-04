package com.bitcodetech.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private LinearLayout container;
    private TextView txtName;
    private EditText edtName;
    private Button btnSetName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        container = new LinearLayout(this);
        container.setOrientation(LinearLayout.VERTICAL);
        container.setLayoutParams( new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT) );
        container.setGravity(Gravity.CENTER);
        container.setPadding(20, 20, 20, 20);

        txtName = new TextView(this);
        txtName.setBackgroundColor(Color.BLACK);
        txtName.setTextColor(Color.WHITE);
        txtName.setText("Welcome");
        txtName.setTextSize(30);
        txtName.setLayoutParams( new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT) );
        container.addView(txtName);

        edtName = new EditText(this);
        edtName.setLayoutParams( new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT) );
        container.addView(edtName);

        btnSetName = new Button(this);
        btnSetName.setText("Set Name");
        btnSetName.setLayoutParams( new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT) );
        container.addView(btnSetName);

        //way 1 of listening to events
        //btnSetName.setOnTouchListener( new OnBtnSetNameTouchListener() );
        //btnSetName.setOnKeyListener(new OnBtnSetNameKeyListener());

        //way 2
        btnSetName.setOnClickListener(new OnBtnSetNameClickListener());

        //way 3
        txtName.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        txtName.setText("");
                    }
                }
        );

        setContentView(container);

    }

    private class OnBtnSetNameClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            txtName.setText( edtName.getText().toString());
        }
    }

    class OnBtnSetNameTouchListener implements View.OnTouchListener {

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            txtName.setText( edtName.getText().toString());
            return false;
        }
    }

    class OnBtnSetNameKeyListener implements View.OnKeyListener {
        @Override
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            txtName.setText( edtName.getText().toString());
            return false;
        }
    }


    void clearName() {
        txtName.setText("");
    }
}