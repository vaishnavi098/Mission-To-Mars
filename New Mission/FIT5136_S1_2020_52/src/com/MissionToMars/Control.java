package com.MissionToMars;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;


public class Control {
    private FileIO reader;
    private Administrator administrator;
    private ArrayList<SpaceShuttle> spaceShuttles;
    private ArrayList<Candidate> candidates;
    private ArrayList<Mission> missions;
    private ArrayList<Stock> listOfStock;
    private ArrayList<MissionCoordinator> missionCoordinators;

    /**
     *Non-Default Constructor for objects of class Control
     */
    public Control() {
        spaceShuttles = new ArrayList<>();
        candidates = new ArrayList<>();
        missions = new ArrayList<>();
        listOfStock = new ArrayList<>();
        missionCoordinators = new ArrayList<>();
        administrator = new Administrator();
    }

    public void setMissions(ArrayList<Mission> missions) {
        this.missions = missions;
    }

    public ArrayList<Mission> getMissions() {
        return missions;
    }

    public Administrator getAdministrator()
    {
        return administrator;
    }

    public void setAdministrator(Administrator administrator)
    {
        this.administrator = administrator;
    }

    /**
     * Method to create a new mission
     */
    public void createMission(){
        Mission mission = new Mission();
        Validate va = new Validate();
        //get user's input
        String mId = va.acceptStringInput("Please enter the mission ID: ");
        mission.setMissionId(mId);
        String mName = va.acceptStringInput("Please enter mission name: ");
        mission.setMissionName(mName);
        String mDesc = va.acceptStringInput("Please enter mission description: ");
        mission.setMissionDesc(mDesc);
        String mType = va.acceptStringInput("Please enter mission type: ");
        mission.setMissionType(mType);
        String origin = va.acceptStringInput("Please enter country of origin: ");
        mission.setOrigin(origin);
        ArrayList<String> countries = inputCountriesAllowed();
        mission.setCountriesAllowed(countries);
        String date = va.acceptStringInput("Please enter the launch date: ");
        mission.setLaunchDate(date);
        String destLocation = va.acceptStringInput("Please enter the destination location: ");
        mission.setDestLocation(destLocation);
        int duration = va.acceptIntegerInput("Please enter mission duration:");
        mission.setMissionDuration(duration);
        String mStatus = selectMissionStatus();
        mission.setMissionStatus(mStatus);
        ArrayList<String[]> jobs = inputJobs();
        mission.setJobs(jobs);
        ArrayList<String[]> requirements = inputRequirements();
        mission.setEmploymentRequirements(requirements);
        MissionCoordinator coordinator = inputCoordinator();
        mission.setCoordinator(coordinator);
        //cargo requirements
        ArrayList<ArrayList<String>> cargo = cargoRequirements();
        ArrayList<Stock> stockList = new ArrayList<>();
        ArrayList < String > newJourneyCargo = cargo.get(0);
        for(int i = 0; i < newJourneyCargo.size(); i++)
        {
            Stock stock = new Stock();
            stock.setName(newJourneyCargo.get(i));
            stockList.add(stock);
        }
        ArrayList < String > newMissionCargo = cargo.get(1);
        for(int i = 0; i < newMissionCargo.size(); i++)
        {
            Stock stock = new Stock();
            stock.setName(newMissionCargo.get(i));
            stockList.add(stock);
        }
        ArrayList < String > newOtherCargo = cargo.get(2);
        for(int i = 0; i < newOtherCargo.size(); i++)
        {
            Stock stock = new Stock();
            stock.setName(newOtherCargo.get(i));
            stockList.add(stock);
        }
        mission.setJourneyCargo(stockList);
        missions.add(mission);
        displayMission(mission);
        System.out.println("Mission Created!");
    }

