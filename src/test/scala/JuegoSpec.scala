import org.scalatest.{FlatSpec, Matchers}

class JuegoSpec extends FlatSpec with Matchers  {

  "La ruleta" should "tener 37 numeros registrados" in {
    Ruleta.sucesosPosibles.size should be (37)
  }

  "Todos los numeros de la ruleta" should "tener la misma probabilidad de ocurrencia para sus sucesos" in {
    Ruleta.sucesosPosibles.forall(suceso => Ruleta.distribucionDeProbabilidad.probabilidad(suceso) == 1.0/Ruleta.sucesosPosibles.size) should be (true)
  }

  "El Sale0 de la Ruleta" should "No ser negro, ni par, ni impar" in {
    !Sale0.esNegro && !Sale0.esRojo && !Sale0.esPar && !Sale0.esImpar should be (true)
  }

  "CaraOCruz" should "tener los Sucesos Cara y Cruz registrados" in {
    CaraOCruz.sucesosPosibles.size should be (2)
  }

  "CaraOCruz" should "tener la misma probabilidad de ocurrencia" in {
    CaraOCruz.sucesosPosibles.forall(suceso => CaraOCruz.distribucionDeProbabilidad.probabilidad(suceso) == 1.0/CaraOCruz.sucesosPosibles.size) should be (true)
  }
}
