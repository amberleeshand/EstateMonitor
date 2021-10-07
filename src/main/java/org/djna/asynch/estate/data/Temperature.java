package org.djna.asynch.estate.data;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

public class Temperature {
    ArrayList<Integer> thermostatReadings = new ArrayList<>();


    public static void main(String[] args) {

        ArrayList<Integer> thermostatReadings= new ArrayList<>();
        thermostatReadings.add(1);
        thermostatReadings.add(10);
        thermostatReadings.add(10);
        thermostatReadings.add(17);
        thermostatReadings.add(20);
        thermostatReadings.add(13);
        thermostatReadings.add(12);
        thermostatReadings.add(30);
        thermostatReadings.add(33);
        thermostatReadings.add(15);
        thermostatReadings.add(-15);
    }

    @RequestMapping("")



    public ArrayList<Integer> getThermostatReadings() {
        return thermostatReadings;
    }

    public void setThermostatReadings(ArrayList<Integer> thermostatReadings) {
        this.thermostatReadings = thermostatReadings;
    }

    @Override
    public String toString() {
        return "ThermostatArrayList{" +
                "thermostatReadings=" + thermostatReadings +
                '}';
    }


}

