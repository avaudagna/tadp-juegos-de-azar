import org.scalatest.{FlatSpec, FunSuite, Matchers}

class DistribucionDeProbabilidadFactorySpec extends FlatSpec with Matchers  {

  "Una DistribucionSegura" should "tener un unico elemento de probabilidad 1" in {
    val distribucion = DistribucionDeProbabilidadFactory.createDistribucionSegura(Cara)
    distribucion.elementosPosibles.size should be (1)
    distribucion.probabilidad(Cara) should be (1)
  }

  "Una DistribucionEquiprobable" should "tener la misma probabilidad para cada elemento" in {
    val distribucion = DistribucionDeProbabilidadFactory.createDistribucionEquiprobable(Seq(Cara, Cruz))
    distribucion.probabilidad(Cara) should be (0.5)
    distribucion.probabilidad(Cruz) should be (0.5)
  }

  "Una DistribucionPonderada" should "tener, para cada elemento, la probabilidad de su ponderacion" in {
    val distribucion = DistribucionDeProbabilidadFactory.createDistribucionPonderada(
      Seq((Numero(1), 0.5), (Numero(2), 0.2), (Numero(3), 0.3)))
    distribucion.probabilidad(Numero(1)) should be (0.5)
    distribucion.probabilidad(Numero(2)) should be (0.2)
    distribucion.probabilidad(Numero(3)) should be (0.3)
  }

  "Una DistribucionPonderada" should "debe simplificar la probabilidad de sus elementos" in {
    val distribucion = DistribucionDeProbabilidadFactory.createDistribucionPonderada(
      Seq((Numero(1), 0.5), (Numero(2), 0.2), (Numero(2), 0.2), (Numero(3), 0.1)))
    distribucion.probabilidad(Numero(1)) should be (0.5)
    distribucion.probabilidad(Numero(2)) should be (0.4)
    distribucion.probabilidad(Numero(3)) should be (0.1)
  }

  "Una DistribucionPonderada" should "sin ponderacion acumulada a 1, no puede ser creada" in {
    val ponderacionInvalida = Seq((Numero(1), 0.5) , (Numero(2), 0.2), (Numero(3), 0.2))
    val sum = ponderacionInvalida.map(tupla => tupla._2).sum.round
    assertThrows[IllegalArgumentException] {
      DistribucionDeProbabilidadFactory.createDistribucionPonderada(ponderacionInvalida)
    }
  }


}
