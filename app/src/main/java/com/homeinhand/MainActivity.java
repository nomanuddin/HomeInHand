package com.homeinhand;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutionException;

import static java.lang.Boolean.FALSE;

/*  To turn on Device connected to Relay one:
    http://192.168.0.18/?param1=1&param2=1*/

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MyApp";
    private static Context context;
    String serverUri = "http://192.168.0.18/";
    boolean statusBulb1 = FALSE;
    boolean statusBulb2 = FALSE;
    boolean statusBulb3 = FALSE;
    boolean statusBulb4 = FALSE;
    boolean statusBulb5 = FALSE;
    boolean statusBulb6 = FALSE;
    boolean statusBulb7 = FALSE;
    boolean statusBulb8 = FALSE;


    ImageView image1;
    ImageView image2;
    ImageView image3;
    ImageView image4;
    ImageView image5;
    ImageView image6;
    ImageView image7;
    ImageView image8;

    ImageButton imageButton1;
    ImageButton imageButton2;
    ImageButton imageButton3;
    ImageButton imageButton4;
    ImageButton imageButton5;
    ImageButton imageButton6;
    ImageButton imageButton7;
    ImageButton imageButton8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivity.context = getApplicationContext();
        setContentView(R.layout.activity_main);

//        image1 = (ImageView) findViewById(R.id.imageView1);
//        image2 = (ImageView) findViewById(R.id.imageView2);
//        image3 = (ImageView) findViewById(R.id.imageView3);
//        image4 = (ImageView) findViewById(R.id.imageView4);
//        image5 = (ImageView) findViewById(R.id.imageView5);
//        image6 = (ImageView) findViewById(R.id.imageView6);
//        image7 = (ImageView) findViewById(R.id.imageView7);
//        image8 = (ImageView) findViewById(R.id.imageView8);
//
//        imageButton1 = (ImageButton) findViewById(R.id.imageButton1);
//        imageButton2 = (ImageButton) findViewById(R.id.imageButton2);
//        imageButton3 = (ImageButton) findViewById(R.id.imageButton3);
//        imageButton4 = (ImageButton) findViewById(R.id.imageButton4);
//        imageButton5 = (ImageButton) findViewById(R.id.imageButton5);
//        imageButton6 = (ImageButton) findViewById(R.id.imageButton6);
//        imageButton7 = (ImageButton) findViewById(R.id.imageButton7);
//        imageButton8 = (ImageButton) findViewById(R.id.imageButton8);
    }

    public static Context getAppContext() {
        return MainActivity.context;

    }

    public void onClick(ImageButton imageButton) {

//        switch (imageButton.getId()) {
//            case R.id.imageButton1:
//                imageButton1 = (ImageButton) findViewById(R.id.imageButton1);
//                if (statusBulb1) {
//                    imageButton1.setImageResource(R.drawable.ic_off_button);
//                    statusBulb1 = false;
//                    trunBulb1Off(imageButton);
//                } else {
//                    imageButton1.setImageResource(R.drawable.ic_on_button);
//                    statusBulb1 = true;
//                    trunBulb1On(view);
//                }
//            case R.id.imageButton2:
//                imageButton2 = (ImageButton) findViewById(R.id.imageButton2);
//                if (statusBulb2) {
//                    imageButton2.setImageResource(R.drawable.ic_off_button);
//                    statusBulb2 = false;
//                    trunBulb1Off(imageButton);
//                } else {
//                    imageButton2.setImageResource(R.drawable.ic_on_button);
//                    statusBulb2 = true;
//                    trunBulb1On(imageButton);
//                }
//            case R.id.imageButton3:
//                imageButton3 = (ImageButton) findViewById(R.id.imageButton3);
//                if (statusBulb3) {
//                    imageButton3.setImageResource(R.drawable.ic_off_button);
//                    statusBulb3 = false;
//                    trunBulb1Off(imageButton);
//                } else {
//                    imageButton3.setImageResource(R.drawable.ic_on_button);
//                    statusBulb3 = true;
//                    trunBulb1On(imageButton);
//                }
//            case R.id.imageButton4:
//                imageButton4 = (ImageButton) findViewById(R.id.imageButton4);
//                if (statusBulb4) {
//                    imageButton4.setImageResource(R.drawable.ic_off_button);
//                    statusBulb4 = false;
//                    trunBulb1Off(imageButton);
//                } else {
//                    imageButton4.setImageResource(R.drawable.ic_on_button);
//                    statusBulb4 = true;
//                    trunBulb1On(imageButton);
//                }
//            case R.id.imageButton5:
//                imageButton5 = (ImageButton) findViewById(R.id.imageButton5);
//                if (statusBulb5) {
//                    imageButton5.setImageResource(R.drawable.ic_off_button);
//                    statusBulb5 = false;
//                    trunBulb1Off(imageButton);
//                } else {
//                    imageButton5.setImageResource(R.drawable.ic_on_button);
//                    statusBulb5 = true;
//                    trunBulb1On(imageButton);
//                }
//            case R.id.imageButton6:
//                imageButton6 = (ImageButton) findViewById(R.id.imageButton6);
//                if (statusBulb6) {
//                    imageButton6.setImageResource(R.drawable.ic_off_button);
//                    statusBulb6 = false;
//                    trunBulb1Off(imageButton);
//                } else {
//                    imageButton6.setImageResource(R.drawable.ic_on_button);
//                    statusBulb6 = true;
//                    trunBulb1On(imageButton);
//                }
//            case R.id.imageButton7:
//                imageButton7 = (ImageButton) findViewById(R.id.imageButton7);
//                if (statusBulb7) {
//                    imageButton7.setImageResource(R.drawable.ic_off_button);
//                    statusBulb7 = false;
//                    trunBulb1Off(imageButton);
//                } else {
//                    imageButton7.setImageResource(R.drawable.ic_on_button);
//                    statusBulb7 = true;
//                    trunBulb1On(imageButton);
//                }
//            case R.id.imageButton8:
//                imageButton8 = (ImageButton) findViewById(R.id.imageButton8);
//                if (statusBulb8) {
//                    imageButton8.setImageResource(R.drawable.ic_off_button);
//                    statusBulb8 = false;
//                    trunBulb1Off(imageButton);
//                } else {
//                    imageButton8.setImageResource(R.drawable.ic_on_button);
//                    statusBulb8 = true;
//                    trunBulb1On(imageButton);
//                }
//        }

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
