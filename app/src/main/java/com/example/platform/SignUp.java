package com.example.platform;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/*
 *회원가입 화면
 */
public class SignUp extends AppCompatActivity {

    private EditText join_name;
    private Button cancel_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        /*
         * 취소 버튼 클릭 시 초기화면으로 이동
         */
        cancel_btn = findViewById(R.id.cancel_button);
        cancel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUp.this, FirstPage.class);
                startActivity(intent);
            }
        });

        join_name = findViewById(R.id.join_name);

        //데이터베이스
        final AppDatabase db = Room.databaseBuilder(this, AppDatabase.class, "platformUser-db")
                .allowMainThreadQueries()
                .build();

    }




}