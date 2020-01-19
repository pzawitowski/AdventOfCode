package com.advent.dayThree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestWire {
    @Test
    public void testWireCreationFromString() {
        String wireText = "R8,U5,L5,D3";
        Wire wire = new Wire(wireText);

        assertEquals(0, wire.getSegments().get(0).getFirstPoint().getX());
        assertEquals(0, wire.getSegments().get(0).getFirstPoint().getY());
        assertEquals(8, wire.getSegments().get(0).getSecondPoint().getX());
        assertEquals(0, wire.getSegments().get(0).getSecondPoint().getY());

        assertEquals(8, wire.getSegments().get(1).getFirstPoint().getX());
        assertEquals(0, wire.getSegments().get(1).getFirstPoint().getY());
        assertEquals(8, wire.getSegments().get(1).getSecondPoint().getX());
        assertEquals(5, wire.getSegments().get(1).getSecondPoint().getY());

        assertEquals(8, wire.getSegments().get(2).getFirstPoint().getX());
        assertEquals(5, wire.getSegments().get(2).getFirstPoint().getY());
        assertEquals(3, wire.getSegments().get(2).getSecondPoint().getX());
        assertEquals(5, wire.getSegments().get(2).getSecondPoint().getY());

        assertEquals(3, wire.getSegments().get(3).getFirstPoint().getX());
        assertEquals(5, wire.getSegments().get(3).getFirstPoint().getY());
        assertEquals(3, wire.getSegments().get(3).getSecondPoint().getX());
        assertEquals(2, wire.getSegments().get(3).getSecondPoint().getY());

//        assertEquals(8, wire.getPath().get(13).getX());
//        assertEquals(5, wire.getPath().get(13).getY());
//
//        assertEquals(3, wire.getPath().get(18).getX());
//        assertEquals(5, wire.getPath().get(18).getY());
//
//        assertEquals(3, wire.getPath().get(21).getX());
//        assertEquals(2, wire.getPath().get(21).getY());
    }
}
