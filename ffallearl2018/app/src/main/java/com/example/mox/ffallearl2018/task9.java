package com.example.mox.ffallearl2018;

/**
 * Created by mox on 24/03/2018.
 */


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class task9 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task9);

        Button imageButton = (ImageButton) findViewById(R.id.closeMe)

        ImageButton imgButton =(ImageButton) findViewById(R.id.closeButtonImage);
        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "This button closes the app ", Toast.LENGTH_LONG).show();
                finish();

            }
        });
    }
}
// Setting this feature for closing the app (but doesn't work, having issues...
