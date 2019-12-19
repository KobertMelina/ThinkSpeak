package com.example.thinkspeak;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.*;


/**
 * Test Kmmentar
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button;
    EditText number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
        number = (EditText) findViewById(R.id.editText);

    }

    @Override
    public void onClick(View v) {
// Add the request to the queu

         String eingabeNummer = number.getText().toString();

        String url = "https://api.thingspeak.com/update.json?api_key=GJL4J5K1GAG9PMAO&field1=" + eingabeNummer;

        // Request a string response
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });



        Volley.newRequestQueue(this).add(stringRequest);


    }


}
