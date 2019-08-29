package com.xebia.xebia_tondeuse;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class TondeuseTest {



    private String fileName="src/test/resources/programmeTondeuse.dat";
    private TondeuseProgrammeur tondeuseProgrammeur=null;
    List<Tondeuse> listTondeuse=null;

    @Before
    public void setUp(){
        tondeuseProgrammeur= new TondeuseProgrammeur(new TondeuseProgrammeValidation());
        listTondeuse=tondeuseProgrammeur.programme(fileName);
        listTondeuse.forEach(tondeuse->tondeuse.tondre(tondeuseProgrammeur.getPelouse()));
    }

    @Test
    public void shouldReturn1_3_N(){
        assertEquals("1 3 N",listTondeuse.get(0).getPosition().toString());
    }
    
    @Test
    public void shouldReturn5_1_E(){
        assertEquals("5 1 E",listTondeuse.get(1).getPosition().toString());
    }
}