    /**
     *Method to display mission
     */
    public void displayMission(Mission mission)
    {
        System.out.println("* Mission ID: " + mission.getMissionId());
        System.out.println("1. Mission name: " + mission.getMissionName());
        System.out.println("2. Mission description: " + mission.getMissionDesc());
        System.out.println("3. Country of origin: " + mission.getOrigin());
        System.out.println("4. Countries allowed: " + mission.getCountriesAllowed());
        System.out.println("5. Coordinator: " + mission.getCoordinator().getName() +
                " info:" +mission.getCoordinator().getContactNumber());

        System.out.println("6. Job: ");
        for(int i = 0; i < mission.getJobs().size(); i++)
        {
            System.out.println(Arrays.toString(mission.getJobs().get(i)));
        }

        System.out.println("7. Employment requirements: ");
        for(int i = 0 ;i < mission.getEmploymentRequirements().size(); i++)
        {
            System.out.println(Arrays.toString(mission.getEmploymentRequirements().get(i)));
        }

        System.out.println("8. Cargo requirements");
        System.out.println("a. Cargo requirements for journey: ");
        try
        {
            for (int i = 0; i < mission.getJourneyCargo().size(); i++)
            {
                ArrayList<String> js = new ArrayList<>();
                js.add(mission.getJourneyCargo().get(i).getName());
                System.out.print(js);
                System.out.println();
            }
        }catch(Exception e){
            e.fillInStackTrace();
        }
        try
        {
            System.out.println("b. Cargo requirements for the Mission: ");
            for (int i = 0; i < mission.getMissionCargo().size(); i++)
            {
                ArrayList<String> ms = new ArrayList<>();
                ms.add(mission.getMissionCargo().get(i).getName());
                System.out.print(ms);
                System.out.println();
            }
        }catch(Exception e){
            e.fillInStackTrace();
        }
        try
        {
            System.out.println("c. Cargo requirements for other Missions: ");
            for (int i = 0; i < mission.getOtherMissionCargo().size(); i++)
            {
                ArrayList<String> os = new ArrayList<>();
                os.add(mission.getOtherMissionCargo().get(i).getName());
                System.out.print(os);
                System.out.println();
            }
        }catch(Exception e){
            e.fillInStackTrace();
        }
        System.out.println("9. Launch date: " + mission.getLaunchDate());
        System.out.println("10. Location of the destination: " + mission.getDestLocation());
        System.out.println("11. Duration of the mission: " + mission.getMissionDuration());
        System.out.println("12. Status of the mission: " + mission.getMissionStatus());
    }

    /**
     *Method to get edit input
     */
    public void getEditInput()
    {
        Mission mission = inputMissionId();
        boolean flag = true;
        Validate va = new Validate();
        //mission select
        while(flag){
            displayMission(mission);
            String option = va.acceptStringInput("Please select which information do you want to edit: ");
            if (va.isEditNumber(option)){
                Mission newMission = editMission(mission, option);
                System.out.println("Note: Enter y for YES and n for NO.");
                //displayMission(newMission);
                String choice = va.acceptStringInput("Do you want to edit another information? Enter y/n");
                if (choice.trim().equals("n"))
                {
                    displayMission(newMission);
                    System.out.println("Edit completed");
                    flag = false;
                }
            }
            else{
                System.out.println("Please enter an option from 1-12");
            }
        }
    }

