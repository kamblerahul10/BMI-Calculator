package com.rahulprojects.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button calculate;
    EditText Edheight,Edweight;
    TextView resultText;
    String BMIresult;
    LinearLayout backgroundMain;
    float heightValue,BMI;
    float weightValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculate=findViewById(R.id.calculate);
        Edheight=findViewById(R.id.inputHeight);
        Edweight=findViewById(R.id.inputWeight);
        resultText=findViewById(R.id.resultText);
        backgroundMain=findViewById(R.id.backgroundMain);
    }

    public void calculate(View view) {

        BMIresult="";
        resultText.setText("");
        String height = Edheight.getText().toString();
        String weight = Edweight.getText().toString();

        if(height.equals("") && weight.equals("")) {
            Toast.makeText(this, "Please enter height and weight", Toast.LENGTH_SHORT).show();
        }else if(height.equals("")){
            Toast.makeText(this,"Please enter valid height",Toast.LENGTH_SHORT).show();
        }else if(weight.equals("")){
            Toast.makeText(this,"Please enter valid weight",Toast.LENGTH_SHORT).show();
        }else {
            heightValue = Float.parseFloat(height) / 100;
            weightValue = Float.parseFloat(weight);
        }

        BMI = weightValue/ (heightValue*heightValue);

        if(BMI < 16){
            BMIresult="Severely Under Weight :(";
            backgroundMain.setBackgroundColor(getResources().getColor(R.color.severelyUnderWeight));
        }
        else if(BMI < 18.5){
            BMIresult="Under weight";
            backgroundMain.setBackgroundColor(getResources().getColor(R.color.underWeight));
        }
        else if(BMI>=18.5 && BMI<=24.9){
            BMIresult="Normal";
            backgroundMain.setBackgroundColor(getResources().getColor(R.color.Normal));
        }
        else if(BMI>=25 && BMI<=29.9){
            BMIresult="Over Weight";
            backgroundMain.setBackgroundColor(getResources().getColor(R.color.overWeight));
        }
        else if(BMI>=30){
            BMIresult = "Obese";
            backgroundMain.setBackgroundColor(getResources().getColor(R.color.Obese));
        }

        resultText.setText(BMIresult);

    }


}