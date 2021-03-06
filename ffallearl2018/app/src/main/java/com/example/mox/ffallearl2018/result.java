package com.example.mox.ffallearl2018;

/**
 * Created by mox on 13/03/2018.
 */

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.content.DialogInterface;

import org.w3c.dom.Text;

public class result extends AppCompatActivity {
    // This saves the results obtained from the conversions regardless of the orientation.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        //Initialize widgets.
        final TextView result = (TextView) findViewById(R.id.result);
        Button crashButton = (Button) findViewById(R.id.crash);
        Button freeFallButton = (Button) findViewById(R.id.freeFall);
        Button metricButton = (Button) findViewById(R.id.metricButton);
        final String metricUnit = " Km/hr";

        //Getting the passed data from the conversion and display it.
        Intent intentExtras = getIntent();
        Bundle extrasBundle = intentExtras.getExtras();
        if (!extrasBundle.isEmpty()) {
            float res = extrasBundle.getFloat("result");
            String resultText = Float.toString(res);
            result.setText(resultText + metricUnit);
        } else {

        }

        crashButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(result.this, crashtofreefall.class));
            }
        });

        freeFallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(result.this, MainActivity.class));
            }
        });

        metricButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Get the current entent
                Intent intentExtras = getIntent();
                Bundle extrasBundle = intentExtras.getExtras();
                //check if the bundle is empty if not then display the resulted value.
                if (!extrasBundle.isEmpty()) {
                    float res = extrasBundle.getFloat("result");
                    String resultText = Float.toString(res);
                    changeMetricUnit(resultText);
                }


            }
        });

    }

    //Method to change the metric unit
    public void changeMetricUnit(final String resultText) {

        //Take the result speed in Km/hr
        final float speed = Float.parseFloat(resultText);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        //Create the Alert Diaglog
        builder.setTitle("Choose Metric Unit")
                .setItems(R.array.metric_array, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {


                        TextView result = (TextView) findViewById(R.id.result);
                        double convertedValue;

                        //Choose which metric units to use.
                        switch(which){
                            case 0:
                                result.setText(resultText + " Km/hr");
                                dialog.dismiss();
                                break;

                            case 1:

                                convertedValue = speed*0.6214;
                                result.setText(convertedValue + " Mph/hr");
                                dialog.dismiss();
                                break;

                            case 2:

                                convertedValue = speed*0.277778;
                                result.setText(convertedValue + " M/s");
                                dialog.dismiss();
                                break;
                        }
                    }
                });

        //Create and display the alert
        AlertDialog alert = builder.create();
        alert.show();
    }
    //This is to save the variable regardless of orientation change.
    //Full props + source below

    @Override
    protected void onSaveInstanceState(Bundle outState){

        final TextView result = (TextView) findViewById(R.id.result);
        outState.putString("my_text",result.getText().toString());
        super.onSaveInstanceState(outState);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        final TextView result = (TextView) findViewById(R.id.result);
        super.onRestoreInstanceState(savedInstanceState);
        result.setText(savedInstanceState.getString("my_text"));
    }
}

// Made changes to strings.xml
// Removed hardcoded texts for string localization purposes.  Using @string resource instead...
// Adding in onSaveInstanceState + onRestoreInstanceState for static variables during orientation changes...
/*
Tried using the standard dialog setup, but having issues with savedInstanceStates for
conversions.
@Override
public Dialog onCreateDialog(Bundle savedInstanceState) {
    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
    builder.setTitle(R.string.pick_color)
            .setItems(R.array.colors_array, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    // The 'which' argument contains the index position
                    // of the selected item
                }
            });
    return builder.create();

} */
 // ------------------------
/*
Change Metric Method - fixed!!
Courtesy to a 2016 youtube video: https://www.youtube.com/watch?v=yhwtcEnI2Bg
LOL :)))

...

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        final TextView result = (TextView) findViewById(R.id.result);

        outState.putString("my_text",result.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        final TextView result = (TextView)findViewById(R.id.result);
        super.onRestoreInstanceState(savedInstanceState);

        result.setText(savedInstanceState.getString("my_text")));
    }

*/

