package com.example.ostoslista;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PurchaseViewHolder extends RecyclerView.ViewHolder {

    TextView name;
    TextView description;

    ImageView imgRemove;
    ImageView imgSetting;
    EditText editSettingName;
    EditText editSettingDescription;

    public PurchaseViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.txtName);
        description = itemView.findViewById(R.id.txtDescription);
        imgRemove = itemView.findViewById(R.id.imgRemove);
        imgSetting = itemView.findViewById(R.id.imgSetting);
        editSettingName = itemView.findViewById(R.id.editSettingName);
        editSettingDescription = itemView.findViewById(R.id.editSettingDescription);

    }
}
