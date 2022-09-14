package br.com.etecia.panetonefactory;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bvMenu);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, new coffe_fragment()).
                commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.mnCoffe:
                        getSupportFragmentManager().
                                beginTransaction().
                                replace(R.id.container, new coffe_fragment()).
                                commit();
                        return true;
                    case R.id.mnMuffin:
                        getSupportFragmentManager().
                                beginTransaction().
                                replace(R.id.container, new muffin_fragment()).
                                commit();
                        return true;
                    case R.id.mnTea:
                        getSupportFragmentManager().
                                beginTransaction().
                                replace(R.id.container, new tea_fragment()).
                                commit();
                        return true;
                    case R.id.mnDOnuts:
                        getSupportFragmentManager().
                                beginTransaction().
                                replace(R.id.container, new donuts_fragment()).
                                commit();
                        return true;

                }
                return true;
            }
        });
    }
}