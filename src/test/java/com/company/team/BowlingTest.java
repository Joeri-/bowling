package com.company.team;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BowlingTest {

    @Test
    void simpleGame() {
        assertEquals(65, Bowling.scoreGame("12 45 24 81 52 40 50 63 33 61"));
    }

    @Test
    void gameWithSpares() {
        assertEquals(86, Bowling.scoreGame("12 45 24 8/ 52 40 5/ 6/ 33 61"));
    }

    @Test
    void gameWithStrikesAndSpares() {
        assertEquals(107, Bowling.scoreGame("12 45 X X 52 40 5/ 6/ 33 61"));
    }

    @Test
    void elaborateEndGame() {
        assertEquals(78, Bowling.scoreGame("12 34 32 34 54 32 34 53 34 X9/"));
    }

    @Test
    void anotherElaborateEndGame() {
        assertEquals(78, Bowling.scoreGame("12 34 32 34 54 32 34 53 34 9/X"));
    }

    @Test
    void stressTest() {
        assertEquals(184, Bowling.scoreGame("4/ 54 7/ X X 4/ 90 9/ X X8/"));
    }

    @Test
    void perfectGame() {
        assertEquals(300, Bowling.scoreGame("X X X X X X X X X XXX"));
    }
}