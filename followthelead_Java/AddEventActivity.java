package com.example.grant.followthelead;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Date;

public class AddEventActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.grant.followthelead.MESSAGE";
    public  DBHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new DBHandler(this, null, null, 1, null);
        setContentView(R.layout.activity_add_event);
    }

    public void createEvent(View view) { // Called when user presses create button
        boolean validInput = true;
        EditText eventName = (EditText) findViewById(R.id.eventName);
        String name = eventName.getText().toString();
        EditText eventSponsor = (EditText) findViewById(R.id.eventSponsor);
        String sponsor = eventSponsor.getText().toString();
        EditText eventLocation = (EditText) findViewById(R.id.eventLocation);
        String location = eventLocation.getText().toString();
        EditText eventDate = (EditText) findViewById(R.id.eventDate);
        String date = eventDate.getText().toString();
        if(name.isEmpty()) {
            eventName.setBackgroundColor(Color.RED);
            validInput = false;
        }
        if(sponsor.isEmpty()) {
            eventSponsor.setBackgroundColor(Color.RED);
            validInput = false;
        }
        if(location.isEmpty()) {
            eventLocation.setBackgroundColor(Color.RED);
            validInput = false;
        }

        if(validInput) {
            Event event  = new Event(name, sponsor, location);
            db.addEvent(event);
            Intent intent = new Intent(this, EventList.class);
            startActivity(intent);
        }
    }
}
