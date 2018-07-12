import org.scalatest.{FlatSpec, Matchers}


class ApuestaSimpleTest extends FlatSpec with Matchers {


  "CaraOCruz" should "tener la distribucion de ganancia conocida" in {
    val saleCaraDuplica = new Jugada(2.0,(suceso: Suceso) => suceso == Cara)
    val apuesta10ACaraDuplica = new ApuestaSimple(10.0, saleCaraDuplica)
    val distribucionDeGanancias = apuesta10ACaraDuplica.distribucionDeGanancias(CaraOCruz.distribucionDeProbabilidad)
    distribucionDeGanancias.probabilidad(20) should be (0.5)
    distribucionDeGanancias.probabilidad(0) should be (0.5)
  }

  "Ruleta" should "tener la distribucion de ganancia conocida" in {
    val sale5Triplica = new Jugada(3.0,(suceso: Suceso) => suceso == Sale5)
    val apuesta10ACaraDuplica = new ApuestaSimple(10.0, sale5Triplica)
    val distribucionDeGanancias = apuesta10ACaraDuplica.distribucionDeGanancias(Ruleta.distribucionDeProbabilidad)
    distribucionDeGanancias.probabilidad(30) should be (0.02702702702702703)
    distribucionDeGanancias.probabilidad(0) should be (0.9729729729729721)
  }

}

class ApuestaCompuestaTest extends FlatSpec with Matchers {

}