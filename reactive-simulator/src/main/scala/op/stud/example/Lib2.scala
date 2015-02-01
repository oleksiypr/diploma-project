package op.stud.example

import op.stud.simulation.Wire
import op.stud.simulation.Simulator

object Lib2 {
  val invertorDelay = 1
  val andDelay = 2
  val andNotDelay = 1
  
  def inverter(in: Wire, out: Wire)(implicit simulator: Simulator) {
    import simulator._
    
    def invertAction() {
      val inputSig = in.getSignal
      afterDelay(invertorDelay) { out.<==(!inputSig) }
    }
    in <= invertAction
  }
  
  def and(in1: Wire, in2: Wire, out: Wire)(implicit simulator: Simulator) {
    import simulator._
    
    def andAction() {
      val sig1 = in1.getSignal
      val sig2 = in2.getSignal
      afterDelay(andDelay) { out.<==(sig1 & sig2) }
    }
    in1 <= andAction
    in2 <= andAction
  } 
  
  def andNot(in1: Wire, in2: Wire, out: Wire)(implicit simulator: Simulator) {
    import simulator._
    
    def andAction() {
      val sig1 = in1.getSignal
      val sig2 = in2.getSignal
      afterDelay(andNotDelay) { out.<==(!(sig1 & sig2)) }
    }
    in1 <= andAction
    in2 <= andAction
  }
  
  def or(a1: Wire, a2: Wire, output: Wire)(implicit simulator: Simulator) {
    def orAction() {
      val na1 = new Wire
      val na2 = new Wire
      val nout = new Wire
      
      inverter(a1, na1)
      inverter(a2, na2)
      and(na1, na2, nout)
      inverter(nout, output)
    }
    a1 <= orAction
    a2 <= orAction
  }
}