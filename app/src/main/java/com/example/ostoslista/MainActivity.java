package com.example.ostoslista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private PurchaseList purchaseList;
    private RecyclerView recyclerView;
    private ImageView calendar;
    private ImageView alphabet;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        updateRecycleView();
        context = MainActivity.this;
        calendar = findViewById(R.id.imgCalendar);
        calendar.setOnClickListener(listener);
        alphabet = findViewById(R.id.imgAlphabet);
        alphabet.setOnClickListener(listener);



    }

    public void switchToAddPurchase(View view) {
        Intent intent = new Intent(this, AddPurchaseActivity.class);
        startActivity(intent);

    }

    public void updateRecycleView(){
        purchaseList = PurchaseList.getInstance();
        recyclerView = findViewById(R.id.rvPurchaseList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        PurchaseList.getInstance().sortByAge();
        recyclerView.setAdapter(new PurchaseListAdapter(getApplicationContext(),purchaseList.getPurchases()));

    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(view.getId() == R.id.imgCalendar){
                System.out.println("Kalenteri");
                updateRecycleView();
            } else if(view.getId() == R.id.imgAlphabet){
                purchaseList = PurchaseList.getInstance();
                recyclerView = findViewById(R.id.rvPurchaseList);

                recyclerView.setLayoutManager(new LinearLayoutManager(context));
                PurchaseList.getInstance().sortByAlphabet();
                /*
                purchases = PurchaseList.getInstance().getPurchases();
                ArrayList<String> sorted = new ArrayList<String>();
                int amount = purchases.size();

                for (Purchase purchase: purchases) {
                    sorted.add(purchase.getName());
                }
                Collections.sort(sorted);
                */
                recyclerView.setAdapter(new PurchaseListAdapter(getApplicationContext(),purchaseList.getPurchases()));

            } else{


            }


        }
    };


}