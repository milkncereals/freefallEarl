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
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText speedInput = (EditText) findViewById(R.id.speedEt);
        Button calculateButton = (Button)findViewById(R.id.button);
        Button changeConverter = (Button)findViewById(R.id.converterButton);


        //Button for calculating
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Take the users input as string
                String s = speedInput.getText().toString();

                //Pops up "Invalid Input" when nothing is entered
                if (s.matches("")) {
                    Toast.makeText(MainActivity.this, "Invalid Input", Toast.LENGTH_LONG).show();
                    return;
                }

                //convert the String to a float value.
                float speed = Float.parseFloat(s);
                //Logic for the conversion
                float result = speed * 13;

                //Create an intent bundle to send data to the result class
                Intent intentBundle = new Intent(MainActivity.this,result.class);
                //Create a bundle.
                Bundle bundle = new Bundle();
                //Put the result value inside the bundle
                bundle.putFloat("result",result);
                //Put the bundle in the intent bundle.
                intentBundle.putExtras(bundle);
                //Start the activity.
                startActivity(intentBundle);

            }
        });

        //Change converter.
        changeConverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,crashtofreefall.class));
            }
        });


    }
}

//change is good.
//develop branch test.