package com.xebia.xebia_tondeuse;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PositionTest {

    private Position position=null;
    private Pelouse pelouse=null;

    @Before
    public void setUp(){
        position=new Position();
        position.setX(1);
        position.setY(1);
        position.setOrientation("N");
        pelouse=new Pelouse(5,5);
    }

    @Test
    public void shouldReturnTheRightOrientation(){
        assertEquals("E",position.changeOrientation("D"));
        assertEquals("S",position.changeOrientation("D"));
        assertEquals("W",position.changeOrientation("D"));
        assertEquals("N",position.changeOrientation("D"));
        assertEquals("W",position.changeOrientation("G"));
        assertEquals("S",position.changeOrientation("G"));
        assertEquals("E",position.changeOrientation("G"));
        assertEquals("N",position.changeOrientation("G"));
    }

    @Test
    public void shouldAdvanceInTheRightDirection(){


        position.avanceVersDirection(pelouse);
        //la position en Y de y+1 change
        assertEquals(1,position.getX());
        assertEquals(2,position.getY());

        position.changeOrientation("D");
        position.avanceVersDirection(pelouse);
        //la position en X de X+1 change
        assertEquals(2,position.getX());
        assertEquals(2,position.getY());

        position.changeOrientation("D");
        position.avanceVersDirection(pelouse);
        //la position en Y de y-1 change
        assertEquals(2,position.getX());
        assertEquals(1,position.getY());

        position.changeOrientation("D");
        position.avanceVersDirection(pelouse);
        //la position en X de X-1 change
        assertEquals(1,position.getX());
        assertEquals(1,position.getY());
    }
}
