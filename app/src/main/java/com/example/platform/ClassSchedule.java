package com.example.platform;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class ClassSchedule extends AppCompatActivity {

    private TextView ddayText;
    private TextView today55Text;
    private TextView resultText;
    private Button dateButton;

    private int tYear;           //오늘 연월일 변수
    private int tMonth;
    private int tDay;

    private int dYear=1;        //디데이 연월일 변수
    private int dMonth=1;
    private int dDay=1;


    private long d;
    private long t;
    private long r;

    private int resultNumber=0;

    static final int DATE_DIALOG_ID=0;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_schedule);


        ddayText=(TextView)findViewById(R.id.dday);
        today55Text=(TextView)findViewById(R.id.today55);
        resultText=(TextView)findViewById(R.id.result);
        dateButton=(Button)findViewById(R.id.dateButton);



        dateButton.setOnClickListener(new OnClickListener() {


            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                showDialog(0);//----------------
            }
        });



        Calendar calendar =Calendar.getInstance();              //현재 날짜 불러옴
        tYear = calendar.get(Calendar.YEAR);
        tMonth = calendar.get(Calendar.MONTH);
        tDay = calendar.get(Calendar.DAY_OF_MONTH);

        Calendar dCalendar =Calendar.getInstance();
        dCalendar.set(dYear,dMonth, dDay);

        t=calendar.getTimeInMillis();                 //오늘 날짜를 밀리타임으로 바꿈
        d=dCalendar.getTimeInMillis();              //디데이날짜를 밀리타임으로 바꿈
        r=(d-t)/(24*60*60*1000);                 //디데이 날짜에서 오늘 날짜를 뺀 값을 '일'단위로 바꿈

        resultNumber=(int)r+1;
        updateDisplay();

    }//OnCreate end

    private void updateDisplay(){

        today55Text.setText(String.format("%d년 %d월 %d일",tYear, tMonth+1,tDay));
        ddayText.setText(String.format("%d년 %d월 %d일",dYear, dMonth+1,dDay));

        if(resultNumber>=0){
            resultText.setText(String.format("D-%d", resultNumber));
        }
        else{
            int absR=Math.abs(resultNumber);
            resultText.setText(String.format("D+%d", absR));
        }
    }//디데이 날짜가 오늘날짜보다 뒤에오면 '-', 앞에오면 '+'를 붙인다

    private DatePickerDialog.OnDateSetListener dDateSetListener=new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            dYear=year;
            dMonth=monthOfYear;
            dDay=dayOfMonth;
            final Calendar dCalendar =Calendar.getInstance();
            dCalendar.set(dYear,dMonth, dDay);

            d=dCalendar.getTimeInMillis();
            r=(d-t)/(24*60*60*1000);

            resultNumber=(int)r;
            updateDisplay();
        }
    };


    @Override
    protected Dialog onCreateDialog(int id){
        if(id==DATE_DIALOG_ID){
            return new DatePickerDialog(this,dDateSetListener,tYear,tMonth,tDay);

        }
        return null;
    }
    public void onButton1Clicked(View view){
        Toast.makeText(getApplicationContext(), "신청 취소되었습니다!", Toast.LENGTH_LONG).show(); }
    public void onButton2Clicked(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://zoom.us/j/3851339566?pwd=VitiaDJEV2tNbCtZNWJnYWtiMlg5dz09"));
        startActivity(intent); } }