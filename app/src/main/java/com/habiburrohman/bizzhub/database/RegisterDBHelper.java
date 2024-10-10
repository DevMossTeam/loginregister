package com.habiburrohman.bizzhub.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.habiburrohman.bizzhub.model.Person;

public class RegisterDBHelper extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "BIZZHUB.db";


    private static final String TABLE_PERSON = "person";
    private static final String COLUMN_FULLNAME = "fullname";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_BDATE = "bdate";
    private static final String COLUMN_GENDER = "gender";
    private static final String COLUMN_NOHP = "nohp";
    private static final String COLUMN_ALAMAT = "alamat";
    private static final String COLUMN_PASSWORD = "password";


    public RegisterDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_PERSON + "("
                + COLUMN_USERNAME + " TEXT PRIMARY KEY,"
                + COLUMN_FULLNAME + " TEXT,"
                + COLUMN_EMAIL + " TEXT,"
                + COLUMN_BDATE + " TEXT,"
                + COLUMN_GENDER + " TEXT,"
                + COLUMN_NOHP + " TEXT,"
                + COLUMN_ALAMAT + " TEXT,"
                + COLUMN_PASSWORD + " TEXT" + ")";
        db.execSQL(CREATE_USER_TABLE); // Execute the SQL query
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PERSON);
        onCreate(db);
    }

    public void addPerson(Person person){
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            values.put(COLUMN_USERNAME, person.getUsername());
            values.put(COLUMN_FULLNAME, person.getFullname());
            values.put(COLUMN_EMAIL, person.getEmail());
            values.put(COLUMN_BDATE, person.getBdate());
            values.put(COLUMN_GENDER, person.getGender());
            values.put(COLUMN_NOHP, person.getNohp());
            values.put(COLUMN_ALAMAT, person.getAlamat());
            values.put(COLUMN_PASSWORD, person.getPassword());

            // Insert data into the table
            long result = db.insert(TABLE_PERSON, null, values);
            if (result != -1) {
                db.setTransactionSuccessful(); // Mark transaction as successful if insert is successful
            } else {
                Log.d("RegisterDBHelper", "Failed to insert person data");
            }
        } catch (Exception e) {
            Log.d("Register Activity", e.getMessage());
        } finally {
            db.endTransaction();
        }
    }


}
