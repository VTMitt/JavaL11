package com.example.ostoslista;

import android.content.Context;
import android.text.style.UpdateLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PurchaseListAdapter extends RecyclerView.Adapter<PurchaseViewHolder> {

    private Context context;
    private ArrayList<Purchase> purchases = new ArrayList<Purchase>();

    public PurchaseListAdapter(Context context, ArrayList<Purchase> purchases) {
        this.context = context;
        this.purchases = purchases;
    }

    @NonNull
    @Override
    public PurchaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PurchaseViewHolder(LayoutInflater.from(context).inflate(R.layout.purchase_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PurchaseViewHolder holder, int position) {
        holder.name.setText(purchases.get(position).getName());
        holder.description.setText(purchases.get(position).getDescription());

        holder.imgRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int positionHolder = holder.getAdapterPosition();
                PurchaseList.getInstance().removePurchase(purchases.get(positionHolder).getName());
                notifyItemRemoved(positionHolder);


            }
        });
        holder.imgSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int positionHolder = holder.getAdapterPosition();
                if(holder.editSettingName.getVisibility() == View.VISIBLE){
                    Purchase purchase = PurchaseList.getInstance().getPurchaseById(positionHolder);
                    purchase.setName(holder.editSettingName.getText().toString());
                    purchase.setDescription(holder.editSettingDescription.getText().toString());
                    holder.editSettingName.setVisibility(View.GONE);
                    holder.editSettingDescription.setVisibility(View.GONE);
                    notifyDataSetChanged();
                } else{
                    holder.editSettingName.setVisibility(View.VISIBLE);
                    holder.editSettingDescription.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return purchases.size();
    }
}
