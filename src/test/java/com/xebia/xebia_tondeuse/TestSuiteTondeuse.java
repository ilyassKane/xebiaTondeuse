package com.xebia.xebia_tondeuse;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({PositionTest.class, TondeuseTest.class,
        TondeuseCasLimiteTest.class,
        TondeuseCoordonneePelouseHorsDePorteTest.class,
        TondeuseDimensionLimiteExceptionTest.class})
public class TestSuiteTondeuse {
}
