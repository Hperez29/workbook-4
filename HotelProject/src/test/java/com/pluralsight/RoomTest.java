package com.pluralsight;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RoomTest {
    private Room room;

    @BeforeEach
    void setUp() {
        room = new Room(2, 150.0, false, false);
    }

    @Test
    void testCheckInMakesRoomOccupiedAndDirty() {
        room.checkIn();
        assertTrue(room.isOccupied());
        assertTrue(room.isDirty());
    }

    @Test
    void testCheckInFailsWhenOccupiedOrDirty() {
        room.checkIn(); // Room is now occupied and dirty
        room.checkIn(); // Attempt to check in again
        assertTrue(room.isOccupied());
        assertTrue(room.isDirty());
    }

    @Test
    void testCheckOutSetsOccupiedFalseButLeavesDirtyTrue() {
        room.checkIn();
        room.checkOut();
        assertFalse(room.isOccupied());
        assertTrue(room.isDirty());
    }

    @Test
    void testCleanRoomSetsDirtyToFalse() {
        room.checkIn();
        room.checkOut();
        room.cleanRoom();
        assertFalse(room.isDirty());
    }

    @Test
    void testCannotCleanAlreadyCleanRoom() {
        room.cleanRoom(); // Room is already clean
        assertFalse(room.isDirty());
    }
}