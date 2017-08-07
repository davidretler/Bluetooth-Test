package com.example.android.bluetoothlegatt;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.util.Log;

import java.util.UUID;

/**
 * Created by hp- on 7/29/2017.
 */
public class SensorDataService extends BluetoothLeService {

    private BluetoothGattService testService = mBluetoothGatt.getService(UUID.fromString("742D0BA1-61564DFA8-1B59-860D3AA7A00"));
    private BluetoothGattCharacteristic testCharacteristic = testService.getCharacteristic(UUID.fromString("6DFB20AB-BB41-4BF4-A782-FDDBB4F4FBCD"));

    public SensorDataService() {



    }

    /**
     * Request a read on a given {@code BluetoothGattCharacteristic}. The read result is reported
     * asynchronously through the {@code BluetoothGattCallback#onCharacteristicRead(android.bluetooth.BluetoothGatt, android.bluetooth.BluetoothGattCharacteristic, int)}
     * callback.
     */
    public void readTestValue() {
        if (mBluetoothAdapter == null || mBluetoothGatt == null) {
            Log.w(TAG, "BluetoothAdapter not initialized");
            return;
        }
        mBluetoothGatt.readCharacteristic(testCharacteristic);
    }
    public void writeTestValue(int value) {
        if (mBluetoothAdapter == null || mBluetoothGatt == null) {
            Log.w(TAG, "BluetoothAdapter not initialized");
            return;
        }


        /*get the read characteristic from the service*/
        testCharacteristic.setValue(value,android.bluetooth.BluetoothGattCharacteristic.FORMAT_UINT8,0);
        if(mBluetoothGatt.writeCharacteristic(testCharacteristic) == false){
            Log.w(TAG, "Failed to write characteristic");
        }
    }

}
