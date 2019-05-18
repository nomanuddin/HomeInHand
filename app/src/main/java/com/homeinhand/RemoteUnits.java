package com.homeinhand;

/**
 * Created by Burhan Hassan on 11/18/2018.
 */

public class RemoteUnits {
    static final int MAX_DEVICES = 8;

    /*
        Devices States, to be used in DeviceState[]
     */
    static final int STATE_OFF = 0;
    static final int STATE_ON = 1;
    static final int STATE_NOT_USED = 2;


    private String UnitId;
    private int NoOfDevicesInUnit;

    private int[] DeviceState = new int[MAX_DEVICES];

    /*Constructor*/
    public RemoteUnits() {


        /*Init DeviceState array.*/
        for (int counter = 0; counter < MAX_DEVICES; counter++) {
            DeviceState[counter] = STATE_NOT_USED;
        }
    }

    /*
            Setter Functions
         */
    public void setUnitId(String unitId) {
        UnitId = unitId;
    }

    public void setNoOfDevicesInUnit(int noOfDevicesInUnit) {
        NoOfDevicesInUnit = noOfDevicesInUnit;
    }

    /*
        Getter Functions
    */
    public String getUnitId() {
        return UnitId;
    }

    public int getNoOfDevicesInUnit() {
        return NoOfDevicesInUnit;
    }
}
