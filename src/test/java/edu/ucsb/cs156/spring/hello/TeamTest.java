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

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }
    @Test
    public void toString_returns_correct_string_with_mem() {
        Team team1 = new Team("test-team11");
        team1.addMember("mem1");
        assertEquals("Team(name=test-team11, members=[mem1])", team1.toString());
    }

//for equal()   
    @Test
    public void equal_case1() {
        Team team = new Team("test-team");    
        assertEquals(true, team.equals(team));
    }
    @Test
    public void equal_case2() {
        Team team = new Team("test-team");
        assertEquals(false, team.equals("team"));    
    }
    @Test
    public void equal_case3_TT() {
        Team team1 = new Team("test-team");   
        team1.addMember("mem1");
        Team team2 = new Team("test-team");   
        team2.addMember("mem1");
        assertEquals(true, team1.equals(team2));
    }
    @Test
    public void equal_case3_TF() {
        Team team1 = new Team("test-team");   
        team1.addMember("mem1");
        Team team2 = new Team("test-team");   
        team2.addMember("mem2");
        assertEquals(false, team1.equals(team2));
    }
    @Test
    public void equal_case3_FT() {
        Team team1 = new Team("test-team11");   
        team1.addMember("mem1");
        Team team2 = new Team("test-team");   
        team2.addMember("mem1");
        assertEquals(false, team1.equals(team2));
    }
    @Test
    public void equal_case3_FF() {
        Team team1 = new Team("test-team11");   
        team1.addMember("mem1");
        Team team2 = new Team("test-team");   
        team2.addMember("mem2");
        assertEquals(false, team1.equals(team2));
    }

//test hash
    @Test
    public void test_hash_provided() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());
    }
    @Test
    public void test_hash_zero() {
        Team t = new Team();
        int result = t.hashCode();
        int expectedResult = 1;
        assertEquals(expectedResult, result);
    }
   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
