import org.scalatest.{FlatSpec, Matchers}

class JugadaSpec extends FlatSpec with Matchers {

  "Una jugada que se haya cumplido" should "multiplicar el monto apostado por su factor de retribucion" in {
    val jugadaFavorable = new Jugada(2.0, (suceso: Suceso) => suceso == Sale1)
    jugadaFavorable.jugar(10, Sale1) should be (20)
  }

  "Una jugada que no se haya cumplido no" should "multiplicar el monto apostado por su factor de retribucion" in {
    val jugadaFavorable = new Jugada(2.0, (suceso: Suceso) => suceso == Sale2)
    jugadaFavorable.jugar(10, Sale1) should not be 20
  }

  "Una jugada que no se haya cumplido" should "devolver ganancia 0" in {
    val jugadaFavorable = new Jugada(2.0, (suceso: Suceso) => suceso == Sale2)
    jugadaFavorable.jugar(10, Sale1) should be (0)
  }

  //Tests CaraOCruz :
  // JugarACara, apostando a Cruz, se pierde
  // JugarACara, apostando a Cara, se gana
  // JugarACruz, apostando a Cruz, se gana
  // JugarACruz, apostando a Cara, se pierde

  //Tests Ruleta :
  // JugarANumero, apostando al Numero, se gana
  // JugarANumero, apostando a otro, se pierde
  // JugarAColor, apostando a colores del mismo, se gana el maximo
  // JugarAColor, apostando a otro, se pierde
  // JugarADocena, apostando a elemento de la misma, se gana
  // JugarADocena, apostando a otro, se pierde
  // JugarAPar, aspotando a impar, se pierde
  // JugarAImpar, apostando a par, se gana
}
