package com.sample.hasarel.popupmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Ui Components
    private Button mBtnPopUpMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        mBtnPopUpMenu = findViewById(R.id.main_activity_btn_click);
        mBtnPopUpMenu.setOnClickListener(this);
    }

    private void popUpMenuItem(){

        PopupMenu popup = new PopupMenu(MainActivity.this, mBtnPopUpMenu);
        popup.getMenuInflater().inflate(R.menu.pop_up_menu, popup.getMenu());
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                Toast.makeText(MainActivity.this, "You Clicked : " + item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        popup.show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main_activity_btn_click:
                popUpMenuItem();
                break;
            default:
                break;
        }
    }
}