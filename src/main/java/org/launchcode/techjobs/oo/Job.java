package org.launchcode.techjobs.oo;

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
        id = nextId;
        nextId++;
    }

    public Job(String aName, Employer aEmployer, Location aLocation, PositionType aPositionType, CoreCompetency someCoreCompetency){
        this();
        this.name = aName;
        this.employer = aEmployer;
        this.location = aLocation;
        this.positionType = aPositionType;
        this.coreCompetency = someCoreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job job)) return false;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    @Override
    public String toString(){

        String idValue = getId() == 0 ? "Data not available" : String.valueOf(getId());
        String nameValue = getName().isEmpty() ? "Data not available" : getName();
        String employerValue = getEmployer().getValue().isEmpty() ? "Data not available" : getEmployer().toString();
        String locationValue = getLocation().getValue().isEmpty() ? "Data not available" : getLocation().toString();
        String positionTypeValue = getPositionType().getValue().isEmpty() ? "Data not available" : getPositionType().toString();
        String coreCompetencyValue = getCoreCompetency().getValue().isEmpty() ? "Data not available" : getCoreCompetency().toString();

        return String.format("%sID: %s%sName: %s%sEmployer: %s%sLocation: %s%sPosition Type: %s%sCore Competency: %s%s",
                System.lineSeparator(),
                idValue, System.lineSeparator(),
                nameValue, System.lineSeparator(),
                employerValue, System.lineSeparator(),
                locationValue, System.lineSeparator(),
                positionTypeValue, System.lineSeparator(),
                coreCompetencyValue, System.lineSeparator());
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
}