    /**
     *Method to Edit mission
     * @param  mission and option
     * @return Mission
     */
    public Mission editMission(Mission mission, String option){
        Validate va = new Validate();
        switch (option)
        {
            case "1":
                String mName = va.acceptStringInput("Please enter a new mission name: ");
                mission.setMissionName(mName);
                System.out.println("1. New Mission Name: " + mission.getMissionName());
                return mission;
            case "2":
                String mId = va.acceptStringInput("Please enter a new mission description: ");
                mission.setMissionDesc(mId);
                System.out.println("2. New Mission Description: " + mission.getMissionDesc());
                return mission;
            case "3":
                String origin = va.acceptStringInput("Please enter a new country of origin: ");
                mission.setOrigin(origin);
                System.out.println("3. New country of origin: " + mission.getOrigin());
                return mission;
            case "4":
                ArrayList<String> countries = inputCountriesAllowed();
                mission.setCountriesAllowed(countries);
                System.out.println("4. New countries allowed: " + mission.getCountriesAllowed());
                return mission;
            case "5":
                MissionCoordinator coordinator = inputCoordinator();
                mission.setCoordinator(coordinator);
                System.out.println("5. New Mission Coordinator is: " + mission.getCoordinator().getName() +
                        " info:" +mission.getCoordinator().getContactNumber());
                return mission;
            case "6":
                ArrayList<String[]> jobs = inputJobs();
                mission.setJobs(jobs);
                System.out.println("6. New job: ");
                for(int i = 0; i < mission.getJobs().size(); i++)
                {
                    System.out.println(Arrays.toString(mission.getJobs().get(i)));
                }
                return mission;
            case "7":
                ArrayList<String[]> requirements = inputRequirements();
                mission.setEmploymentRequirements(requirements);
                System.out.println("7. New employment requirements: ");
                for(int i = 0 ;i < mission.getEmploymentRequirements().size(); i++)
                {
                    System.out.println(Arrays.toString(mission.getEmploymentRequirements().get(i)));
                }
                return mission;
            case "8":
                ArrayList<ArrayList<String>> cargo = cargoRequirements();
                ArrayList<Stock> stockList = new ArrayList<>();
                ArrayList < String > newJourneyCargo = cargo.get(0);
                for(int i = 0; i < newJourneyCargo.size(); i++)
                {
                    Stock stock = new Stock();
                    stock.setName(newJourneyCargo.get(i));
                    stockList.add(stock);
                }
                ArrayList<Stock> stockList2 = new ArrayList<>();
                ArrayList < String > newMissionCargo = cargo.get(1);
                for(int i = 0; i < newMissionCargo.size(); i++)
                {
                    Stock stock = new Stock();
                    stock.setName(newMissionCargo.get(i));
                    stockList2.add(stock);
                }
                ArrayList<Stock> stockList3 = new ArrayList<>();
                ArrayList < String > newOtherCargo = cargo.get(2);
                for(int i = 0; i < newOtherCargo.size(); i++)
                {
                    Stock stock = new Stock();
                    stock.setName(newOtherCargo.get(i));
                    stockList3.add(stock);
                }
                mission.setJourneyCargo(stockList);
                mission.setMissionCargo(stockList2);
                mission.setOtherMissionCargo(stockList3);
                System.out.println("8. New cargo requirements");
                return mission;
            case "9":
                String date = va.acceptStringInput("Please enter a new launch date: ");
                mission.setLaunchDate(date);
                System.out.println("9. New launch date: " + mission.getLaunchDate());
                return mission;
            case "10":
                String destLocation = va.acceptStringInput("Please enter a new destination location: ");
                mission.setDestLocation(destLocation);
                System.out.println("10. New location of the destination: " + mission.getDestLocation());
                return mission;
            case "11":
                int duration = va.acceptIntegerInput("Please enter a new mission duration:");
                mission.setMissionDuration(duration);
                System.out.println("11. New duration of the mission: " + mission.getMissionDuration());
                return mission;
            case "12":
                String mStatus = selectMissionStatus();
                mission.setMissionStatus(mStatus);
                System.out.println("12. New status of the mission: " + mission.getMissionStatus());
                return mission;
        }
        return mission;
    }


    /**
     *Method to enter countries allowed
     * @return Arraylist of type string
     */
        public ArrayList<String> inputCountriesAllowed() {

        Validate va = new Validate();
        boolean flag = true;
        ArrayList<String> countryList = new ArrayList<>();
        System.out.println("Note: Enter at least one country a time: ");
        while (flag) {
            Boolean add = true;
            String country = va.acceptStringInput("Please enter countries allowed: ");
            for (String s : countryList) {
                if (country.trim().equals(s)) {
                    System.out.println(country + " already exist! Enter another country that is allowed.");
                    add = false;
                    break;
                }
            }
            if (add) {
                countryList.add(country);
            }
            System.out.println("Note: Enter y for YES and n for NO.");
            String choice = va.acceptStringInput("Do you want to add more? Enter y/n");
            if (choice.trim().equals("n")) {
                flag = false;
                System.out.println("Countries allowed added " + countryList);
            }
        }
        return countryList;
    }

    /**
     *Method to select the mission status
     * @return string
     */
    public String selectMissionStatus(){
        String statusSelect = "Planning phase";
        Validate va = new Validate();
        ArrayList<String> status = new ArrayList<>(Arrays.asList("Planning phase", "Departed Earth", "Landed on Mars",
                "Mission in progress", "Returned to Earth", "Mission completed"));
        System.out.println("Please select status from the following options");
        System.out.println("1. Planning phase");
        System.out.println("2. Departed Earth");
        System.out.println("3. Landed on Mars");
        System.out.println("4. Mission in progress");
        System.out.println("5. Returned to Earth");
        System.out.println("6. Mission completed");
        int input = va.acceptIntegerInput("Enter the number of status: ");
        switch (input)
        {
            case 1:
                statusSelect = status.get(0);
                break;
            case 2:
                statusSelect = status.get(1);
                break;
            case 3:
                statusSelect = status.get(2);
                break;
            case 4:
                statusSelect = status.get(3);
                break;
            case 5:
                statusSelect = status.get(4);
                break;
            case 6:
                statusSelect = status.get(5);
        }
        System.out.println("Status of the mission is " + statusSelect);
        return statusSelect;
    }

