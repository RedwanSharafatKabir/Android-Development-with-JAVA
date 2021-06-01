package com.example.sqlitedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;
import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    static final String DATABASE_NAME = "Student.db";
    static final String TABLE_NAME = "Student_Details";
    /* Each time after modifying create table command we have to change the version number
    otherwise onUpgrade() method will not be called */
    static final int VERSION_NUMBER = 2;
    static final String ID = "Id";
    static final String NAME = "Name";
    static final String AGE = "Age";
    static final String GENDER = "Gender";
    Context context;
    static final String CREATE_TABLE_COMMAND = "CREATE TABLE " + TABLE_NAME + "( " + ID +
            " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " VARCHAR(255), " + AGE + " INTEGER, "
            + GENDER + " VARCHAR(10));";
    static final String DROP_TABLE_COMMAND = "DROP TABLE IF EXISTS " + TABLE_NAME;
    static final String SHOW_ALL_DATA_COMMAND = "SELECT * FROM " + TABLE_NAME;

    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION_NUMBER);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try{
            sqLiteDatabase.execSQL(CREATE_TABLE_COMMAND);
            Toast.makeText(context, "Database created successfully", Toast.LENGTH_LONG).show();
        } catch (Exception e){
            Toast.makeText(context, "Exception: " + e, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        try {
            sqLiteDatabase.execSQL(DROP_TABLE_COMMAND);
            Toast.makeText(context, "Database upgraded successfully", Toast.LENGTH_LONG).show();
            onCreate(sqLiteDatabase);
        } catch (Exception e){
            Toast.makeText(context, "Exception: " + e, Toast.LENGTH_SHORT).show();
        }
    }

    // Insert data into Student.db database
    public long insertData(String name, String age, String gender){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, name);
        contentValues.put(AGE, age);
        contentValues.put(GENDER, gender);
        long rowId = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);

        return  rowId;
    }

    // Retrieve data from Student.db database
    public Cursor retrieveData(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(SHOW_ALL_DATA_COMMAND, null);

        return cursor;
    }

    public boolean updateData(String id, String name, String age, String gender){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID, id);
        contentValues.put(NAME, name);
        contentValues.put(AGE, age);
        contentValues.put(GENDER, gender);
        sqLiteDatabase.update(TABLE_NAME, contentValues, ID + " = ?", new String[]{id});

        return true;
    }

    public Integer deleteData(String id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.delete(TABLE_NAME, ID + " = ?", new String[]{id});
    }
}
