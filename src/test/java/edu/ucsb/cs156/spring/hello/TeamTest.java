package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)
    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_returns_correct_values() {
        assert(team.equals(team) == true);

        int team1 = 15;
        assert(team.equals(team1) == false);

        Team team2;
        team2 = new Team("test-team");
        assert(team.equals(team2) == true);

        Team team3;
        team.addMember("Timothy");
        team3 = new Team("test-team");
        team3.addMember("Alice");
        team3.addMember("Bob");
        assert(team.equals(team3) == false);
    }
    @Test
    public void equals_name_diff_members_same() {
        Team t1 = new Team();
        t1.setName("team-a");
        t1.addMember("Alice");

        Team t2 = new Team();
        t2.setName("team-b"); // different name
        t2.addMember("Alice"); // same members

        assert(!t1.equals(t2));
    }
    @Test
    public void equals_name_same_members_diff() {
        Team t1 = new Team();
        t1.setName("team-a");
        t1.addMember("Alice");

        Team t2 = new Team();
        t2.setName("team-a"); // same name
        t2.addMember("Bob"); // different member

        assert(!t1.equals(t2));
    }



    @Test
    public void hashCode_returns_correct_values() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());
    }

    @Test
    public void another_hashCode_test() {
        // instantiate t as a Team object
        Team t = new Team();
        t.setName("team-t");
        t.addMember("Person T");
        int result = t.hashCode();
        int expectedResult = -537942132 ;
        assertEquals(expectedResult, result);
    }

}
