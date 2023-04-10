package com.example.buttontextview;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView text1, text2;
    Switch switch1;

    RadioGroup rGroup;
    RadioButton An1, An2, An3;
    Button btn1, btn2;
    ImageView imgPet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("좋아하는 과자 사진 고르기");

        text1 = (TextView) findViewById(R.id.Text1);
        switch1 = (Switch) findViewById(R.id.Switch1);

        text2 = (TextView) findViewById(R.id.text2);
        rGroup = (RadioGroup)findViewById(R.id.Rgroup1);
        An1 = (RadioButton) findViewById(R.id.an1);
        An2 = (RadioButton) findViewById(R.id.an2);
        An3 = (RadioButton) findViewById(R.id.an3);

        btn1 = (Button) findViewById(R.id.Button1);
        btn2 = (Button) findViewById(R.id.Button2);
        imgPet = (ImageView) findViewById(R.id.ImgPet);

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if(switch1.isChecked()==true){
                    text2.setVisibility(View.VISIBLE);
                    rGroup.setVisibility(View.VISIBLE);
                    btn1.setVisibility(View.VISIBLE);
                    btn2.setVisibility(View.VISIBLE);
                    imgPet.setVisibility(View.VISIBLE);
                }
                else{
                    text2.setVisibility(View.INVISIBLE);
                    rGroup.setVisibility(View.INVISIBLE);
                    btn1.setVisibility(View.INVISIBLE);
                    btn2.setVisibility(View.INVISIBLE);
                    imgPet.setVisibility(View.INVISIBLE);

                }
            }
        });

        rGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(group.getCheckedRadioButtonId()){
                    case R.id.an1:
                        imgPet.setImageResource(R.drawable.onion);
                        break;

                    case R.id.an2:
                        imgPet.setImageResource(R.drawable.potato);
                        break;

                    case R.id.an3:
                        imgPet.setImageResource(R.drawable.sweet);
                        break;

                }
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch1.setChecked(false);
                An1.setChecked(false);
                An2.setChecked(false);
                An3.setChecked(false);
                imgPet.setImageResource(0);
            }
        });


    }
}