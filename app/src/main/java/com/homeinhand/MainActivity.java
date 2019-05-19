package com.homeinhand;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutionException;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

/*  To turn on Device connected to Relay one:
    http://192.168.0.18/?param1=1&param2=1*/

public class MainActivity extends Activity {
    public static final String  BUTTON_MESSAGE = "";
    private static final String TAG = "MyApp";
    private static Context context;
    String serverUri = "http://192.168.0.18/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivity.context = getApplicationContext();
        setContentView(R.layout.activity_main);
    }

    public static Context getAppContext() {
        return MainActivity.context;

    }
    public void onClickButton(View view) {
        Intent intent = new Intent(this, Room.class);
        String message = String.valueOf(view.getId());
        intent.putExtra(BUTTON_MESSAGE, message);
        startActivity(intent);
    }

    /*  Function: trunBulb1On
        Description: This API will send the request to Client to turn the specific Bulb ON*/
    public void trunBulb1On(View view) {
        Log.i(TAG, "trunBulb1On called");
        String ret = "";
        ret = sendRequestToServer("1");

        if (ret != null) {
            if (ret.contains("OK")) {
                /*Update image : BulbOff*/
            }
        }

    }

    /*  Function: trunBulb1Off
        Description: This API will send the request to Client to turn the specific Bulb OFF*/
    public void trunBulb1Off(View view) {
        Log.i(TAG, "trunBulb1Off called");
        String ret = "";
        ret = sendRequestToServer("0");

        if (ret != null) {
            if (ret.contains("OK")) {
                /*Update image : BulbOff*/
                //to do
                //image.setImageResource(R.drawable.ic_bulb_off);
            }
        }

    }


    public String sendRequestToServer(String req) {
        String uri = createUriRequestString(req);
        Log.i(TAG, "createUriRequestString called.");
        String ret = null;
        try {
            //Instantiate new instance of our class
            HttpGetRequest getRequest = new HttpGetRequest();
            //Perform the doInBackground method, passing in our url
            ret = getRequest.execute(uri).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
            Log.e(TAG, e.getMessage(), e);
        } catch (ExecutionException e) {
            e.printStackTrace();
            Log.e(TAG, e.getMessage(), e);
        }

        return ret;
    }


    /*This API will create the complete Server Request, and return the Uri to caller.*/
    public String createUriRequestString(String req) {
        String Uri;
        //http://192.168.0.18/?param1=1&param2=1

        Uri = serverUri;
        Uri = Uri + "?param1=1&param2=" + req;
        Log.i(TAG, "Server URI STring created." + Uri);

        return Uri;

    }
    /* Callback for but_DisplayAvailableUnits*/

    public void DisplayAvailableUnits_Cbk(View v) {
        FileInputStream fileInputStream = null;
        TextView TextAvailableUnits;
        TextAvailableUnits = findViewById(R.id.tV_AvailableUnits);
        try {
            fileInputStream = openFileInput("ConfigFile.txt");

            InputStreamReader isr = new InputStreamReader(fileInputStream);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;

            while ((text = br.readLine()) != null) {
                sb.append(text).append("\n");
            }

            TextAvailableUnits.append(sb.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            /*Esception during br.readline()*/
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    /*Exception whiele closing file*/
                    e.printStackTrace();
                }
            }
        }

    }

    /* Callback for but_ConfigRemoteUnit
     * This method will call "RemoteUnitConfig" Activity.
     * And send data File name of internal storage, to save configuration data.*/
    public void ConfigureRemoteUnit_Cbk(View v) {

        Intent configRemoteUnit = new Intent(this,
                RemoteUnitConfig.class);

        final int result = 1;
        configRemoteUnit.putExtra("CallingActivity", "MainActivity");
        configRemoteUnit.putExtra("InternalStorageFileName", "ConfigFile.txt");
        startActivityForResult(configRemoteUnit, result);
    }

    /*This method is executed when Activity "RemoteUnitConfig" is closed.*/
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        final int SELECTOR_CONST = 1;

        super.onActivityResult(requestCode, resultCode, data);
        Log.i(TAG, "Return Received from RemoteUnitConfig.");

        if (requestCode == SELECTOR_CONST) {
            if (resultCode == RESULT_OK) {
                String recUnitId = data.getExtras().getString("UnitID");
                Log.i(TAG, "Received UnitID from RemoteUnitConfig:");
                Log.i(TAG, recUnitId);
            }
        }
    }
}
