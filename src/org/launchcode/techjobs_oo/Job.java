package org.launchcode.techjobs_oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.
    public Job() {
        this.id = nextId;
        nextId++;
    }

    public Job(String aName, Employer aEmployer, Location aLocation, PositionType aPositionType, CoreCompetency aCoreCompetency) {
        this();
        this.name = aName;
        this.employer = aEmployer;
        this.location = aLocation;
        this.positionType = aPositionType;
        this.coreCompetency = aCoreCompetency;
    }

    // Custom toString method

    @Override
    public String toString() {

        if ((this.name == null) && (this.employer == null) && (this.location == null) && (this.positionType == null) && (this.coreCompetency == null)) {
            return "OOPS ! This job does not seem to exist";
        }

//        String nameToString = this.getName().equals("") ? "Data not available": this.getName();
        String nameToString = this.getName();
        if(nameToString.equals("")){
            nameToString = "Data not available";
        }
        String employerToString = this.getEmployer().getValue();
        if(employerToString.equals("")) {
            employerToString = "Data not available";
        }
        String locationToString = this.getLocation().getValue();
        if(locationToString.equals("")){
            locationToString = "Data not available";
        }
        String positionTypeToString = this.positionType.getValue();
        if(positionTypeToString.equals("")){
            positionTypeToString = "Data not available";
        }
        String coreCompetencyToString = this.coreCompetency.getValue();
        if(coreCompetencyToString.equals("")){
            coreCompetencyToString = "Data not available";
        }

        return "\n" +
                "ID: " + id + "\n" +
                "Name: " + nameToString + "\n" +
                "Employer: " + employerToString + "\n" +
                "Location: " + locationToString + "\n" +
               "Position Type: " + positionTypeToString + "\n" +
               "Core Competency: " + coreCompetencyToString +
              "\n";

//        if (this.employer.getValue().equals("")) {
//            this.employer.setValue("Data not available");
//        } else {
//
//        }
//        if (this.location.getValue().equals("")) {
//            this.location.setValue("Data not available");
//        }
//        if (this.positionType.getValue().equals("")) {
//            this.positionType.setValue("Data not available");
//        }
//        if (this.coreCompetency.getValue().equals("")) {
//            this.coreCompetency.setValue("Data not available");
//        }

//        return "\n" +
//                "ID: " + id + "\n" +
//                "Name: " + name + "\n" +
//                "Employer: " + employer + "\n" +
//                "Location: " + location + "\n" +
//                "Position Type: " + positionType + "\n" +
//                "Core Competency: " + coreCompetency +
//                "\n";
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id &&
                Objects.equals(name, job.name) &&
                Objects.equals(employer, job.employer) &&
                Objects.equals(location, job.location) &&
                Objects.equals(positionType, job.positionType) &&
                Objects.equals(coreCompetency, job.coreCompetency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, employer, location, positionType, coreCompetency);
    }

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public Location getLocation() {
        return location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
}
