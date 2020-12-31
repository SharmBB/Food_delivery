package com.example.fornt_end_development;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.os.Bundle;
import android.view.View;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

import java.util.ArrayList;
import java.util.List;

public class Resturant extends AppCompatActivity {
    ViewPager viewPager;
    Adapter adapter;
    List<Model> models;
    Integer[] colors=null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resturant);


        final DrawerLayout drawerLayout =findViewById(R.id.drawerlayout);

        findViewById(R.id.image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });


        MeowBottomNavigation bottomNavigation=findViewById(R.id.bottom_bar);
        bottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.ic_baseline_home_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.ic_baseline_local_grocery_store_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.ic_baseline_favorite_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(4, R.drawable.ic_baseline_person_24));


        models =new ArrayList<>();
        models.add(new Model(R.drawable.jetwing,"Jetwing Northgate","Srilakan Stlye Food"));
        models.add(new Model(R.drawable.us,"US Resturant","Jaffna Style Foods"));
        models.add(new Model(R.drawable.greengreass,"Green Grass Hotel","Jaffna Style Foods"));

        adapter = new Adapter(models,this);
        viewPager=findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130,0,130,0);


    }
}