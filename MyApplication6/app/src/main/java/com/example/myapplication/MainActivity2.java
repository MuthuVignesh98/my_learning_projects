package com.example.myapplication;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.Arrays;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

     TabLayout tabLayout;
     ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Initialize views
        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);

        // List of tab titles & icons
        List<String> tabTitles = Arrays.asList("Posts", "Favourites");
        int[] tabIcons = {R.drawable.home, R.drawable.person};

        // Set up ViewPager2 with adapter
        viewPager.setAdapter(new ViewPagerAdapter(this, tabTitles));

        // Connect TabLayout with ViewPager2 using TabLayoutMediator
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            tab.setText(tabTitles.get(position));
            tab.setIcon(ContextCompat.getDrawable(this, tabIcons[position]));
        }).attach();
    }
}