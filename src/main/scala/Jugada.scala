import java.util.function.Predicate

//Se gana o se pierde en funcion de cierto predicado para el suceso
class Jugada(factorDeRetribucion:Double,
             predicado:Predicate[Suceso]) {

  def jugar(monto:Double, suceso:Suceso) : Double = {
    if (predicado.test(suceso)) monto*factorDeRetribucion else 0
  }
}

