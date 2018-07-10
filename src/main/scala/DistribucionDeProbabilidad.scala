

object DistribucionDeProbabilidadFactory {

  def createDistribucionEquiprobable[T](elementos: Seq[T]) = {
    val probabilidad: Double = 1.0 / elementos.size
    new DistribucionDeProbabilidad[T](elementos.map(x => (x, probabilidad)))
  }

  def createDistribucionSegura[T](elemento: T) = new DistribucionDeProbabilidad[T](List((elemento, 1)))

  def createDistribucionPonderada[T](elementosPonderados: Seq[(T, Double)]) = new DistribucionDeProbabilidad[T](elementosPonderados)
}

class DistribucionDeProbabilidad[T](elementos: Seq[(T, Double)]) {
  require(BigDecimal(elementos.map(tupla => tupla._2).sum).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble == 1.0)

  val distribucion: Map[T, Double] = flatMap(elementos)

  def probabilidad(elemento:T) = distribucion.getOrElse(elemento, 0)

  def elementosPosibles: Set[T] = distribucion.keySet

  def flatMap(tuples: Seq[(T, Double)]) : Map[T, Double] = {
    tuples.groupBy(_._1)
      .mapValues(_.reduce((acum: (T, Double), tupla: (T, Double))
        => (acum._1, acum._2 + tupla._2))).values.toMap
  }

  def map[B](f: T => B): DistribucionDeProbabilidad[B] = {
    val nuevaDistribucion: Seq[(B, Double)] = distribucion.toList.map {
      case (elemento: T, probabilidad: Double) => (f(elemento), probabilidad: Double)
    }
    new DistribucionDeProbabilidad[B](nuevaDistribucion)
  }
}
