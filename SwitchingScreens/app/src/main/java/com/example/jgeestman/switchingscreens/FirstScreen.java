package com.example.jgeestman.switchingscreens;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class FirstScreen extends Activity {

    private SharedPreferences sharedPrefs;
    private SharedPreferences.Editor sharedPrefEditor;
    private static final int PREFERENCE_MODE_PRIVATE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen);

        sharedPrefs = getSharedPreferences("userData", MODE_PRIVATE);
        String lastName = sharedPrefs.getString("lastUserName", null);

        if (lastName != null){
            TextView welcomeText = (TextView) findViewById(R.id.welcomeText);
            welcomeText.setText("Welcome Back " + lastName);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_first_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void passNameToSecondActivity(View view) {

        final String userInput = ((TextView)findViewById(R.id.editBox)).getText().toString();
        if (userInput.equals("")){
            Toast.makeText(this, "Please enter a name", Toast.LENGTH_SHORT).show();
        } else {
            Intent checkNumberScreenIntent = new Intent(this, SecondScreen.class);
            checkNumberScreenIntent.putExtra("userName", userInput);
            sharedPrefEditor = sharedPrefs.edit();
            sharedPrefEditor.putString("lastUserName", userInput);
            sharedPrefEditor.commit();

            startActivity(checkNumberScreenIntent);
        }
    }
}
