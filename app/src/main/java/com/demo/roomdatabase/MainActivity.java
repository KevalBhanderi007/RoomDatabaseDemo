 package com.demo.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

 public class MainActivity extends AppCompatActivity {


    EditText editTextText3,editTextText4;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextText3 = findViewById(R.id.editTextText3);
        editTextText4 = findViewById(R.id.editTextText4);
        button = findViewById(R.id.button);

        DbHelper dbHelper = DbHelper.getDB(this);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String title = editTextText3.getText().toString();
                String amount = editTextText4.getText().toString();

                String message = "Title: " + title + "\nAmount: " + amount;
                Toast.makeText(MainActivity.this, "Room Database" +"\n" + message, Toast.LENGTH_SHORT).show();
                dbHelper.expenseDao().addTx(
                        new Expense(title,amount)
                );

                ArrayList<Expense> arr = (ArrayList<Expense>) dbHelper.expenseDao().getAllExpense();

                for (int i=0;i< arr.size();i++){

                    Log.e("=====",arr.get(i).getTitle()+":"+arr.get(i).getAmount());
                }


            }
        });


    }
}