package com.example.ostoslista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AddPurchaseActivity extends AppCompatActivity {
    private EditText name;
    private EditText description;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_purchase);
        name = findViewById(R.id.editName);
        description = findViewById(R.id.editDescription);

    }


    public void addPurchase(View view){
        String stringName = name.getText().toString();
        String stringDescription = description.getText().toString();
        Purchase purchase = new Purchase(stringName,stringDescription);
        PurchaseList.getInstance().addPurchase(purchase);
        switchToMain();
    }


    public void switchToMain(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }



}