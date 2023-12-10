package com.example.catshelterapp.Activities;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.catshelterapp.Fragments.GuardiansFragment;
import com.example.catshelterapp.Fragments.ResidentsFragment;
import com.example.catshelterapp.Fragments.SettingsFragment;
import com.example.catshelterapp.Fragments.WorkersFragment;
import com.example.catshelterapp.R;
import com.example.catshelterapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        replaceFragment(new ResidentsFragment());
        binding.bottomNavigationView.setBackground(null);

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.cats)
                replaceFragment(new ResidentsFragment());
            else if (item.getItemId() == R.id.workers)
                replaceFragment(new WorkersFragment());
            else if (item.getItemId() == R.id.settings)
                replaceFragment(new SettingsFragment());
            else if (item.getItemId() == R.id.guardians)
                replaceFragment(new GuardiansFragment());
            return true;
        });
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}