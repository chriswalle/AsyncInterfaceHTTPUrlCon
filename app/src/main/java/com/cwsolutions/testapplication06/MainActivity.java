package com.cwsolutions.testapplication06;

import android.annotation.TargetApi;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    public TextView txtInformation;
    private Button btnCheckHTTPRequest;

    //HttpClients mHttpClients = new HttpClients();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtInformation = (TextView) findViewById(R.id.txtInformation);
        btnCheckHTTPRequest = (Button) findViewById(R.id.btnCheckHTTPRequest);


        btnCheckHTTPRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // check if you are connected or not
                /*if (isConnected()) {
                    // txtInformation.setText("You are connected");
                    try {
                        //txtInformation.setText(GET("http://hmkcode.com/examples/index.php") + "");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    txtInformation.setText("You are NOT conncted");
                }
*/

                new AsyncInterface(MainActivity.this).execute();


    }


    /*


    // check network connection
    /*public boolean isConnected(){
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(this.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected())
            return true;
        else
            return false;
    }
    */

});}}
