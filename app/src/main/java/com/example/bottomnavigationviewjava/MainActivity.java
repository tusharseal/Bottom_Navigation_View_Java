package com.example.bottomnavigationviewjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.bottomnavigationviewjava.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

      binding.bnView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()) {
                case R.id.nav_Home:
                    loadFragment(new HomeFragment(), false);
                    break;
                case R.id.nav_Search:
                    loadFragment(new SearchFragment(), false);
                    break;
                case R.id.nav_Settings:
                    loadFragment(new SettingsFragment(), false);
                    break;
                case R.id.nav_Contact:
                    loadFragment(new ContactFragment(), false);
                    break;
                case R.id.nav_Profile:
                    loadFragment(new ProfileFragment(), true);
                    break;
            }
            return true;
        });
        binding.bnView.setSelectedItemId(R.id.nav_Home);
    }

    public void loadFragment(Fragment fragment, boolean flag) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if (flag)
            ft.add(R.id.frameLayout, fragment);
        else
            ft.replace(R.id.frameLayout, fragment);
        ft.commit();
    }
}