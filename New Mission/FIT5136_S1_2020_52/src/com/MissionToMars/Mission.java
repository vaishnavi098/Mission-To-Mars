package com.MissionToMars;

import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Mission {
    private String missionId;
    private String missionName;
    private String launchDate;
    private String origin;
    private ArrayList<String> countriesAllowed;
    private Integer missionDuration;
    private String missionType;
    private String missionDesc;
    private ArrayList<Stock> journeyCargo;
    private ArrayList<Stock> missionCargo;
    private ArrayList<Stock> otherMissionCargo;
    private String destLocation;
    private String missionStatus;
    private ArrayList<String[]> jobs;
    private ArrayList<String[]> employmentRequirements;
    private SelectionCriteria selectionCriteria;
    private SpaceShuttle spaceShuttle;
    private ArrayList<Candidate> candidates;
    private MissionCoordinator coordinator;
    private FileIO reader;

    /**
     * Constructor of class Mission
     */
    public Mission() {

        missionId = "";
        missionName = "";
        launchDate = "01-01-2020";
        origin = "";
        countriesAllowed = new ArrayList<>();
        missionDuration = 0;
        missionType = "String";
        missionDesc = "";
        journeyCargo = new ArrayList<Stock>();
        missionCargo = new ArrayList<Stock>();
        otherMissionCargo = new ArrayList<Stock>();
        destLocation = "";
        missionStatus = "";
        jobs = new ArrayList<String[]>();
        employmentRequirements = new ArrayList<String[]>();
        selectionCriteria = new SelectionCriteria();
        spaceShuttle = new SpaceShuttle();
        candidates = new ArrayList<Candidate>();
        coordinator = new MissionCoordinator();
    }

    /**
     * Non-Default Constructor of class Mission
     */
    public Mission(String newMissionId, String newMissionName, String newLaunchDate, String newOrigin,
                   ArrayList<String> newCountriesAllowed, Integer newMissionDuration, String newMissionType,
                   String newMissionDescription, ArrayList<Stock> newJourneyCargo, ArrayList<Stock> newMissionCargo,
                   ArrayList<Stock> newOtherMissionCargo, String newDestLocation, String newMissionStatus,
                   ArrayList<String[]> newJobs, ArrayList<String[]> newEmploymentrequirements,
                   SelectionCriteria newSelectionCriteria, SpaceShuttle newSpaceShuttle,
                   ArrayList<Candidate> newCandidates, MissionCoordinator newCoordinator) {
        missionId = newMissionId;
        missionName = newMissionName;
        launchDate = newLaunchDate;
        origin = newOrigin;
        countriesAllowed = newCountriesAllowed;
        missionDuration = newMissionDuration;
        missionType = newMissionType;
        missionDesc = newMissionDescription;
        journeyCargo = newJourneyCargo;
        missionCargo = newMissionCargo;
        otherMissionCargo = newOtherMissionCargo;
        destLocation = newDestLocation;
        missionStatus = newMissionStatus;
        jobs = newJobs;
        employmentRequirements = newEmploymentrequirements;
        selectionCriteria = newSelectionCriteria;
        spaceShuttle = newSpaceShuttle;
        candidates = newCandidates;
        coordinator = newCoordinator;

    }

    public void setMissionId(String newMissionId) {
        missionId = newMissionId;
    }

    public String getMissionId() {
        return missionId;
    }

    public void setMissionName(String newMissionName) {
        missionName = newMissionName;
    }

    public String getMissionName() {
        return missionName;
    }

    public void setMissionDesc(String newMissionDesc) {
        missionDesc = newMissionDesc;
    }

    public String getMissionDesc() {
        return missionDesc;
    }

    public void setCountriesAllowed(ArrayList<String> newCountriesAllowed) {
        this.countriesAllowed = newCountriesAllowed;
    }

    public String getMissionType() {
        return missionType;
    }

    public void setMissionType(String missionType) {
        this.missionType = missionType;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public ArrayList<String> getCountriesAllowed() {
        return countriesAllowed;
    }

    //get specific index
    public String getSpecificCountriesAllowed(int index) {
        return countriesAllowed.get(index);
    }


    public ArrayList<Stock> getJourneyCargo() {
        return journeyCargo;
    }

    public void setJourneyCargo(ArrayList<Stock> journeyCargo) {
        this.journeyCargo = journeyCargo;
    }

    public ArrayList<Stock> getMissionCargo() {
        return missionCargo;
    }

    public void setMissionCargo(ArrayList<Stock> missionCargo) {
        this.missionCargo = missionCargo;
    }

    public ArrayList<Stock> getOtherMissionCargo() {
        return otherMissionCargo;
    }

    public void setOtherMissionCargo(ArrayList<Stock> otherMissionCargo) {
        this.otherMissionCargo = otherMissionCargo;
    }

    public ArrayList<String[]> getEmploymentRequirements() {
        return employmentRequirements;
    }

    public void setEmploymentRequirements(ArrayList<String[]> employmentRequirements) {
        this.employmentRequirements = employmentRequirements;
    }

    public ArrayList<String[]> getJobs() {
        return jobs;
    }

    public void setJobs(ArrayList<String[]> jobs) {
        this.jobs = jobs;
    }

    public MissionCoordinator getCoordinator() {
        return coordinator;
    }

    public void setCoordinator(MissionCoordinator coordinator) {
        this.coordinator = coordinator;
    }

    public void setLaunchDate(String newLaunchDate) {
        launchDate = newLaunchDate;
    }

    public String getLaunchDate() {
        return launchDate;
    }

    public void setDestLocation(String newDestLocation) {
        destLocation = newDestLocation;
    }

    public String getDestLocation() {
        return destLocation;
    }

    public void setMissionDuration(Integer newMissionDuration) {
        missionDuration = newMissionDuration;
    }

    public Integer getMissionDuration() {
        return missionDuration;
    }

    public void setMissionStatus(String newMissionStatus) {
        missionStatus = newMissionStatus;
    }

    public String getMissionStatus() {
        return missionStatus;
    }

    public void setSelectionCriteria(SelectionCriteria newSelectionCriteria) {
        selectionCriteria = newSelectionCriteria;
    }

    public SelectionCriteria getSelectionCriteria() {
        return selectionCriteria;
    }

    public void setSpaceShuttle(SpaceShuttle newSpaceShuttle) {
        spaceShuttle = newSpaceShuttle;
    }

    public SpaceShuttle getSpaceShuttle() {
        return spaceShuttle;
    }

    public void setListOfCandidates(ArrayList<Candidate> newListOfCandidates) {
        this.candidates = newListOfCandidates;
    }

    public ArrayList<Candidate> getListOfCandidates() {
        return candidates;
    }

    //get specific index
    public Candidate getSpecificCandidate(int index) {
        return candidates.get(index);
    }

    /**
     * Method to select and edit criteria
     */
    public void Criteria() {
        //Mission mission = new Mission();

        String age = "Age range";
        String qual = "Qualifications";
        String work = "Years of work experience";
        String occ = "Occupations";
        String health = "Health records";
        String criminal = "Criminal records";
        String skills = "Computer skills";
        String lang = "Languages spoken";
        Scanner console = new Scanner(System.in);
        Validate va = new Validate();
        boolean choice1 = FALSE,choice2 = FALSE;
        ArrayList<String> display = new ArrayList<>();
        ArrayList<String> selected = new ArrayList<>();
        System.out.println("\n Select criteria that you want for selecting the candidates: ");
        System.out.println("=======================================================");
        display.add(age);
        display.add(qual);
        display.add(work);
        display.add(occ);
        display.add(health);
        display.add(criminal);
        display.add(skills);
        display.add(lang);
        displayList(display);
        String Select = "",del = "";
        int opt = 0;
        do {
            opt = va.acceptIntegerInput("Enter Option:");
            del = deleteOption(opt, display);
            selected.add(del);
            displayList(display);
            Select = va.acceptStringInput(" \n Do you want to continue adding to the list? (y/n): ");
            if (Select.trim().equals("y")) choice1 = TRUE;
            else if(Select.trim().equals("n"))
                break;

        } while (display.size() >= 1 && choice1==TRUE) ;
        // display final selected criteria
        System.out.println("\n Criteria list for selecting candidates \n");
        displayList(selected);
        Select = va.acceptStringInput("\n Do you want to make changes to the final Selection Criteria List (y/n)\n ");
        if(Select.trim().equals("y"))
        {
            System.out.println("\n Which edit operation to want to perform on the list: ");

            System.out.println("\n 1. Add Criteria ");
            System.out.println("\n 2. Remove Criteria ");
            opt = va.acceptIntegerInput("Select Option:");

            System.out.println("\n 1. Add criteria ");
            System.out.println("\n 2. Remove criteria ");
            opt = console.nextInt();

            if(opt==1)
            {
                System.out.println("\n Enter option to add from the list: ");
                do {
                    displayList(display);
                    opt = va.acceptIntegerInput("Enter Option:");
                    del=deleteOption(opt, display);
                    selected.add(del);
                    displayList(selected);
                    Select = va.acceptStringInput(" \n Do you want to continue adding to the list? (y/n): ");
                    if (Select.trim().equals("y"))
                        choice1 = TRUE;
                    else if(Select.trim().equals("n"))
                        break;
                } while (display.size() >= 1 && choice1==TRUE && opt <= display.size());
            }
            else if(opt==2)
            {
                System.out.println("\n Enter option to remove from the list: ");
                do{
                    displayList(selected);
                    opt = va.acceptIntegerInput("Enter Option:");
                    del=deleteOption(opt,selected);
                    display.add(del);
                    Select = va.acceptStringInput(" \n Do you want to continue removing from list? (y/n): ");
                    if (Select.trim().equals("y"))
                        choice2 = TRUE;
                    else if(Select.trim().equals("n"))
                        break;
                }while(selected.size() >=1 && choice2 == TRUE && opt <= selected.size());
            }
            else System.out.println("Please enter a valid option");

        }

        System.out.println("\n ________ FINAL SELECTION CRITERIA ________ \n");
        displayList(selected);
        SelectionCriteria criteria = new SelectionCriteria();
        for (int i = 0; i < selected.size(); i++)
        {
            setValues(selected.get(i), criteria);
        }
    }


    /**
     * Method to delete options from the display list
     */


    public String deleteOption(int option, ArrayList<String> display) {
        String delete="";
        for (int i = 0; i <= display.size(); i++) {
            if (option == (i)) {
                delete= display.remove(i - 1);
            }
        }
        return delete;
    }

    /**
     * Method to display the list
     */
    public void displayList(ArrayList<String> display) {
        for (int i = 0; i < display.size(); i++) {
            System.out.println(i + 1 + "." + display.get(i));
        }

    }

    /**
     * Method to access the the Selection Criteria
     */
    public void setValues(String option, SelectionCriteria criteria)
    {
        //SelectionCriteria criteria = new SelectionCriteria();
        switch(option)
        {
            case "Age range" : {
                criteria.askAge();
                setSelectionCriteria(criteria);
            }
            break;
            case "Qualifications" : {
                criteria.askQualifications();
                setSelectionCriteria(criteria);
            }
            break;
            case "Years of work experience" : {
                criteria.askExperience();
                setSelectionCriteria(criteria);
            }
            break;
            case "Occupations" : {
                criteria.askOccupation();
            }
            break;
            case "Health records" : {
                criteria.askHealthRecord();
                setSelectionCriteria(criteria);
            }
            break;
            case "Criminal records" : {
                criteria.askCriminalRecord();
            }
            break;
            case "Computer skills" : {
                criteria.askComputerSkill();
            }
            break;
            case "Languages spoken" : {
                criteria.askLanguageRequired();
            }
            break;
            default: {
                System.out.println("Invalid numbers entered");
            }
            break;

        }
    }
}
