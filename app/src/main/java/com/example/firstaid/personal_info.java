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

    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_info_layout);

        db = openOrCreateDatabase("InfoDB", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS UserData(Id VARCHAR, Name VARCHAR, Age VARCHAR, Gender VARCHAR, Weight VARCHAR, Height VARCHAR ,Blood VARCHAR, Note VARCHAR)");

        deleteButton = findViewById(R.id.deleteInfo);
        updateButton = findViewById(R.id.updateInfo);
        insertButton = findViewById(R.id.insertInfo);
        //deleteButton.setVisibility(View.INVISIBLE);
       // updateButton.setVisibility(View.INVISIBLE);
    }

    public void insertUserInfo (View v) {
        String id = "1";
        EditText nameIn = findViewById(R.id.nameInput);
        EditText ageIn = findViewById(R.id.ageInput);
        EditText genderIn = findViewById(R.id.genderInput);
        EditText weightIn = findViewById(R.id.weightInput);
        EditText heightIn = findViewById(R.id.heightInput);
        EditText bloodIn = findViewById(R.id.bloodInput);
        EditText noteIn = findViewById(R.id.noteInput);
        String name = nameIn.getText().toString();
        String age = ageIn.getText().toString();
        String gender = genderIn.getText().toString();
        String weight = weightIn.getText().toString();
        String height = heightIn.getText().toString();
        String blood = bloodIn.getText().toString();
        String note = noteIn.getText().toString();

        if(name.trim().length() == 0 || age.trim().length() == 0 || gender.trim().length() == 0 || weight.trim().length() == 0 || height.trim().length() == 0 || blood.trim().length() == 0 || note.trim().length() == 0) {
            Toast.makeText(personal_info.this,"Please Insert All Data", Toast.LENGTH_LONG).show();
        }

        Cursor c = db.rawQuery("SELECT * FROM UserData WHERE Id='"+id+"'", null);
        if (c.moveToFirst()) {
            Toast.makeText(personal_info.this,"Record already exist", Toast.LENGTH_LONG).show();
        } else {
            db.execSQL("INSERT INTO UserData VALUES('"+id+"', '"+name+"', '"+age+"', '"+gender+"', '"+weight+"', '"+height+"', '"+blood+"', '"+note+"');");
            Toast.makeText(personal_info.this,"Info added", Toast.LENGTH_LONG).show();
        }
    }

    public void deleteUserInfo(View v) {
        Cursor c = db.rawQuery("SELECT * FROM UserData WHERE Id='1'", null);
        if(c.moveToFirst()){
            db.execSQL("DELETE FROM UserData WHERE Id='1'");
            Toast.makeText(personal_info.this,"Info deleted", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(personal_info.this,"Info not exist", Toast.LENGTH_LONG).show();
        }
    }

    public void viewDB(View v) {
        StringBuilder buffer = new StringBuilder();
        Cursor c = db.rawQuery("SELECT * FROM UserData WHERE Id='1'", null);
        if(c.moveToFirst()) {
            buffer.append("Id : " + c.getString(0) + "\n");
            buffer.append("Name : " + c.getString(1) + "\n");
            buffer.append("Age : " + c.getString(2) + "\n");
            buffer.append("Gender : " + c.getString(3) + "\n");
            buffer.append("Weight : " + c.getString(4) + " kg\n");
            buffer.append("Height : " + c.getString(5) + " m\n");
            buffer.append("Blood : " + c.getString(6) + "\n");
            buffer.append("Note : " + c.getString(7) + "\n\n");
        }
        showMessage ("User Info", buffer.toString());
    }

    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

}
