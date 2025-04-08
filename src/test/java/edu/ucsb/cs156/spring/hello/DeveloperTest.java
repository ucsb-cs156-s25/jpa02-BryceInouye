package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        // TODO: Replace Chris G. with your name as shown on
        // <https://bit.ly/cs156-s25-teams>
        assertEquals("Bryce I", Developer.getName());
    }

    @Test
    public void getGithubId_returns_correct_id() {
        assertEquals("BryceInouye", Developer.getGithubId());
    }

    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)
    @Test
    public void getTeam_returns_team_with_correct_name() {
        Team  t = Developer.getTeam();
        assertEquals("s25-15", t.getName());
    }

    @Test
    public void getTeam_returns_team_with_correct_members() {
        Team  t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Lucas H"),"Team should contain Lucas H");
        assertTrue(t.getMembers().contains("Perry T"),"Team should contain Perry T");
        assertTrue(t.getMembers().contains("Bryce I"),"Team should contain Bryce I");
        assertTrue(t.getMembers().contains("Tyler W"),"Team should contain Tyler W");
        assertTrue(t.getMembers().contains("Yue C"),"Team should contain Yue C");
        assertTrue(t.getMembers().contains("David D"),"Team should contain David D");
    }



}
