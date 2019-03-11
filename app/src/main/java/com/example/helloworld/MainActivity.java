package com.example.helloworld;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static TextView textfieald;
    static EditText x1,x2;
    static RadioButton isMoreP;
    static Button butLearn,butClear,butAdd;
    static Perceptron perc ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        perc = new Perceptron(4,0.1);
        perc.addPoint(1,2,false);
        perc.addPoint(3,3,false);
        perc.addPoint(8,5,false);
        perc.addPoint(1,4,true);
        perc.addPoint(3,5,true);
        perc.addPoint(5,5,true);
        perc.addPoint(9,6,true);
        perc.run();



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textfieald = (TextView) findViewById(R.id.TextField);

        butLearn = (Button) findViewById(R.id.butLearn);
        butClear = findViewById(R.id.butClear);
        butAdd = findViewById(R.id.butAdd);

        isMoreP = findViewById(R.id.radioButton);
        x1 = findViewById(R.id.editText);
        x2 = findViewById(R.id.editText2);

        View.OnClickListener OnClickLearn = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Button clickedButton = (Button) findViewById(v.getId());

                if (clickedButton.getId() == butLearn.getId()){
                    if (perc.getPoints().isEmpty()){
                        textfieald.setText("Додайте точки для навчання");
                    }else {
                        perc.run();
                        textfieald.setText("ОК! СУПЕР");
                    }
                }
                if (clickedButton.getId() == butAdd.getId()){
                    if (x1.getText().length()!=0  && x2.getText().length()!=0 ) {
                        try{
                            int x = Integer.parseInt(x1.getText().toString());
                            int y = Integer.parseInt(x1.getText().toString());
                            perc.addPoint(x,y,isMoreP.isChecked());
                        }
                         catch (NumberFormatException e){
                            textfieald.setText("Переевірте правильність чисел");
                         }

                    }
                }
                if (clickedButton.getId() == butClear.getId())
                        perc.Clear();

            }
        };
        butLearn.setOnClickListener(OnClickLearn);
        butClear.setOnClickListener(OnClickLearn);
        butAdd.setOnClickListener(OnClickLearn);
    }




}
