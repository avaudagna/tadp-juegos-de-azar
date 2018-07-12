

trait Apuesta {
  def montoTotal:Double
  def distribucionDeGanancias(juego: DistribucionDeProbabilidad[Suceso]): DistribucionDeProbabilidad[Double]
}

class ApuestaSimple(dinero: Double, jugada: Jugada) extends Apuesta {
  override def montoTotal = dinero
  def distribucionDeGanancias(juego: DistribucionDeProbabilidad[Suceso]): DistribucionDeProbabilidad[Double] ={
    juego.map[Double](jugada.jugar(dinero,_))
  }
}

class ApuestaCompuesta(apuestasTotales: List[ApuestaSimple]) extends Apuesta {
  override def montoTotal: Double = apuestasTotales.foldLeft(0.0){(sum,apuesta)=>sum+apuesta.montoTotal}
  def distribucionDeGanancias(juego: DistribucionDeProbabilidad[Suceso]): DistribucionDeProbabilidad[Double] = ???
}

