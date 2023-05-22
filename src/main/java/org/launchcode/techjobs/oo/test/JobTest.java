package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.CoreCompetency;
import org.launchcode.techjobs.oo.Employer;
import org.launchcode.techjobs.oo.Job;
import org.launchcode.techjobs.oo.PositionType;

import org.launchcode.techjobs.oo.Location;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());
    }


    @Test
    public void testJobConstructorSetsAllFields() {
        Job test_all_Jobs = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals(test_all_Jobs.getName(), "Product tester");
        assertEquals(test_all_Jobs.getEmployer().getValue(), "ACME");
        assertEquals(test_all_Jobs.getLocation().getValue(), "Desert");
        assertEquals(test_all_Jobs.getPositionType().getValue(), "Quality control");
        assertEquals(test_all_Jobs.getCoreCompetency().getValue(), "Persistence");

        assertTrue(test_all_Jobs.getName() instanceof String);
        assertTrue(test_all_Jobs.getEmployer() instanceof Employer);
        assertTrue(test_all_Jobs.getLocation() instanceof Location);
        assertTrue(test_all_Jobs.getPositionType() instanceof PositionType);
        assertTrue(test_all_Jobs.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(job2.equals(job3));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() { //test that returns string that contains blank line before and after jog info
        Job testJob1 = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals('\n', testJob1.toString().charAt(0));
        assertEquals('\n', testJob1.toString().charAt(testJob1.toString().length() - 1));
    }
@Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job testJob2 = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("\nID: " + testJob2.getId() + "\nName: Product Tester\nEmployer: ACME\nLocation: Desert\nPosition Type: Quality control\nCore Competency: Persistence\n", testJob2.toString());
    }
@Test
    public void testToStringHandlesEmptyField() {
        Job testJob3 = new Job("Product Tester", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency(""));
    }
}