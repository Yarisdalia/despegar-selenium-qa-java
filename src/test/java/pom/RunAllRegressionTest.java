package pom;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pom.alojamiento.AlojamientoSinFechaTest;
import pom.alojamiento.AlojamientoTest;
import pom.home.HomeTest;
import pom.login.LoginTest;
import pom.ofertas.OfertasTest;
import pom.vuelos.VuelosTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({LoginTest.class, AlojamientoTest.class, AlojamientoSinFechaTest.class, VuelosTest.class, OfertasTest.class, HomeTest.class})
public class RunAllRegressionTest {
}
