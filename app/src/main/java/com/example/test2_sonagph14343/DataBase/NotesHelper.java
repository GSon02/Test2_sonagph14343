package com.example.test2_sonagph14343.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.test2_sonagph14343.Model.Notes;

import java.util.ArrayList;
import java.util.List;

public class NotesHelper extends SQLiteOpenHelper {
    public NotesHelper(Context context) {
        super(context, "QLCONTENT", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE NOTES (NUMBER INTEGER PRIMARY KEY autoincrement,CONTENT NVARCHAR, DATE NVARCHAR)");
        db.execSQL("INSERT INTO NOTES VALUES (null,\"NOTES0\",\"YYYY-MM-DD\")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS NOTES");
        onCreate(db);
    }

    public long insertNOTES(Notes notes){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("CONTENT",notes.getContent());
        contentValues.put("DATE",notes.getDate());

        long result = sqLiteDatabase.insert("NOTES", null, contentValues);
        return result;
    }
    public long deleteNOTES(Notes notes){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        long result = sqLiteDatabase.delete("NOTES","CONTENT=?",new String[]{String.valueOf(notes.getContent())});
        return result;
    }

    public List<Notes> getAllNOTES(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        List<Notes> sachList = new ArrayList<>();
        String SELECT_AlL = "SELECT * FrOm NOTES";
        Cursor cursor = sqLiteDatabase.rawQuery(SELECT_AlL,null);
        if (cursor.getCount()>0){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                String Content = cursor.getString(cursor.getColumnIndex("CONTENT"));
                String Date = cursor.getString(cursor.getColumnIndex("DATE"));
                Notes notes = new Notes(Content,Date);
                sachList.add(notes);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return sachList;
    }
}
