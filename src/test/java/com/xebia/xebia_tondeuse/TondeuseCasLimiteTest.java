package com.xebia.xebia_tondeuse;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class TondeuseCasLimiteTest {

    private String fileName="src/test/resources/programmeTondeuseCasLimite.dat";
    private TondeuseProgrammeur tondeuseProgrammeur=null;
    List<Tondeuse> listTondeuse=null;

    @Before
    public void setUp(){
        tondeuseProgrammeur= new TondeuseProgrammeur();
        listTondeuse=tondeuseProgrammeur.programme(fileName);
        listTondeuse.forEach(tondeuse->tondeuse.tondre(tondeuseProgrammeur.getPelouse()));
    }

    @Test
    public void shouldTurnWithoutMoving(){
        //la Tondeuse peut tourner a gauche mais ne peut pas avancer [[position : 0 0 N], [instruction :GA]]
        assertEquals("0 0 W",listTondeuse.get(0).getPosition().toString());
        //la Tondeuse peut tourner a Droite mais ne peut pas avancer [[position : 0 0 W], [instruction :DA]]
        assertEquals("0 0 S",listTondeuse.get(1).getPosition().toString());


        //la Tondeuse peut tourner a Droite mais ne peut pas avancer [[position : 0 1 S], [instruction :DA]]
        assertEquals("0 1 W",listTondeuse.get(2).getPosition().toString());
        //la Tondeuse peut tourner a gauche mais ne peut pas avancer [[position : 0 1 E], [instruction :GA]]
        assertEquals("0 1 N",listTondeuse.get(3).getPosition().toString());


        //la Tondeuse peut tourner a Droite mais ne peut pas avancer [[position : 1 1 W], [instruction :DA]]
        assertEquals("1 1 N",listTondeuse.get(4).getPosition().toString());
        //la Tondeuse peut tourner a gauche mais ne peut pas avancer [[position : 1 1 S], [instruction :GA]]
        assertEquals("1 1 E",listTondeuse.get(5).getPosition().toString());

        //la Tondeuse peut tourner a Droite mais ne peut pas avancer [[position : 1 0 N], [instruction :DA]]
        assertEquals("1 0 E",listTondeuse.get(6).getPosition().toString());
        //la Tondeuse peut tourner a Gauche mais ne peut pas avancer [[position : 1 0 W], [instruction :GA]]
        assertEquals("1 0 S",listTondeuse.get(7).getPosition().toString());

    }
}
