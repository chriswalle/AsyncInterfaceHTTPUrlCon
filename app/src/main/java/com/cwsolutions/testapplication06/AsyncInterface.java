package com.cwsolutions.testapplication06;

/**
 * Created by Christoffer on 9/17/2015.
 */
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.MainThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Christoffer on 9/15/2015.
 */
public class AsyncInterface extends AsyncTask<String, Integer, String> {

    MainActivity mContext;

    public AsyncInterface(MainActivity context)
    {
        mContext = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mContext.txtInformation.setText("Processing has begun....");
    }

    @Override
    protected String doInBackground(String... params) {

        HttpURLConnection connection = null;
        BufferedReader reader = null;
        StringBuffer buffer = null;

        try {
            URL url = new URL("http://requestb.in/11l5c1v1");
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();

            InputStream stream = connection.getInputStream();

            reader = new BufferedReader(new InputStreamReader(stream));

            buffer = new StringBuffer();
            String line = "";

            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }



        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null);
            {
                connection.disconnect();
            }
            try {
                if(reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return buffer.toString();
}




    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        mContext.txtInformation.setText(values[0] + "");
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        mContext.txtInformation.setText(s);
    }

}