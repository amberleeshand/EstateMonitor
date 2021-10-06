package org.djna.asynch.estate.data;

import java.util.ArrayList;
import java.util.List;


public class HouseList {


    public List<House> getHouses(){
        Temperature temperature = new Temperature();

        List<House> listOfHouses = new ArrayList<>();
        listOfHouses.add(new House(1,1));
        listOfHouses.add(new House(2,1));
        listOfHouses.add(new House(3,1));
        listOfHouses.add(new House(4,1));
        listOfHouses.add(new House(5,1));
        listOfHouses.add(new House(6,1));
        listOfHouses.add(new House(7,1));
        listOfHouses.add(new House(8,1));


        return listOfHouses;
    }

}
