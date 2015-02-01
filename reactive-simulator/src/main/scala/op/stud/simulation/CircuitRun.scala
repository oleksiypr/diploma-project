package op.stud.simulation

abstract class CircuitRun(implicit val context: Simulator) extends App {
  val begin: Int
  val end: Int
  def process(): Unit
}