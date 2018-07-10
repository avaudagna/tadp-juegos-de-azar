trait Suceso

case class Numero(numero: Integer) extends Suceso {
  require(numero >= 0 && numero < 37)
}

case object Cara extends Suceso
case object Cruz extends Suceso

