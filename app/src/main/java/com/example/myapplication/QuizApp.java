package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class QuizApp extends AppCompatActivity {

    NavigationView navigationView;
    DrawerLayout drawerLayout;
    Toolbar toolBar;
    ActionBarDrawerToggle toggle;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainquiz);
        navigationView=findViewById(R.id.nav_view);
        toolBar=findViewById(R.id.toolbar);
        drawerLayout=findViewById(R.id.drawer);

        toggle=new ActionBarDrawerToggle(this,drawerLayout,toolBar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.calculator :
                        Toast.makeText(getApplicationContext(),"Calculator is clicked",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(QuizApp.this, Calculator.class);
                        startActivity(intent);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.myquiz :
                        Toast.makeText(getApplicationContext(),"My Quiz is clicked",Toast.LENGTH_LONG).show();
                        Intent intent1 = new Intent(QuizApp.this, QuizApp.class);
                        startActivity(intent1);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.assign3 :
                        Toast.makeText(getApplicationContext(),"Opening Welcome Page",Toast.LENGTH_LONG).show();
                        Intent intent2 = new Intent(QuizApp.this, MainActivity.class);
                        startActivity(intent2);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                }
                return true;
            }
        });

        Button startbutton = (Button) findViewById(R.id.Startbutton);
        final EditText nametext = (EditText) findViewById(R.id.editName);

        startbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nametext.getText().toString();
                Intent intent = new Intent(getApplicationContext(), quizQuestions.class);
                intent.putExtra("myname", name);
                startActivity(intent);
            }
        });
    }
}
