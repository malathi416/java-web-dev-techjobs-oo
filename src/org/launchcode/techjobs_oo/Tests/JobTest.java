package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {

    Job testJob1;
    Job testJob2;
    Job testJob4;


    @Before
    public void creatingTestJobObject() {
        testJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        testJob2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        testJob4 = new Job();
    }

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
                "ID: " + testJob1.getId() + "\n" +
                "Name: " + testJob1.getName() + '\n' +
                "Employer: " + testJob1.getEmployer() + "\n" +
                "Location: " + testJob1.getLocation() + "\n" +
                "Position Type: " + testJob1.getPositionType() + "\n" +
                "Core Competency: " + testJob1.getCoreCompetency() +
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
        assertEquals("", jobNoEmployer.getEmployer().getValue());
    }

    @Test
    public void fourthTestToString() {
        assertEquals("OOPS ! This job does not seem to exist", testJob4.toString());
    }

}