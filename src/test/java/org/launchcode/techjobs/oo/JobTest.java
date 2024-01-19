package org.launchcode.techjobs.oo;
import org.junit.Test;

import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here

    @Test
    public void testSettingJobId(){
        Job job1 = new Job();
        Job job2 = new Job();

    assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
       Job job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(job3 instanceof Job);
        assertEquals("Product tester", job3.getName());
        assertEquals("ACME", job3.getEmployer().getValue());
        assertEquals("Desert", job3.getLocation().getValue());
        assertEquals("Quality control", job3.getPositionType().getValue());
        assertEquals("Persistence", job3.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality(){
        Job job4 = new Job("Fry cook", new Employer("Krusty Krab"), new Location("bikini bottom"), new PositionType("Food control"), new CoreCompetency("secret formula"));
        Job job5 = new Job("Fry cook", new Employer("Krusty Krab"), new Location("bikini bottom"), new PositionType("Food control"), new CoreCompetency("secret formula"));

        assertNotEquals(job4, job5);
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job job6 = new Job("Dish washer", new Employer("krusty krab"), new Location("Rock bottom"), new PositionType("Spongebob"), new CoreCompetency("assassination"));

        String jobString1 = job6.toString();

        assertTrue(jobString1.startsWith(System.lineSeparator()));
        assertTrue(jobString1.endsWith(System.lineSeparator()));
    }


    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job7 = new Job("entertainer", new Employer("Larry flin"), new Location("Asgard"), new PositionType("All Spotter"), new CoreCompetency("Leg extensions"));

        String jobString2 = job7.toString();

        assertTrue(jobString2.contains("ID: " + job7.getId()));
        assertTrue(jobString2.contains("Employer: " + job7.getEmployer()));
        assertTrue(jobString2.contains("Location: " + job7.getLocation()));
        assertTrue(jobString2.contains("Position Type: " + job7.getPositionType()));
        assertTrue(jobString2.contains("Core Competency: " + job7.getCoreCompetency()));

    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job = new Job("", new Employer(""),
                new Location(""), new PositionType(""),
                new CoreCompetency(""));

        String jobString = job.toString();

        assertTrue(jobString.contains("Name: Data not available"));
        assertTrue(jobString.contains("Employer: Data not available"));
        assertTrue(jobString.contains("Location: Data not available"));
        assertTrue(jobString.contains("Position Type: Data not available"));
        assertTrue(jobString.contains("Core Competency: Data not available"));
    }
}
