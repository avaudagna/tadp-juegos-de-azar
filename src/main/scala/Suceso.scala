trait Suceso

case object Cara extends Suceso
case object Cruz extends Suceso

class SucesoRuleta(val numero:Integer, val esRojo:Boolean) extends Suceso {
  require(numero >= 0 && numero < 37)

  def esPar() = if (numero != 0) {numero % 2 == 0} else false

  def esImpar() = if (numero != 0) {numero % 2 != 0} else false

  def esPrimeraDocena() = numero > 0 && numero <= 12

  def esSegundaDocena() = numero > 12 && numero <= 24

  def esTerceraDocena() = numero > 24 && numero <= 36

  def esNegro() = !esRojo && numero != 0
}

case object Sale0 extends SucesoRuleta(0, false)
case object Sale1 extends SucesoRuleta(1, true)
case object Sale2 extends SucesoRuleta(2, false)
case object Sale3 extends SucesoRuleta(3, true)
case object Sale4 extends SucesoRuleta(4, false)
case object Sale5 extends SucesoRuleta(5, true)
case object Sale6 extends SucesoRuleta(6, false)
case object Sale7 extends SucesoRuleta(7, true)
case object Sale8 extends SucesoRuleta(8, false)
case object Sale9 extends SucesoRuleta(9, true)
case object Sale10 extends SucesoRuleta(10, false)
case object Sale11 extends SucesoRuleta(11, false)
case object Sale12 extends SucesoRuleta(12, true)
case object Sale13 extends SucesoRuleta(13, false)
case object Sale14 extends SucesoRuleta(14, true)
case object Sale15 extends SucesoRuleta(15, false)
case object Sale16 extends SucesoRuleta(16, true)
case object Sale17 extends SucesoRuleta(17, false)
case object Sale18 extends SucesoRuleta(18, true)
case object Sale19 extends SucesoRuleta(19, true)
case object Sale20 extends SucesoRuleta(20, false)
case object Sale21 extends SucesoRuleta(21, true)
case object Sale22 extends SucesoRuleta(22, false)
case object Sale23 extends SucesoRuleta(23, true)
case object Sale24 extends SucesoRuleta(24, false)
case object Sale25 extends SucesoRuleta(25, true)
case object Sale26 extends SucesoRuleta(26, false)
case object Sale27 extends SucesoRuleta(27, true)
case object Sale28 extends SucesoRuleta(28, false)
case object Sale29 extends SucesoRuleta(29, false)
case object Sale30 extends SucesoRuleta(30, true)
case object Sale31 extends SucesoRuleta(31, false)
case object Sale32 extends SucesoRuleta(32, true)
case object Sale33 extends SucesoRuleta(33, false)
case object Sale34 extends SucesoRuleta(34, true)
case object Sale35 extends SucesoRuleta(35, false)
case object Sale36 extends SucesoRuleta(36, true)


