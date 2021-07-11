package com.example.firstaid;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


public class personal_info extends AppCompatActivity {
    SQLiteDatabase db;
    Button deleteButton, updateButton, insertButton;
    EditText nameIn, ageIn, genderIn, weightIn, heightIn, bloodIn, noteIn, contactIn;
    String id;

    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_info_layout);

        db = openOrCreateDatabase("InfoDB", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS UserData(Id VARCHAR, Name VARCHAR, Age VARCHAR, Gender VARCHAR, Weight VARCHAR, Height VARCHAR ,Blood VARCHAR, Note VARCHAR, Contact VARCHAR)");

        id = "1";
        nameIn = findViewById(R.id.nameInput);
        ageIn = findViewById(R.id.ageInput);
        genderIn = findViewById(R.id.genderInput);
        weightIn = findViewById(R.id.weightInput);
        heightIn = findViewById(R.id.heightInput);
        bloodIn = findViewById(R.id.bloodInput);
        noteIn = findViewById(R.id.noteInput);
        contactIn = findViewById(R.id.contactInput);

        deleteButton = findViewById(R.id.deleteInfo);
        updateButton = findViewById(R.id.updateInfo);
        insertButton = findViewById(R.id.insertInfo);

        Cursor c = db.rawQuery("SELECT * FROM UserData WHERE Id='"+id+"'", null);
        if(c.moveToFirst()) {
            insertButton.setVisibility(View.INVISIBLE);
            nameIn.setText(c.getString(1));
            ageIn.setText(c.getString(2));
            genderIn.setText(c.getString(3));
            weightIn.setText(c.getString(4));
            heightIn.setText(c.getString(5));
            bloodIn.setText(c.getString(6));
            noteIn.setText(c.getString(7));
            contactIn.setText(c.getString(8));
        } else {
            deleteButton.setVisibility(View.INVISIBLE);
            updateButton.setVisibility(View.INVISIBLE);
        }
    }

    public void insertUserInfo (View v) {
        String name = nameIn.getText().toString();
        String age = ageIn.getText().toString();
        String gender = genderIn.getText().toString();
        String weight = weightIn.getText().toString();
        String height = heightIn.getText().toString();
        String blood = bloodIn.getText().toString();
        String note = noteIn.getText().toString();
        String contact = contactIn.getText().toString();

        if(name.trim().length() == 0 || age.trim().length() == 0 || gender.trim().length() == 0 || weight.trim().length() == 0 || height.trim().length() == 0 || blood.trim().length() == 0 || note.trim().length() == 0) {
            Toast.makeText(personal_info.this,"Please Insert All Data", Toast.LENGTH_LONG).show();
        } else {
            Cursor c = db.rawQuery("SELECT * FROM UserData WHERE Id='"+id+"'", null);
            if (c.moveToFirst()) {
                Toast.makeText(personal_info.this,"Record already exist", Toast.LENGTH_LONG).show();
            } else {
                db.execSQL("INSERT INTO UserData VALUES('"+id+"', '"+name+"', '"+age+"', '"+gender+"', '"+weight+"', '"+height+"', '"+blood+"', '"+note+"', '"+contact+"');");
                Toast.makeText(personal_info.this,"Info added", Toast.LENGTH_LONG).show();
                insertButton.setVisibility(View.INVISIBLE);
                deleteButton.setVisibility(View.VISIBLE);
                updateButton.setVisibility(View.VISIBLE);
            }
        }
    }

    public void deleteUserInfo(View v) {
        Cursor c = db.rawQuery("SELECT * FROM UserData WHERE Id='1'", null);
        if(c.moveToFirst()){
            db.execSQL("DELETE FROM UserData WHERE Id='"+id+"'");
            Toast.makeText(personal_info.this,"Info deleted", Toast.LENGTH_LONG).show();
            insertButton.setVisibility(View.VISIBLE);
            deleteButton.setVisibility(View.INVISIBLE);
            updateButton.setVisibility(View.INVISIBLE);
            clearText();
        } else {
            Toast.makeText(personal_info.this,"Info not exist", Toast.LENGTH_LONG).show();
        }
    }

    public void updateDB(View v) {
        Cursor c = db.rawQuery("SELECT * FROM UserData WHERE Id='"+id+"'", null);
        if(c.moveToFirst()) {
            db.execSQL("UPDATE UserData SET Name='"+nameIn.getText().toString()+"', Age='"+ageIn.getText().toString()+"', Gender='"+genderIn.getText().toString()+"', Weight='"+weightIn.getText().toString()+"', Height='"+heightIn.getText().toString()+"', Blood='"+bloodIn.getText().toString()+"', Note='"+noteIn.getText().toString()+"', Contact='"+contactIn.getText().toString()+"' WHERE Id='"+id+"'");
            Toast.makeText(personal_info.this,"Info updated", Toast.LENGTH_LONG).show();
        }
    }

    public void clearText() {
        nameIn.setText("");
        ageIn.setText("");
        genderIn.setText("");
        weightIn.setText("");
        heightIn.setText("");
        bloodIn.setText("");
        noteIn.setText("");
        contactIn.setText("");
    }

}
