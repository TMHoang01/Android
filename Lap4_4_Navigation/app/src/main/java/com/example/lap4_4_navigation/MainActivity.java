package com.example.lap4_4_navigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;

import com.example.lap4_4_navigation.fragment.HistoryFragment;
import com.example.lap4_4_navigation.fragment.HomeFragment;
import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private  static final int FRAGMENT_HOME = 0;
    private  static final int FRAGMENT_HISTORY = 1;
    private  static final int FRAGMENT_LOGOUT = 3;

    private int mCurrentFrament = FRAGMENT_HISTORY;

    private DrawerLayout mDaDrawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDaDrawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDaDrawerLayout, toolbar ,
                R.string.nav_drawer_open, R.string.nav_drawer_close);

        mDaDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        replaceFragment(new HomeFragment());
        navigationView.getMenu().findItem(R.id.nav_home).setChecked(true);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.nav_home){
            if(mCurrentFrament != FRAGMENT_HOME){
                replaceFragment(new HomeFragment());
                mCurrentFrament = FRAGMENT_HOME;
            }
        }else if(id == R.id.nav_history){
            if(mCurrentFrament != FRAGMENT_HISTORY){
                replaceFragment(new HistoryFragment());
                mCurrentFrament = FRAGMENT_HISTORY;
            }
        }else if(id == R.id.nav_log_out){
            if(mCurrentFrament != FRAGMENT_LOGOUT){
                replaceFragment(new HomeFragment());
                mCurrentFrament = FRAGMENT_LOGOUT;
            }
        }


        mDaDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

//    an back dong Navigation
    @Override
    public void onBackPressed() {
        if(mDaDrawerLayout.isDrawerOpen(GravityCompat.START)){
            mDaDrawerLayout.closeDrawer(GravityCompat.START);
        }else
        super.onBackPressed();
    }

    private  void  replaceFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, fragment);
        transaction.commit();
    }

}