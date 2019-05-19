package com.homeinhand;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import static android.content.ContentValues.TAG;

public class Room extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bedroom);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.BUTTON_MESSAGE);
        Log.i(TAG, "Button Pressed : " + message);
    }

    public Room() {
    }

    public Room(Button roomBtn) {
        Log.i(TAG, "Room class called");

    }
}
