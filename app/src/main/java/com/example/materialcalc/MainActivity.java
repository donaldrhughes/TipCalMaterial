package com.example.materialcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    Button calcBtn; //calculate button

    TextInputEditText etTip; // bill amount input
    TextInputEditText etBill; // tip percent input

    TextView txt_tip; // tip total output
    TextView txt_grand; // grand total output

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etBill = (TextInputEditText) findViewById(R.id.etBill);
        etTip = (TextInputEditText) findViewById(R.id.etTip);
        calcBtn = (Button) findViewById(R.id.calcBtn);
        txt_grand = (TextView) findViewById(R.id.txt_grand);
        txt_tip = (TextView) findViewById(R.id.txt_tip);

        //set a listener for the calculate button
        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * Description: Method occurs when a user clicks calculate to show the tip amount and total bill with tip
                 * Author: Donald Hughes
                 * Date: May 27, 2020
                 */

                float bill = 0; // bill amount declaration as float
                float tip_percent = 0; // tip percent declaration as float
                float tip_result = 0; // tip result declaration as float
                float grand_total = 0; // grand total declaration as float

                // checks if the text fields are empty
                if (TextUtils.isEmpty(etBill.getText().toString())
                        || TextUtils.isEmpty(etTip.getText().toString())) {
                    return;
                }

                //set varables to the amount entered on the view
                bill = Float.parseFloat(etBill.getText().toString());
                tip_percent = Float.parseFloat(etTip.getText().toString());
                Log.d("TAG", "onClick: " + bill);
                Log.d("TAG", "onClick: " + tip_percent);
                //calculate the grand total and tip amount based on the entered values
                grand_total = ((bill * (tip_percent / 100)) + bill);
                tip_result = (bill * (tip_percent / 100));
                Log.d("TAG", "onClick: " + grand_total);
                Log.d("TAG", "onClick: " + tip_result);
                //set the view to the amounts calculated
                txt_grand.setText(Float.toString(grand_total));
                txt_tip.setText(Float.toString(tip_result));
            }
        });
    }
}
