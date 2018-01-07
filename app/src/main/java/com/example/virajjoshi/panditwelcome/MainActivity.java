package com.example.virajjoshi.panditwelcome;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private CardView cardView1, cardView2, cardView3, cardView4;

    private List<ListItem> listItems;

    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        cardView1 = (CardView) findViewById(R.id.panditBooking);
        cardView2 = (CardView) findViewById(R.id.video);
        cardView3 = (CardView) findViewById(R.id.shlok);
        cardView4 = (CardView) findViewById(R.id.typesOfPooja);


        viewPager = (ViewPager) findViewById(R.id.viewPager);   // Slide Show Up
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);

        listItems = new ArrayList<>();     // TO add recycler view info


        for (int i = 0; i < 10; i++) {

            if (i == 0) {

                ListItem listItem = new ListItem(
                        "Heading ", "Hello", cardView1, cardView2, cardView3
                );
                listItems.add(listItem);
            }

/*
            if(i==1) {



                ListItem listItem = new ListItem(
                        "Love you ",
                        "Zindagi"
                );
                listItems.add(listItem);
            }

            if(i==2) {

                ListItem listItem = new ListItem(
                        "Love you ",
                        "Zindagi"
                );
                listItems.add(listItem);
            }

            if(i==3) {

                ListItem listItem = new ListItem(
                        "Love you ",
                        "Zindagi"
                );
                listItems.add(listItem);
            }

            if(i==4) {

                ListItem listItem = new ListItem(
                        "Love you ",
                        "Zindagi"
                );
                listItems.add(listItem);
            }

            if(i==5) {

                ListItem listItem = new ListItem(
                        "Love you ",
                        "Zindagi"
                );
                listItems.add(listItem);
            }

            if(i==6) {

                ListItem listItem = new ListItem(
                        "Love you ",
                        "Zindagi"
                );
                listItems.add(listItem);
            }

            if(i==7) {

                ListItem listItem = new ListItem(
                        "Love you ",
                        "Zindagi"
                );
                listItems.add(listItem);
            }

            if(i==8) {

                ListItem listItem = new ListItem(
                        "Love you ",
                        "Zindagi"
                );
                listItems.add(listItem);
            }

            if(i==9) {

                ListItem listItem = new ListItem(
                        "Love you ",
                        "Zindagi9"
                );
                listItems.add(listItem);
            }

            if(i==10) {

                ListItem listItem = new ListItem(
                        "Love you ",
                        "Zindagi10"
                );
                listItems.add(listItem);
            }

        }
        */


            adapter = new MyAdpater(listItems, this);


            recyclerView.setAdapter(adapter);

            BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
            bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()){
                        case R.id.home1:
                            Toast.makeText(getApplicationContext(),"Hello",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(MainActivity.this,Video.class));


                    }
                    return true;
                }
            });


            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new MyTimerTask(), 2000, 4000);
        }

    }

    public class MyTimerTask extends TimerTask {
        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (viewPager.getCurrentItem() == 0) {
                        viewPager.setCurrentItem(1);
                    } else if (viewPager.getCurrentItem() == 1) {
                        viewPager.setCurrentItem(2);
                    } else {
                        viewPager.setCurrentItem(0);
                    }
                }
            });
        }
    }


    public void VideoPooja(View view) {
        startActivity(new Intent(MainActivity.this,Video.class));
    }


}