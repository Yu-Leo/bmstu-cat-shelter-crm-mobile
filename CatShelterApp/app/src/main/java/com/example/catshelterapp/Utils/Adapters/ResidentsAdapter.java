package com.example.catshelterapp.Utils.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.catshelterapp.Models.ResidentModel;
import com.example.catshelterapp.R;

import java.util.ArrayList;

public class ResidentsAdapter extends RecyclerView.Adapter<ResidentsAdapter.ResidentsViewHolder> {

    private ArrayList<ResidentModel> residentsArrayList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onClick(View view, int position);
    }

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public ResidentModel getItemAt(int position) {
        return residentsArrayList.get(position);
    }

    public ResidentsAdapter(ArrayList<ResidentModel> residentsArrayList) {
        this.residentsArrayList = residentsArrayList;
    }

    public void setFilteredList(ArrayList<ResidentModel> filteredList) {
        this.residentsArrayList = filteredList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ResidentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cat_item, parent, false);
        return new ResidentsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ResidentsViewHolder holder, int position) {
        ResidentModel residentModel = residentsArrayList.get(position);
        holder.nickname.setText(residentModel.getNickname());
        holder.dateOfAdmissionToShelter.setText(residentModel.getDateOfAdmissionToShelter());
        holder.roomNumber.setText(residentModel.getRoomNumber());
//        holder.profileImage.setImageResource(residentModel.getPhotoURL());
    }

    @Override
    public int getItemCount() {
        return residentsArrayList.size();
    }

    public class ResidentsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @Override
        public void onClick(View view) {

        }

        ImageView profileImage;
        TextView nickname;
        TextView roomNumber;
        TextView dateOfAdmissionToShelter;

        public ResidentsViewHolder(@NonNull View itemView) {
            super(itemView);
            profileImage = itemView.findViewById(R.id.cardProfileImage);
            nickname = itemView.findViewById(R.id.cardNickname);
            roomNumber = itemView.findViewById(R.id.cardRoomNumber);
            dateOfAdmissionToShelter = itemView.findViewById(R.id.cardDateOfAdmissionToShelter);
        }
    }
}
