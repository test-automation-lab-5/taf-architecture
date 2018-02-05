package main.businessobjects;

import properties.DataProp;

import java.io.IOException;

public class DataBusinessObject {

    public void setDriver() throws IOException {
        DataProp dataProp = new DataProp();
        System.setProperty(dataProp.driver(), dataProp.driverPath());
    }
}
