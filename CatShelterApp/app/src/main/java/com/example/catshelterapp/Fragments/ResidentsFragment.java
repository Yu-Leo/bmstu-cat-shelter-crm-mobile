package com.example.catshelterapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.catshelterapp.Models.ResidentModel;
import com.example.catshelterapp.R;
import com.example.catshelterapp.Utils.Adapters.ResidentsAdapter;

import java.util.ArrayList;

// Фрагмент "Постояльцы"
public class ResidentsFragment extends Fragment {

    private ArrayList<ResidentModel> residentsArrayList;
    private SearchView searchView;
    private RecyclerView residentsRecyclerView;
    private ResidentsAdapter residentsAdapter;

    public ResidentsFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        setHasOptionsMenu(true);


        View rootView = inflater.inflate(R.layout.fragment_residents, container, false);

        residentsArrayList = generateResidentItems();


        searchView = rootView.findViewById(R.id.searchView);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterArrayList(newText);
                return true;
            }
        });

        residentsRecyclerView = rootView.findViewById(R.id.catRecyclerView);
        residentsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        residentsAdapter = new ResidentsAdapter(residentsArrayList);
        residentsRecyclerView.setAdapter(residentsAdapter);

        return rootView;


    }


    private ArrayList<ResidentModel> generateResidentItems() {
        ArrayList<ResidentModel> residentItems = new ArrayList<>();
        residentItems.add(new ResidentModel(R.drawable.real_cat_image, "Сержиу", "15", "15.02.2022"));
        residentItems.add(new ResidentModel(R.drawable.real_cat_image, "Баобаб", "12", "19.05.2023"));
        residentItems.add(new ResidentModel(R.drawable.real_cat_image, "Теба", "11", "25.11.2023"));
        residentItems.add(new ResidentModel(R.drawable.real_cat_image, "Таба", "13", "10.09.2023"));
        residentItems.add(new ResidentModel(R.drawable.real_cat_image, "Ариэтта", "14", "11.02.2023"));
        residentItems.add(new ResidentModel(R.drawable.real_cat_image, "Ласкунья", "15", "15.04.2022"));
        residentItems.add(new ResidentModel(R.drawable.real_cat_image, "Сопрано", "15", "13.02.2022"));

        return residentItems;
    }

    private void filterArrayList(String text) {
        ArrayList<ResidentModel> filteredCats = new ArrayList<>();
        for (ResidentModel catModel : residentsArrayList) {
            if (catModel.getNickname().toLowerCase().contains(text.toLowerCase())) {
                filteredCats.add(catModel);
            }
        }

        if (filteredCats.isEmpty()) {
            Toast.makeText(getActivity(), R.string.resident_not_found, Toast.LENGTH_SHORT).show();
        } else {
            residentsAdapter.setFilteredList(filteredCats);
        }
    }


}
