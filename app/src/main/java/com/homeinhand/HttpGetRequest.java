package com.homeinhand.homeinhand;

import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Burhan Hassan on 9/23/2018.
 */

public class HttpGetRequest extends AsyncTask<String, String, String>
{
    public static final String REQUEST_METHOD = "GET";
    public static final int READ_TIMEOUT = 1500;
    public static final int CONNECTION_TIMEOUT = 1500;
    String responseFromServer = "";


    @Override
    protected String doInBackground(String... params){
        String stringUrl = params[0];
        String result;
        String inputLine;

        //Create a URL object holding our url
        URL myUrl = null;
        try
        {
            myUrl = new URL(stringUrl);
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
        //Create a connection
        HttpURLConnection connection = null;
        try
        {
            connection = (HttpURLConnection)myUrl.openConnection();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        try
        {
            //Set methods and timeouts
            connection.setRequestMethod(REQUEST_METHOD);
            connection.setReadTimeout(READ_TIMEOUT);
            connection.setConnectTimeout(CONNECTION_TIMEOUT);

            //Connect to our url
            connection.connect();

            //Create a new InputStreamReader
            InputStreamReader streamReader = new
                    InputStreamReader(connection.getInputStream());

            //Create a new buffered reader and String Builder
            BufferedReader reader = new BufferedReader(streamReader);
            StringBuilder stringBuilder = new StringBuilder();

            //Check if the line we are reading is not null
            while((inputLine = reader.readLine()) != null){
                stringBuilder.append(inputLine);
            }
            //Close our InputStream and Buffered reader
            reader.close();
            streamReader.close();
            //Set our result equal to our stringBuilder
            result = stringBuilder.toString();
        }
        catch(IOException e)
        {
            e.printStackTrace();
            result = null;
        }
        responseFromServer = result;
        return result;
    }



    @Override
    protected void onPostExecute(String result)
    {
        if (responseFromServer == null)
        {
            Toast.makeText(MainActivity.getAppContext(), "No Response From Server!!!", Toast.LENGTH_LONG).show();
        }
        else if(responseFromServer.contains("OK"))
        {
            Toast.makeText(MainActivity.getAppContext(), "The Action is performed successfully!!!", Toast.LENGTH_LONG).show();
        }
    }
}
