package com.MissionToMars;

public class Administrator {

    private String adminName;
    private String adminId;

    /**
     * Constructor for objects of class Administrator
     */
    public Administrator(){
        adminName = "";
        adminId = "";
    }

    /**
     * Non-Default Constructor for objects of class Administrator
     */
    public Administrator(String name, String id){
        adminName = name;
        adminId = id;
    }

    public String getAdminName() {
        return adminName;
    }

    public String getAdminId(){
        return adminId;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }
}
