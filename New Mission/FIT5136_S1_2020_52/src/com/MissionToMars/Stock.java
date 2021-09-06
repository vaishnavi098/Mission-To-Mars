package com.MissionToMars;

import java.util.ArrayList;

public class Stock {
    private String code;
    private String name;
    private Integer numberOnHand;
    private FileIO reader;

    /**
     * Constructor for objects of class stock
     */
    public Stock() {
        code = "";
        name = "";
        numberOnHand = 0;
    }
    /**
     * Non- Default Constructor for objects of class stock
     */
    public Stock(String newCode, String newName, Integer newNumberOnHand) {
        code = newCode;
        name = newName;
        numberOnHand = newNumberOnHand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getNumberOnHand() {
        return numberOnHand;
    }

    public void setNumberOnHand(Integer numberOnHand) {
        this.numberOnHand = numberOnHand;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public ArrayList<ArrayList> importMissionCargo(int index) {
        reader = new FileIO();
        ArrayList<ArrayList> cargoArray = new ArrayList<>();
        String missionsString = reader.readFile("Missions.txt");
        String[] missionsArray = missionsString.split("\n");



        String[] singleMissionArray = missionsArray[index].split(";");

            String[] journeyCargoArray = singleMissionArray[8].trim().split(",");
            ArrayList<Stock> journeyCargo = new ArrayList<>();
            if (journeyCargoArray[0].equals("N/A") == false) {
                if (journeyCargoArray.length > 1) {
                    int j = 0;
                    while (j < journeyCargoArray.length) {
                        Stock cargo = new Stock();
                        cargo.setName(journeyCargoArray[j]);
                        cargo.setNumberOnHand(Integer.parseInt(singleMissionArray[9]));
                        journeyCargo.add(cargo);
                        j++;
                    }
                } else {
                    Stock cargo = new Stock();
                    cargo.setName(singleMissionArray[8]);
                    cargo.setNumberOnHand(Integer.parseInt(singleMissionArray[9]));
                }
            } else {
                journeyCargo = null;
            }

            cargoArray.add(journeyCargo);

            String[] missionCargoArray = singleMissionArray[10].trim().split(",");
            ArrayList<Stock> missionCargo = new ArrayList<>();
            if (missionCargoArray[0].equals("N/A") == false) {
                if (missionCargoArray.length > 1) {
                    int j = 0;
                    while (j < missionCargoArray.length) {
                        Stock cargo = new Stock();
                        cargo.setName(missionCargoArray[j]);
                        cargo.setNumberOnHand(Integer.parseInt(singleMissionArray[11]));
                        journeyCargo.add(cargo);
                        j++;
                    }
                } else {
                    Stock cargo = new Stock();
                    cargo.setName(singleMissionArray[10]);
                    cargo.setNumberOnHand(Integer.parseInt(singleMissionArray[11]));
                }
            } else {
                missionCargo = null;
            }
            cargoArray.add(missionCargo);



    return cargoArray;
    }

}
