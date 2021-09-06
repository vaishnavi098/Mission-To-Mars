package com.MissionToMars;

import java.util.ArrayList;

public class ListofMissionCoordinators {

    private ArrayList<MissionCoordinator> missionCoordinators;
    private MissionCoordinator coordinator;
    private FileIO reader;

   public ListofMissionCoordinators(){
       missionCoordinators = new ArrayList<>();
   }

    public ArrayList<MissionCoordinator> getMissionCoordinators(){
        return missionCoordinators;
    }

    public MissionCoordinator getAMissionCoordinator(int index){
        return missionCoordinators.get(index);
    }

    /**
     *Method to add mission coordinator
     * @param id,name and contact of type string
     */
    public void addCoordinator(String id, String name, String contact){
        missionCoordinators.add( new MissionCoordinator(id, name, contact));
    }

    /**
     *Method to enter mission coordinator list
     */
    public void createMissionCoordinatorsList(){
        reader = new FileIO();
        String coordinatorsString = reader.readFile("missionCoordinators.txt");

        String[] coordinatorsArray;
        coordinatorsArray = coordinatorsString.split("\n");

        for (int i = 0; i < coordinatorsArray.length; i++){
            String[] singleCoordinatorArray = coordinatorsArray[i].split(";");

            missionCoordinators.add(new MissionCoordinator(singleCoordinatorArray[0], singleCoordinatorArray[1], singleCoordinatorArray[2]));
        }
        missionCoordinators.trimToSize();
    }


}
