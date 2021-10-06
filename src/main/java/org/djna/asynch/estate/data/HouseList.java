package org.djna.asynch.estate.data;

import java.util.ArrayList;
import java.util.List;


public class HouseList {


    public List<House> getHouses(){
        Temperature temperature = new Temperature();

        List<House> listOfHouses = new ArrayList<>();
        for(int i = 1; i <=8; i++){
            listOfHouses.add(new House(i,temperature.getThermostatReadings().get(1)));
        }
        System.out.println(listOfHouses);
        return listOfHouses;
    }

}
