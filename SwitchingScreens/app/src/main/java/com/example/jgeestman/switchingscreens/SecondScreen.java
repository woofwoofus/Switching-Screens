package com.example.jgeestman.switchingscreens;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondScreen extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);

        Intent activityThatCalled = getIntent();

        String userInput = activityThatCalled.getExtras().getString("userName");

        TextView chosenNameMessage = (TextView) findViewById(R.id.chosen_name_message);

        chosenNameMessage.append(" " + userInput);
    }

    public void backToFirst(View view) {
        Intent backToFirstScreen = new Intent(this, FirstScreen.class);

        startActivity(backToFirstScreen);

    }
}
