package com.example.android.bluetoothlegatt.Bluetooth;

import java.util.List;
import java.util.UUID;

/**
 * Created by hp- on 7/29/2017.
 */
public class BluetoothService {

    private UUID serviceID;

    private List<BluetoothCharacteristic> characteristics;

    public UUID getServiceID() {
        return serviceID;
    }
}
