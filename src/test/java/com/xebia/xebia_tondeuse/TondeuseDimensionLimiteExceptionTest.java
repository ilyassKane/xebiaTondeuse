package com.xebia.xebia_tondeuse;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TondeuseDimensionLimiteExceptionTest {

    private String fileName="src/test/resources/programmeTondeuseDimensionLimite.dat";
    private TondeuseProgrammeur tondeuseProgrammeur=null;
    List<Tondeuse> listTondeuse=null;

    @Before
    public void setUp(){
        tondeuseProgrammeur= new TondeuseProgrammeur(new TondeuseProgrammeValidation());
        listTondeuse=tondeuseProgrammeur.programme(fileName);
    }

    @Test(expected = PelouseDimentionException.class)
    public void shouldReturnException()
    {
        listTondeuse.forEach(tondeuse->tondeuse.tondre(tondeuseProgrammeur.getPelouse()));
    }
}
