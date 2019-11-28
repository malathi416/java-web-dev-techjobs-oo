package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;
public class JobTest {
    Job testJob1;
    Job testJob2;
    Job testJob;
    @Before

    public void creatingTestJobObject(){
     testJob1 = new Job();
     testJob2 = new Job();
    }
    @Test
    public void testSettingJobId(){
        assertTrue(testJob1.getId()!=testJob2.getId());
    }
    @Test
    public void testJobIdDifferBy1(){
        assertEquals(1,testJob2.getId()-testJob1.getId());
    }
    @Test
    public void testJobConstructorSetsAllFields(){
        // testJob = new Job("Product tester","ACME","Desert","Quality control", "Persistence");
        testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(testJob.getEmployer() instanceof Employer);
        assertTrue(testJob.getLocation() instanceof Location);
        assertTrue(testJob.getPositionType() instanceof PositionType);
        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Product tester",testJob.getName());
    }
    @Test
    public void testJobsForEquality(){
        testJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        testJob2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(testJob1.equals(testJob2));
    }
}
