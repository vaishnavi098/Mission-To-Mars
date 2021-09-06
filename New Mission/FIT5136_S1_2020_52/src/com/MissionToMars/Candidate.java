package com.MissionToMars;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Candidate Class
 *
 * @author Fenghao Qi
 * @version 12 May 2020
 */
public class Candidate
{
    private String candidateId;
    private String candidateName;
    private String candidateDOB;
    private String address;
    private String nationality;
    private String phoneNumber;
    private String identificationType;
    private String gender;
    private ArrayList<String> allergies;
    private ArrayList<String> foodPreference;
    private String compSkills;
    private ArrayList<String> qualificationList;
    private ArrayList<String[]> work;
    private ArrayList<String> languages;
    private ArrayList<String> missionsInterestedIn;
    private ArrayList<String> missionOffers;

    /**
     * Constructor for objects of class Candidate
     */
    public Candidate()
    {
        candidateId = "";
        candidateName = "";
        candidateDOB = "";
        address = "";
        nationality = "";
        phoneNumber = "";
        gender = "";
        allergies = new ArrayList<String>();
        foodPreference = new ArrayList<String>();
        qualificationList = new ArrayList<>();
        work = new ArrayList<String[]>();
        compSkills = "";
        languages = new ArrayList<String>();
    }

    /**
     * Non-Default constructor for objects of class University
     */
    public Candidate(String candidateId, String candidateName, String candidateDOB, String address, String nationality, String phoneNumber, String identificationType, String gender, ArrayList<String> allergies, ArrayList<String> foodPreference, ArrayList<String> qualificationList, ArrayList<String[]> work, String compSkills, ArrayList<String> languageList, ArrayList<String> missionsInterestedIn, ArrayList<String> missionOffers)
    {
        this.candidateId = candidateId;
        this.candidateName = candidateName;
        this.candidateDOB = candidateDOB;
        this.address = address;
        this.nationality = nationality;
        this.phoneNumber = phoneNumber;
        this.identificationType = identificationType;
        this.gender = gender;
        this.allergies = allergies;
        this.foodPreference = foodPreference;
        this.qualificationList = qualificationList;
        this.work = work;
        this.compSkills = compSkills;
        this.languages = languageList;
        this.missionOffers = missionOffers;
        this.missionsInterestedIn = missionsInterestedIn;
    }

    public String getCandidateId()
    {
        return candidateId;
    }

    public void setCandidateId(String candidateId)
    {
        this.candidateId = candidateId;
    }

    public String getCandidateName()
    {
        return candidateName;
    }

    public void setCandidateName(String candidateName)
    {
        this.candidateName = candidateName;
    }

    public String getCandidateDOB()
    {
        return candidateDOB;
    }

    public void setCandidateDOB(String candidateDOB)
    {
        this.candidateDOB = candidateDOB;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getNationality()
    {
        return nationality;
    }

    public void setNationality(String nationality)
    {
        this.nationality = nationality;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public ArrayList<String> getAllergies()
    {
        return allergies;
    }

    public void setAllergies(ArrayList<String> allergies)
    {
        this.allergies = allergies;
    }

    public ArrayList<String> getFoodPreference()
    {
        return foodPreference;
    }

    public String getCompSkills()
    {
        return compSkills;
    }

    public void setCompSkills(String compSkills)
    {
        this.compSkills = compSkills;
    }

    public ArrayList<String> getQualificationList()
    {
        return qualificationList;
    }

    public void setQualificationList(ArrayList<String> qualificationList)
    {
        this.qualificationList = qualificationList;
    }

    public ArrayList<String> getLanguages() {
        return languages;
    }

    public void setLanguages(ArrayList<String> languages) {
        this.languages = languages;
    }

    public ArrayList<String> getMissionOffers() {
        return missionOffers;
    }

    public void setMissionOffers(ArrayList<String> missionOffers) {
        this.missionOffers = missionOffers;
    }

    public ArrayList<String> getMissionsInterestedIn() {
        return missionsInterestedIn;
    }

    public void setMissionsInterestedIn(ArrayList<String> missionsInterestedIn) {
        this.missionsInterestedIn = missionsInterestedIn;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setFoodPreference(ArrayList<String> foodPreference) {
        this.foodPreference = foodPreference;
    }

    public ArrayList<String[]> getWork() {
        return work;
    }

    public void setWork(ArrayList<String[]> work) {
        this.work = work;
    }

    public String getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(String identificationType) {
        this.identificationType = identificationType;
    }
}
