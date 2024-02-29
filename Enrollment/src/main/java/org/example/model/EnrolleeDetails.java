package org.example.model;


public class EnrolleeDetails {
    private String id;
    private String fullName;
    private int version;
    private String company;

    public EnrolleeDetails(String id, String fullName, int version, String company) {
        this.id = id;
        this.fullName = fullName;
        this.version = version;
        this.company = company;
    }
    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getVersion() {
        return version;
    }

    public String getCompany() {
        return company;
    }
    public String toCSVFormat() {
        return id + "," + fullName + "," + version + "," + company;
    }
}