    /**
     *Method to enter the jobs list for the mission
     * @return Arraylist of type string array
     */
    public ArrayList<String[]> inputJobs(){
        ArrayList<String[]> jobs = new ArrayList<>();
        Validate va = new Validate();
        boolean flag = true;
        System.out.println("Note: Enter at least one job name a time.");
        while (flag)
        {
            String jobName = va.acceptStringInput("Please enter the job name: ");
            String jobDesc = va.acceptStringInput("Please enter the job description: ");
            String[] job = new String[]{jobName, jobDesc};
            jobs.add(job);
            System.out.println("Note: Enter y for YES and n for NO.");
            String choice = va.acceptStringInput("Do you want to add another job? Enter y/n");
            if (choice.trim().equals("n"))
            {
                flag = false;
                System.out.println("Jobs added");
            }
        }
        return jobs;
    }

    /**
     *Method to enter input requirements
     * @return Arraylist of type string array
     */
    public ArrayList<String[]> inputRequirements(){
        ArrayList<String[]> requirements = new ArrayList<>();
        Validate va = new Validate();
        boolean flag = true;
        System.out.println("Note: Enter at least one employment title a time.");
        while (flag)
        {
            String reTitle = va.acceptStringInput("Please enter the employment title: ");
            String reNum = va.acceptStringInput("Please enter the number of employees required: ");
            String[] re = new String[]{reTitle, reNum};
            requirements.add(re);
            System.out.println("Note: Enter y for YES and n for NO.");
            String choice = va.acceptStringInput("Do you want to add another " +
                    "Employment requirement? Enter y/n");
            if (choice.trim().equals("n"))
            {
                flag = false;
                System.out.println("Employment requirements added");
                //System.out.println(Arrays.toString(requirements.get(requirements.size() - 1)));
            }
        }
        return requirements;
    }

    /**
     *Method to enter Coordinator details
     * @return MissionCoordinator
     */
    public MissionCoordinator inputCoordinator(){
        Validate va = new Validate();
        MissionCoordinator coordinator = new MissionCoordinator();
        String cName = va.acceptStringInput("Please enter the Coordinator’s name: ");
        coordinator.setName(cName);
        String cInfo = va.acceptStringInput("Please enter the Coordinator’s contact information: ");
        coordinator.setContactNumber(cInfo);
        return coordinator;
    }

    /**
     *Method to enter cargo requirements
     * @return Arraylist of type arraylist of strings
     */
    public ArrayList<ArrayList<String>> cargoRequirements(){
        Validate va = new Validate();
        boolean flag = true;
        ArrayList<String> newJourneyCargo = new ArrayList<>();
        ArrayList<String> newMissionCargo = new ArrayList<>();
        ArrayList<String> newOtherMissionCargo = new ArrayList<>();
        ArrayList<ArrayList<String>> cargo = new ArrayList<>();
        System.out.println("Note: Enter p to skip.");
        System.out.println("Note: Enter y for YES and n for NO.");
        while (flag)
        {
            String jCargo = va.acceptStringInput("Please enter the Cargo requirement for journey: ");
            Boolean add = true;
            for (String s : newJourneyCargo)
            {
                if (jCargo.equals(s))
                {
                    System.out.println(jCargo + " already exist. Enter another cargo.");
                    add = false;
                    break;
                }
            }
            if(jCargo.equals("p"))
                break;
            if(add){
                newJourneyCargo.add(jCargo);
                String choice = va.acceptStringInput("Do you want to add more? Enter y/n");
                if (choice.trim().equals("n"))
                {
                    flag = false;
                    System.out.println("Journey Cargo requirements added " + newJourneyCargo);
                }
            }
        }
        cargo.add(newJourneyCargo);
        flag = true;
        while (flag)
        {
            String mCargo = va.acceptStringInput("Please enter the cargo requirement for mission: ");

            Boolean add = true;
            for (String s : newMissionCargo)
            {
                if (mCargo.equals(s))
                {
                    System.out.println(mCargo + " already exist. Enter another cargo.");
                    add = false;
                    break;
                }
            }
            if(mCargo.equals("p"))
                break;
            if(add){
                newMissionCargo.add(mCargo);
                String choice = va.acceptStringInput("Do you want to add more ? Enter y/n");
                if (choice.trim().equals("n"))
                {
                    flag = false;
                    System.out.println("Mission cargo requirements added " + newMissionCargo);
                }
            }
        }
        cargo.add(newMissionCargo);
        flag = true;
        while (flag)
        {
            String oCargo = va.acceptStringInput("Please Enter the Cargo requirement for other mission: ");

            Boolean add = true;
            for (String s : newOtherMissionCargo)
            {
                if (oCargo.equals(s))
                {
                    System.out.println(oCargo + " already exist! Enter another cargo!");
                    add = false;
                    break;
                }
            }
            if(oCargo.equals("p"))
                break;
            if(add){
                newOtherMissionCargo.add(oCargo);
                String choice = va.acceptStringInput("Do you want to add more ? Enter y/n");
                if (choice.trim().equals("n"))
                {
                    flag = false;
                    System.out.println("Other mission cargo requirements added " + newOtherMissionCargo);
                }
            }
        }
        cargo.add(newOtherMissionCargo);
        return cargo;
    }

