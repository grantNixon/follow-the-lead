package com.example.grant.followthelead;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.Vector;

public class EventList extends AppCompatActivity {
    public DBHandler db;
    LinearLayout rootContainer = findViewById(R.id.rootContainer);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);
        db = new DBHandler(this, null, null, 1, null);
        Vector<String> eventNames = db.getEventNames();
        //populate screen with icons for events
        for(int i = 0; i < eventNames.size(); i++) {
            if(rootContainer.getChildCount() == 0 || (i + 1) % 3 == 0) { //add new row for icons when needed
                TableLayout table = findViewById(R.id.rootContainer);
                TableRow row = new TableRow(table.getContext());
                row.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
                row.setId(rootContainer.getChildCount());
                rootContainer.addView(row);
            }
            Button eventIcon = new Button(this);
            eventIcon.setText(eventNames.elementAt(i));
            final float scale = this.getResources().getDisplayMetrics().density; //set dimensions and margin of button
            int pixels = (int) (100 * scale + 0.5f);
            eventIcon.setWidth(pixels);
            eventIcon.setHeight(pixels);
            pixels = (int) (10 * scale + 0.5f);
            setMargins(eventIcon, pixels, pixels, pixels, pixels);
            eventIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //display option to view or export
                }
            });
            TableRow tempRow = findViewById(rootContainer.getChildCount());
            tempRow.addView(eventIcon); //add button to most recently created row
        }
    }
    private void setMargins (View view, int left, int top, int right, int bottom) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            p.setMargins(left, top, right, bottom);
            view.requestLayout();
        }
    }
}
