package com.example.grant.followthelead;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

import java.util.Vector;


public class DBHandler extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "data.db";
    public static final String TABLE_LEAD = "Leads";
    public static final String COLUMN_LEADID = "_id";
    public static final String COLUMN_PHONENUMBER = "phoneNumber";
    public static final String COLUMN_ADDRESS = "address";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_VEHICLEMAKE = "vehicleMake";
    public static final String COLUMN_VEHICLEMODEL = "vehicleModel";
    public static final String COLUMN_VEHICLEYEAR = "vehicleYear";
    public static final String COLUMN_DLNUM = "dlNum";
    public static final String COLUMN_SPOUSENAME = "spouseName";
    public static final String COLUMN_SPOUSEDLNUM = "spouseDL";
    public static final String COLUMN_CURRENTINSURANCEPROVIDER = "currentInsuranceProvider";
    public static final String COLUMN_LIABILITYLIMIT = "liabilityLimit";
    public static final String COLUMN_COLLISIONDEDUCTABLE = "collisionDeductable";
    public static final String COLUMN_COMPREHENSIVEDEDUCTABLE = "comprehensiveDeductible";
    public static final String COLUMN_CARRIER = "carrier";
    public static final String COLUMN_RENT = "rent";
    public static final String COLUMN_OWN = "own";
    public static final String COLUMN_HOMEINSUREDBYCARRIER = "homeInsuredByCarrier";
    public static final String COLUMN_HOMEINSURANCECARRIER = "homeInsuranceCarrier";
    public static final String COLUMN_HOMECOVERAGEAMOUNT = "homeCoverageAmount";
    public static final String COLUMN_ADDITIONALINFO = "additionalInfo";
    public static final String COLUMN_ASSOCIATEDEVENT = "associatedEvent";
    //add rest of fields on contact form

    public static final String TABLE_EVENT = "Events";
    public static final String COLUMN_EVENTID = "_eventID";
    public static final String COLUMN_EVENTNAME = "eventName";
    public static final String COLUMN_EVENTSPONSOR = "eventSponsor";
    public static final String COLUMN_EVENTLOCATION = "eventLocation";
    public static final String COLUMN_EVENTDATE = "eventDate";

    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query1 = "CREATE TABLE " + TABLE_LEAD + "(" +
            //add all fields here to create collumns
                COLUMN_LEADID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_EMAIL + " TEXT, " +
                COLUMN_ADDRESS + " TEXT, " +
                COLUMN_DLNUM + " TEXT, " +
                COLUMN_PHONENUMBER + " TEXT," +
                COLUMN_SPOUSENAME + " TEXT, " +
                COLUMN_SPOUSEDLNUM + " TEXT, " +
                COLUMN_CURRENTINSURANCEPROVIDER + " TEXT, " +
                COLUMN_VEHICLEMAKE + " TEXT, " +
                COLUMN_VEHICLEMODEL + " TEXT, " +
                COLUMN_VEHICLEYEAR + " TEXT, " +
                COLUMN_COLLISIONDEDUCTABLE + " TEXT, " +
                COLUMN_COMPREHENSIVEDEDUCTABLE + " TEXT, " +
                COLUMN_LIABILITYLIMIT + " TEXT, " +
                COLUMN_CARRIER + " TEXT, " +
                COLUMN_RENT + " TEXT, " +
                COLUMN_OWN + " TEXT, " +
                COLUMN_HOMEINSUREDBYCARRIER + " TEXT, " +
                COLUMN_HOMEINSURANCECARRIER + " TEXT,  " +
                COLUMN_HOMECOVERAGEAMOUNT + " TEXT, " +
                COLUMN_ASSOCIATEDEVENT + " TEXT,  " +
                COLUMN_ADDITIONALINFO + " TEXT, " +
                "PRIMARY KEY (LEADID));";

        String query2 = "CREATE TABLE " + TABLE_EVENT + "(" +
                COLUMN_EVENTID + "INTEGER PRIMARY KEY AUTOINCREMENT ," +
                COLUMN_EVENTNAME + " TEXT, " +
                COLUMN_EVENTLOCATION + " TEXT, " +
                COLUMN_EVENTSPONSOR + " TEXT," +
                COLUMN_EVENTDATE + " TEXT, " +
                " PRIMARY KEY (EVENTID));";


        db.execSQL(query1);
        db.execSQL(query2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EVENT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LEAD);
        onCreate(db);
    }

    public void addLead(Lead lead) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, lead.get_name());
        values.put(COLUMN_PHONENUMBER, lead.get_phoneNumber());
        values.put(COLUMN_ADDRESS, lead.getAddress());
        values.put(COLUMN_EMAIL, lead.getEmail());
        values.put(COLUMN_DLNUM, lead.get_dlNum());
        values.put(COLUMN_SPOUSENAME, lead.getSpouseName());
        values.put(COLUMN_SPOUSEDLNUM, lead.getSpouseDL());
        values.put(COLUMN_VEHICLEMAKE, lead.getVehicleMake());
        values.put(COLUMN_VEHICLEMODEL, lead.getVehicleModel());
        values.put(COLUMN_VEHICLEYEAR, lead.getVehicleYear());
        values.put(COLUMN_COLLISIONDEDUCTABLE, lead.getCollisionDeductible());
        values.put(COLUMN_COMPREHENSIVEDEDUCTABLE, lead.getComprehensiveDeductible());
        values.put(COLUMN_LIABILITYLIMIT, lead.getLiabilityLimit());
        values.put(COLUMN_CURRENTINSURANCEPROVIDER, lead.getCurrentInsuranceProvider());
        values.put(COLUMN_CARRIER, lead.getCarrier());
        values.put(COLUMN_OWN, lead.isOwn());
        values.put(COLUMN_RENT, lead.isRent());
        values.put(COLUMN_HOMECOVERAGEAMOUNT, lead.getHomeCoverageAmount());
        values.put(COLUMN_HOMEINSUREDBYCARRIER, lead.isHomeInsuredByCarrier());
        values.put(COLUMN_HOMEINSURANCECARRIER, lead.getHomeInsuranceCarrier());
        values.put(COLUMN_ASSOCIATEDEVENT, lead.getAssociatedEvent().getEventName());
        values.put(COLUMN_ADDITIONALINFO, lead.getAdditionalInfo());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_LEAD, null, values);
        db.close();

    }

    public void addEvent(Event event) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_EVENTNAME, event.getEventName());
        values.put(COLUMN_EVENTLOCATION, event.getEventLocation());
        values.put(COLUMN_EVENTSPONSOR, event.getEventSponsor());
        values.put(COLUMN_EVENTDATE, event.getEventDate());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_EVENT, null, values);
        db.close();
    }

    public void removeLead(Lead lead) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_LEAD + " WHERE " + COLUMN_DLNUM + "=\"" + lead.get_dlNum() + "\"");
        db.close();
    }

    public void removeEvent(Event event) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_LEAD + " WHERE " + COLUMN_EVENTNAME + "=\"" + event.getEventName() + "\"");
        db.close();
    }

    public Vector<String> getEventNames() {
        Vector<String> eventNames = new Vector<String>();
        String query = "SELECT " + COLUMN_EVENTNAME + " FROM " + TABLE_EVENT;
        SQLiteDatabase db = getWritableDatabase();

        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();
        while(!(c.isAfterLast())) {
            if(c.getString(c.getColumnIndex(COLUMN_EVENTNAME)) != null)
                eventNames.add(c.getString(c.getColumnIndex(COLUMN_EVENTNAME)));
        }
        db.close();
        return eventNames;
    }
}