    /**
     *Method to import all data
     */
    public void importAllData(){
        reader = new FileIO();
        //import mission coordinators
        String coordinatorsString = reader.readFile("missionCoordinators.txt");
        String[] coordinatorsArray;
        coordinatorsArray = coordinatorsString.split("\n");
        for (int i = 0; i < coordinatorsArray.length; i++){
            String[] singleCoordinatorArray = coordinatorsArray[i].split(";");

            missionCoordinators.add(new MissionCoordinator(singleCoordinatorArray[0], singleCoordinatorArray[1], singleCoordinatorArray[2]));
        }
        missionCoordinators.trimToSize();
        //import shuttle data
        String shuttlesString = reader.readFile("shuttles.txt");
        String[] shuttlesArray = shuttlesString.split("\n");
        for (int i = 0; i < shuttlesArray.length; i++){
            String[] singleShuttleArray = shuttlesArray[i].split(";");

            spaceShuttles.add(new SpaceShuttle(singleShuttleArray[0], singleShuttleArray[1], singleShuttleArray[2], singleShuttleArray[3], singleShuttleArray[4], singleShuttleArray[5], singleShuttleArray[6], singleShuttleArray[7]));
        }
        spaceShuttles.trimToSize();
        //import candidate data
        candidates = new ArrayList<Candidate>();
        String candidatesString = reader.readFile("candidates.txt");
        String[] candidatesArray = candidatesString.split("\n");
        for (int i = 0; i < candidatesArray.length; i++) {
            String[] singleCandidateArray = candidatesArray[i].trim().split(";");

            String[] qualsArray = singleCandidateArray[10].split(",");
            ArrayList<String> qualifications = new ArrayList<>();
            int j = 0;
            while (j < qualsArray.length){
                qualifications.add(qualsArray[j]);
                j = j+1;
            }
            String[] occupationArray = singleCandidateArray[11].trim().split(",");
            String[] workYearsArray = singleCandidateArray[12].trim().split(",");
            ArrayList<String[]> work = new ArrayList<String[]>();
            if (singleCandidateArray[11].equals("N/A") == false) {
                if (occupationArray.length > 1) {
                    int a = 0;
                    while (a < occupationArray.length) {
                        work.add(new String[] {occupationArray[a],workYearsArray[a]});
                        a++;
                    }
                } else {
                    work.add(new String[] {singleCandidateArray[11], singleCandidateArray[12]});
                }
            }else{
                work = null;
            }
            String[] languagesArray = singleCandidateArray[14].trim().split(",");
            ArrayList<String> languages = new ArrayList<String>();
            if (languagesArray.length > 1) {
                int b = 0;
                while (b < languagesArray.length){
                    languages.add(languagesArray[b]);
                    b++;
                }
            }else{
                languages.add(singleCandidateArray[14]);
            }
            ArrayList<String> allergies = new ArrayList<>();
            allergies.add(singleCandidateArray[8]);
            ArrayList<String> food = new ArrayList<>();
            food.add(singleCandidateArray[9]);
            candidates.add(new Candidate(singleCandidateArray[0], singleCandidateArray[1], singleCandidateArray[2], singleCandidateArray[3], singleCandidateArray[4], singleCandidateArray[5], singleCandidateArray[6], singleCandidateArray[7], allergies, food, qualifications, work, singleCandidateArray[13],  languages, null, null));
        }
        candidates.trimToSize();
        //import stock data
        String stockString = reader.readFile("warehouse.txt");

        String[] stockArray = stockString.split("\n");

        for (int i = 0; i < stockArray.length; i++){
            String[] singleStockArray = stockArray[i].split(";");

            listOfStock.add(new Stock(singleStockArray[0], singleStockArray[1], Integer.parseInt(singleStockArray[2])));
        }
        listOfStock.trimToSize();
        // import mission data
        missions = new ArrayList<>();
        String missionsString = reader.readFile("missions.txt");
        String[] missionsArray = missionsString.split("\n");
        for (int i = 0; i < missionsArray.length; i++) {
            String[] singleMissionArray = missionsArray[i].split(";");
            String[] journeyCargoArray = singleMissionArray[8].trim().split(",");
            ArrayList<Stock> journeyCargo = new ArrayList<>();
            if (!singleMissionArray[10].trim().equals("N/A")) {
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
            String[] missionCargoArray = singleMissionArray[10].trim().split(",");
            ArrayList<Stock> missionCargo = new ArrayList<>();
            if (!singleMissionArray[10].equals("N/A")) {
                if (missionCargoArray.length > 1) {
                    int j = 0;
                    while (j < missionCargoArray.length) {
                        Stock cargo = new Stock();
                        cargo.setName(missionCargoArray[j]);
                        cargo.setNumberOnHand(Integer.parseInt(singleMissionArray[11]));
                        missionCargo.add(cargo);
                        j++;
                    }
                } else {
                    Stock cargo = new Stock();
                    cargo.setName(singleMissionArray[10]);
                    cargo.setNumberOnHand(Integer.parseInt(singleMissionArray[11]));
                    missionCargo.add(cargo);
                }
            } else {
                missionCargo = null;
            }
            //creating jobs
            ArrayList<String[]> jobs = new ArrayList<>();
            jobs.add(new String[] {singleMissionArray[16], singleMissionArray[17]});
            ArrayList<String[]> employmentRequirements = new ArrayList<>();
            employmentRequirements.add(new String[] {singleMissionArray[18], singleMissionArray[19]});
            //import selection criteria for the mission
            String selectionString = reader.readFile("selectionCriteria.txt");
            String[] selectionArray = selectionString.split("\n");
            String[] singleSelection = selectionArray[i].trim().split(";");
            String[] languagesArray = singleSelection[7].trim().split(",");
            ArrayList<String> secondLanguages = new ArrayList<String>();
            if (languagesArray.length > 1) {
                int b = 0;
                while (b < languagesArray.length){
                    secondLanguages.add(languagesArray[b]);
                    b++;
                }
            }else{
                secondLanguages.add(singleSelection[7]);
            }
            SelectionCriteria selectionCriteria = new SelectionCriteria(Integer.parseInt(singleSelection[0])
                    , Integer.parseInt(singleSelection[1]), Integer.parseInt(singleSelection[2]), singleSelection[3]
                    , singleSelection[4], singleSelection[5], singleSelection[6],secondLanguages);

            missions.add(new Mission(singleMissionArray[0], singleMissionArray[1], singleMissionArray[2], singleMissionArray[3]
                    , null, Integer.parseInt(singleMissionArray[5]), singleMissionArray[6], singleMissionArray[7]
                    , journeyCargo, missionCargo, null, singleMissionArray[11], singleMissionArray[12]
                    , jobs, employmentRequirements, selectionCriteria, null, null, new MissionCoordinator()));
        }
    }

    /**
     * Method to select the Space Shuttle
     */
    public void selectSpaceShuttle (){
        Validate va = new Validate();
        Mission mission = inputMissionId();
        boolean flag = true;
        for (int i = 0; i < spaceShuttles.size(); i++)
        {
            SpaceShuttle shuttle = spaceShuttles.get(i);
            System.out.println("Shuttle ID: " + shuttle.getShuttleId() + " Shuttle name: " + shuttle.getShuttleName()
                    + " Manufacture year: " + shuttle.getManufactureYear() + " Fuel capacity (Litres): "
                    + shuttle.getFuelCapacity() + " Passenger capacity: " + shuttle.getPassengerCapacity()
                    + " Cargo capacity (kgs): " + " Travel speed: " + shuttle.getTravelSpeed() + " Origin: " + shuttle.getOrigin());
        }
        do
        {
            String shuttleSelection = va.acceptStringInput("Please enter the Shuttle ID you would like to select");
            for (int z = 0; z < spaceShuttles.size(); z++)
            {
                if (spaceShuttles.get(z).getShuttleId().equals(shuttleSelection))
                {
                    mission.setSpaceShuttle(spaceShuttles.get(z));
                    System.out.println("Space shuttle " + spaceShuttles.get(z).getShuttleName() + "is selected for mission " + mission.getMissionId());
                    flag = false;
                    break;
                }
            }
            System.out.println("Shuttle ID not found! please choose from the list");
        } while(flag);
    }

    /**
     * Method to display main menu and get the menu options input by user
     *
     * @return A single String which contains the user input
     */
    public String menuSelect()
    {
        boolean flag = true;
        String input = "";
        Validate va = new Validate();
        while(flag){
            String menu = "======================Mission to Mars========================\n"
                    + "Please select from the following options\n"
                    + "Enter 1 to Login\n"
                    + "Enter 2 to select the Space Shuttle\n"
                    + "Enter 3 to create Mission\n"
                    + "Enter 4 to edit Mission\n"
                    + "Enter 5 to create Selection Criteria\n"
                    + "Enter 6 to find N Best Candidates\n"
                    + "Enter 7 to exit";
            System.out.print(menu);
            input = va.acceptStringInput("");
            if (input.equals("1") || input.equals("2") || input.equals("3") || input.equals("4") || input.equals("5")
                    || input.equals("6") || input.equals("7"))
                flag = false;
            else
                System.out.println("***** Select from given options(1,2,3,4,5,6,7) only. ****");
        }
        return input;
    }

    public void startProgram()
    {
        boolean start = true;
        while (start)
        {
            String StringInput = menuSelect();
            start = userSelection(StringInput);
        }
    }

    /**
     * Method to check if the user has selected a specific option from the menu
     *
     * @return A boolean
     */
    public boolean userSelection(String userInput)
    {
        switch (userInput)
        {
            case "1":
                login();
                return true;
            case "2":
                if (administrator.getAdminName().trim().length() == 0)
                {
                    System.out.println("You need to login first. \n"
                            +"Please press [Enter] to return to the main menu.");
                    new Scanner(System.in).nextLine();
                    return true;
                }
                else
                    selectSpaceShuttle();
                return true;
            case "3":
                if (administrator.getAdminName().trim().length() == 0)
                {
                    System.out.println("You need to login first. \n"
                            +"Please press [Enter] to return to the main menu.");
                    new Scanner(System.in).nextLine();
                    return true;
                }
                else
                {
                    createMission();
                    return true;
                }
            case "4":
                if (administrator.getAdminName().trim().length() == 0)
                {
                    System.out.println("You need to login first. \n"
                            +"Please press [Enter] to return to the main menu.");
                    new Scanner(System.in).nextLine();
                    return true;
                }
                else
                {
                    getEditInput();
                    return true;
                }
            case "5":
                if (administrator.getAdminName().trim().length() == 0)
                {
                    System.out.println("You need to login first. \n"
                            +"Please press [Enter] to return to the main menu.");
                    new Scanner(System.in).nextLine();
                    return true;
                }
                else
                {
                    Mission mission = inputMissionId();
                    mission.Criteria();
                    return true;
                }
            case "6":
                if (administrator.getAdminName().trim().length() == 0)
                {
                    System.out.println("You need to login first. \n"
                            +"Please press [Enter] to return to the main menu.");
                    new Scanner(System.in).nextLine();
                    return true;
                }
                else
                {
                    selectCandidates();
                    return true;
                }
            case "7":
                System.out.println("Thank you for using!");
                return false;
        }
        return true;
    }

    /**
     *Method to login
     */
    public void login()
    {
        Validate va = new Validate();
        boolean flag = true;
        do
        {
            String userName = va.acceptStringInput("Please input your user name: ");
            if (va.stringLengthWithinRange(userName, 3, 10))
                System.out.println("user name must between 3 and 10 characters");
            else
            {
                administrator.setAdminName(userName);
                flag = false;
            }
        } while (flag);
        flag = true;
        do
        {
            String password = va.acceptStringInput("Please input your password: ");
            if (!password.equals("0000"))
                System.out.println("Wrong password");
            else
            {
                System.out.println("Welcome to Mission to Mars");
                flag = false;
            }
        } while (flag);
    }

    public int ageCalculator(LocalDate dob){

            int age = Period.between(dob, LocalDate.now()).getYears();
            return age;
    }

    /**
     * Method to find and return the mission selected by user
     */
    public Mission inputMissionId(){
        Validate va = new Validate();
        String id = va.acceptStringInput("Input Mission ID: ");
        while(true) {
            for (Mission value : missions) {
                if (value.getMissionId().equals(id)) {
                    return value;
                }
            }
            System.out.println("Mission does not exist. ");
            id = va.acceptStringInput("Input Mission ID: ");
        }
    }

    /**
     *Method to select candidates
     */
    public void selectCandidates(){
        Validate va = new Validate();
        Mission mission = inputMissionId();
        try {
            mission.getSelectionCriteria().getMinimumAge();
        } catch(Exception e) {
            System.out.println("Select criteria for the mission first");
            Control control = new Control();
            control.startProgram();
        }
        int noCandidates = va.acceptIntegerInput("Please enter the number of candidates you wish to add to the mission");
        //add all candidates to the list that have at least one criteria
        ArrayList<Candidate> possibleCandidates = candidates;
        //remove candidates that do not have all criteria
        try {
            if (Integer.toString(mission.getSelectionCriteria().getMinimumAge()) != null)
            {
                for (int i = 0; i < possibleCandidates.size(); i++)
                {
                    int age = ageCalculator(LocalDate.parse(possibleCandidates.get(i).getCandidateDOB(), DateTimeFormatter.ofPattern("MM/dd/yyyy")));

                    if (age < mission.getSelectionCriteria().getMinimumAge())
                    {
                        possibleCandidates.remove(possibleCandidates.get(i));

                    }
                }
            }
            if (Integer.toString(mission.getSelectionCriteria().getMaximumAge()) != null)
            {
                for (int i = 0; i < possibleCandidates.size(); i++)
                {
                    int age = ageCalculator(LocalDate.parse(possibleCandidates.get(i).getCandidateDOB(), DateTimeFormatter.ofPattern("MM/dd/yyyy")));

                    if (age > mission.getSelectionCriteria().getMaximumAge())
                    {
                        possibleCandidates.remove(possibleCandidates.get(i));

                    }
                }
            }
        }catch(Exception e){
            System.out.println("Please select the age criteria first");
        }

        try {
            if (Integer.toString(mission.getSelectionCriteria().getWorkExperience()) != null)
            {
                for (int i = 0; i < possibleCandidates.size(); i++)
                {
                    int exp = 0;
                    if(possibleCandidates.get(i).getWork() != null)
                    {
                        for (int j = 0; j < possibleCandidates.get(i).getWork().size(); j++)
                        {
                            if (exp < Integer.parseInt(possibleCandidates.get(i).getWork().get(j)[1].trim()))
                            {
                                exp = Integer.parseInt(possibleCandidates.get(i).getWork().get(j)[1].trim());
                            }

                        }
                        if (exp < mission.getSelectionCriteria().getWorkExperience())
                        {
                            possibleCandidates.remove(possibleCandidates.get(i));
                        }
                    }
                }
            }
        }catch(Exception e){
                System.out.println("Please select the work criteria first");
            }

        try
        {
            if (mission.getSelectionCriteria().getHealthRecord() != null)
            {
                for (int i = 0; i < possibleCandidates.size(); i++)
                {

                    if (mission.getSelectionCriteria().getHealthRecord().contains(possibleCandidates.get(i).getAllergies()))
                    {
                        possibleCandidates.remove(possibleCandidates.get(i));
                    }
                }
            }
        } catch (Exception e){
            e.fillInStackTrace();
        }

        //display all Candidates
        //****** need try catch here *****
        int arg = noCandidates;
        if (possibleCandidates.size() < noCandidates){
            arg = possibleCandidates.size();
        }
        ArrayList<Candidate> shortlistCandidates = new ArrayList<Candidate>(possibleCandidates.subList(0, arg));
        for (int i = 0; i < shortlistCandidates.size(); i++){
            System.out.println( i+1 + " " + shortlistCandidates.get(i).getCandidateName());
        }
        mission.setListOfCandidates(shortlistCandidates);
    }
}





