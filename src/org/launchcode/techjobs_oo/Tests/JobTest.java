package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {

   private static Job testJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
   private static Job testJob2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
   private static Job testJob4 = new Job();



    @Test
    public void testSettingJobId() {
        assertTrue(testJob1.getId() != testJob2.getId());
    }

    @Test
    public void testJobIdDifferBy1() {
        assertEquals(1, testJob2.getId() - testJob1.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertTrue(testJob1.getEmployer() instanceof Employer);
        assertTrue(testJob1.getLocation() instanceof Location);
        assertTrue(testJob1.getPositionType() instanceof PositionType);
        assertTrue(testJob1.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Product tester", testJob1.getName());
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(testJob1.equals(testJob2));
    }

    @Test
    public void firstTestToString() {
        assertTrue(testJob1.toString().startsWith("\n"));
        assertTrue(testJob1.toString().endsWith("\n"));
    }

    @Test // TODO: How to check new line before each label. Need to write test case.
    public void secondTestToString() {
        String actualToString = testJob1.toString();
        String expectedToString = "\n" +
                "ID: 1\n" +
                "Name: " + "Product tester" + '\n' +
                "Employer: " + "ACME" + "\n" +
                "Location: " + "Desert"+ "\n" +
                "Position Type: " + "Quality control" + "\n" +
                "Core Competency: " + "Persistence" +
                "\n";
        assertEquals(expectedToString, actualToString);
    }

    @Test
    public void testJobWithNoEmployer() {
        Job jobNoEmployer = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String jobToString = jobNoEmployer.toString();
        assertTrue(jobToString.contains("Employer: "));
        String expectedString = "Employer: Data not available";
        assertTrue(jobToString.startsWith(expectedString, jobToString.indexOf("Employer: ")));
    }

    @Test
    public void testJobAllFieldsNullValues() {
        assertEquals("OOPS ! This job does not seem to exist", testJob4.toString());
    }

}