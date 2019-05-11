package com.homeinhand.homeinhand;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.burhanhassan.homeinhand.R;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Burhan Hassan on 10/28/2018.
 */

public class RemoteUnitConfig extends Activity {

    private static final String TAG = "MyApp";

    /*File name in which configuration ill be saved.*/
    private String FileName_s;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config_remote_dev);

        Intent callingActivity = getIntent();

        String callingActivity_s = callingActivity.getExtras().getString("CallingActivity");
        FileName_s = callingActivity.getExtras().getString("InternalStorageFileName");

        Log.i(TAG, "RemoteUnitConfig Recieved Data from MainActivity:" );
        Log.i(TAG, "CallingActivity: " + callingActivity_s );
        Log.i(TAG, "File Name " + FileName_s );

    }


    /**
     * This function will gather following information from user, and save this in config file.
     *
     * UnitId_s : The id number of the remote unit, that will be controlled,
     * NoOfDevInUnit_i: Total number of controlable devices attached to Remote Unit.
     *                  The devices may be lights, fans, or any other electric.
     */

    public void SaveConfiguration_Cbk (View v)
    {
        FileOutputStream fileoutputstream = null;
        /* Read Unit ID*/
        EditText UnitIdET = (EditText) findViewById(R.id.in_UnitId);
        String UnitId_s = String.valueOf(UnitIdET.getText());

        /* Read No of devices attached to Unit*/
        EditText DevInUnitET = (EditText) findViewById(R.id.in_NoOdDevInUnit);
        //String NoOfDevInUnit = String.valueOf(DevInUnitET.getText());
        int NoOfDevInUnit_i = Integer.valueOf(String.valueOf(DevInUnitET.getText()));

        Log.i(TAG, "Remote Unit ID: " + UnitId_s );
        Log.i(TAG, "No of Devices in Unit: " + NoOfDevInUnit_i );

        /*Save the configuration in internal storage file FileName_s.*/
        try
        {
            /*MODE_PRIVATE: No other application can access file.*/
            fileoutputstream = openFileOutput(FileName_s, MODE_APPEND);

            /*Write data in file, this may cause IOEXception*/
            fileoutputstream.write(UnitId_s.getBytes());

            /*Set Toast, and make it visible using show method.*/
            Toast.makeText(getApplicationContext(), "Configuration Saved in "+ getFilesDir() + FileName_s + "!!!", Toast.LENGTH_LONG).show();
        }
        catch (FileNotFoundException e)
        {
            /*File not found Exception*/
            Log.i(TAG, "FileNotFoundEXception during opening file: " + FileName_s );


        } catch (IOException e)
        {
            Log.i(TAG, "IOException during writing to file: " + FileName_s );
            e.printStackTrace();
        }
        finally {
            if (fileoutputstream!=null)
            {
                try
                {
                    fileoutputstream.close();
                } catch (IOException e) {
                    Log.i(TAG, "IOException during closing file: " + FileName_s );
                    e.printStackTrace();
                }
            }
        }


        /*Send the user input data back to main activity*/
        Intent returnDataToMainActivity = new Intent();
        returnDataToMainActivity.putExtra("UnitID", UnitId_s);
        setResult(RESULT_OK, returnDataToMainActivity);


        Log.i(TAG, "RemoteUnitConfig work done. Giving Control back to MainActivity." );
        /* Work is completed in this activity. Close it, and pass control to MainActivity.*/
        finish();
    }
}
