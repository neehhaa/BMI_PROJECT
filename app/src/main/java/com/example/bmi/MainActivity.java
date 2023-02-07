package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //define container for id
        EditText ed_Weight,ed_Height_ft,ed_Height_in;
        Button btn_cal;
        TextView txt_Result;
        LinearLayout llMain;

        //find ids of xml

        ed_Weight = findViewById(R.id.ed_Weight);
        ed_Height_ft = findViewById(R.id.ed_Height_ft);
        ed_Height_in = findViewById(R.id.ed_Height_in);
        btn_cal = findViewById(R.id.btn_cal);
        txt_Result = findViewById(R.id.txt_Result);
        llMain = findViewById(R.id.LLMain);

        //on clicking button perform this

        btn_cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int wt = Integer.parseInt(ed_Weight.getText().toString());
                int ft = Integer.parseInt(ed_Height_ft.getText().toString());
                int in = Integer.parseInt(ed_Height_in.getText().toString());

                //converting height for proper format

                int totalIn = ft*12+in;
                double totalCM = totalIn*2.53;
                double totalM = totalCM/100;

                double bmi = wt/(totalM*totalM);

                if (bmi>25){
                    txt_Result.setText("OVERWEIGHT");
                    llMain.setBackgroundColor(getResources().getColor(R.color.over_weight_color));
                } else if (bmi<18) {
                    txt_Result.setText("UNDERWEIGHT");
                    llMain.setBackgroundColor(getResources().getColor(R.color.under_weight_color));
                }else {
                    txt_Result.setText("NORMAL");
                    llMain.setBackgroundColor(getResources().getColor(R.color.normal_weight_color));
                }
            }
        });
    }
}