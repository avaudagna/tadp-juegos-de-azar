import scala.util.Random

trait Juego {
  def sucesosPosibles:Seq[Suceso]
  def distribucionDeProbabilidad:DistribucionDeProbabilidad[Suceso]
  def jugar():Suceso
}

object Ruleta extends Juego {
  val sucesosPosibles = Seq(Sale0, Sale1, Sale2, Sale3, Sale4, Sale5, Sale6, Sale7, Sale8, Sale9,
    Sale10, Sale11, Sale12, Sale13, Sale14, Sale15, Sale16, Sale17, Sale18, Sale19,
    Sale20, Sale21, Sale22, Sale23, Sale24, Sale25, Sale26, Sale27, Sale28, Sale29,
    Sale30, Sale31, Sale32, Sale33, Sale34, Sale35, Sale36)
  val random = new Random(sucesosPosibles.length)
  val distribucionDeProbabilidad: DistribucionDeProbabilidad[Suceso] = DistribucionDeProbabilidadFactory.createDistribucionEquiprobable(sucesosPosibles)
  override def jugar(): Suceso = sucesosPosibles(random.nextInt())
}

object CaraOCruz extends Juego {
  val sucesosPosibles = Seq(Cara, Cruz)
  val random = new Random(sucesosPosibles.length)
  val distribucionDeProbabilidad: DistribucionDeProbabilidad[Suceso] = DistribucionDeProbabilidadFactory.createDistribucionEquiprobable(sucesosPosibles)
  override def jugar() = sucesosPosibles(new Random().nextInt())
}