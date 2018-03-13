package com.example.mox.ffallearl2018;

/**
 * Created by mox on 13/03/2018.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class crashtofreefall extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crashtofreefall);

        //Initialize Widgets
        final EditText speedInput = (EditText)findViewById(R.id.speedEt);
        Button calculateButton = (Button)findViewById(R.id.button);
        Button changeConverter = (Button)findViewById(R.id.converterButton);

        //Button for calculating
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String s = speedInput.getText().toString();
                float speed = Float.parseFloat(s);
                //Logic for crash to free fall
                float result = speed * 5;

                //Send the result to the result activity class.
                Intent intentBundle = new Intent(crashtofreefall.this,result.class);
                Bundle bundle = new Bundle();
                bundle.putFloat("result",result);
                intentBundle.putExtras(bundle);
                startActivity(intentBundle);

            }
        });

        //Button for different converter.
        changeConverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(crashtofreefall.this,MainActivity.class));
            }
        });




    }
}
