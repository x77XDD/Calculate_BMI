package com.example.wzbc.bmi;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import com.example.wzbc.bmi.com.xyz.util.BMI;

public class MainActivity extends AppCompatActivity {
    private BlankFragment bf;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private BlankFragment_2 bf2;
    private BlankFragment_4 bf4;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {


        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    ft=fm.beginTransaction();
                    ft.replace(R.id.content,bf);
                    ft.commit();

                    return true;
                case R.id.navigation_dashboard:
                    ft=fm.beginTransaction();
                    ft.replace(R.id.content,bf2);
                    ft.commit();
                    return true;
                case R.id.navigation_notifications:
                    ft=fm.beginTransaction();
                    ft.replace(R.id.content,bf4);
                    ft.commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bf=new BlankFragment();
        bf2=new BlankFragment_2();
        bf4=new BlankFragment_4();
         fm =getFragmentManager();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.xiugaidanwei:
                if(item.getTitle().toString().equals("改为英制单位")){
                    bf.english();
//                    bf2.english_1();
                    item.setTitle("改为公制单位");
                }else if(item.getTitle().toString().equals("改为公制单位")){
                    bf.chinese();
//                    bf2.chinese_1();
                    item.setTitle("改为英制单位");
                }
                break;
            case R.id.about:
                aboutDialog();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    private void aboutDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.yes);
        builder.setTitle("emmmmm");
        String infom = getString(R.string.content_alert);
        builder.setMessage(infom);
        builder.setNegativeButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        builder.show();
    }

    private void backDialog() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        String infom = getString(R.string.back);
        builder.setMessage(infom);
        builder.setNegativeButton(R.string.cancel, null);
        builder.setPositiveButton(R.string.ok,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
        builder.show();
    }

    @Override
    public void onBackPressed() {
        backDialog();
        super.onBackPressed();
    }
}
