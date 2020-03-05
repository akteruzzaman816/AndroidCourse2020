package com.bdtask.databasedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "student.db";
    Context  context;


    public Database(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(Student.STUDENT_QUERY);
        Toast.makeText(context, "db created", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE "+Student.STUDENT_NAME);
        onCreate(sqLiteDatabase);
    }


    public long insertData(Student student){

        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Student.STUDENT_NAME,student.getName());
        contentValues.put(Student.STUDENT_ADDRESS,student.getAddress());

        long id = db.insert(Student.STUDENT_TABLE,null,contentValues);


        return id;

    }


    public List<Student> getAllData(){

        List<Student> data = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor  = db.rawQuery("SELECT * FROM "+Student.STUDENT_TABLE,null);

        if (cursor.moveToFirst()){

            do {

                Student student = new Student();
                student.setId(cursor.getInt(cursor.getColumnIndex(Student.ID)));
                student.setName(cursor.getString(cursor.getColumnIndex(Student.STUDENT_NAME)));
                student.setAddress(cursor.getString(cursor.getColumnIndex(Student.STUDENT_ADDRESS)));

                data.add(student);


            }while (cursor.moveToNext());
        }




       return data;
    }


    public int updateData(Student student){

        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Student.STUDENT_NAME,student.getName());
        contentValues.put(Student.STUDENT_ADDRESS,student.getAddress());

        int id = db.update(Student.STUDENT_TABLE,contentValues,"id=?",new String[]{String.valueOf(student.getId())});


        return id;

    }

    public int deleteData(int id){

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        int status = sqLiteDatabase.delete(Student.STUDENT_TABLE,"id=?",new String[]{String.valueOf(id)});


        return status;

    }




}
