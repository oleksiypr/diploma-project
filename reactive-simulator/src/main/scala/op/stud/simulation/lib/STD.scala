package op.stud.simulation.lib

import op.stud.simulation.Wire
import op.stud.simulation.Simulator
import op.stud.simulation.ImplicitValue._
import op.stud.simulation.Wire._
import op.stud.simulation.Utils._

object STD {
  def inverter(in: Wire, out: Wire, delay: Int)(implicit simulator: Simulator) {
    import simulator._
    
    def invertAction() {
      val inputSig = in.getSignal
      afterDelay(delay) { out <== !inputSig }
    }
    in <= invertAction
  }
  
  def and(in1: Wire, in2: Wire, out: Wire, delay: Int)(implicit simulator: Simulator) {
    import simulator._
    
    def andAction() {
      val sig1 = in1.getSignal
      val sig2 = in2.getSignal
      afterDelay(delay) { out <== sig1 & sig2 }
    }
    in1 <= andAction
    in2 <= andAction
  } 
  
  def or(in1: Wire, in2: Wire, out: Wire, delay: Int)(implicit simulator: Simulator) {
    import simulator._
    
    def andAction() {
      val sig1 = in1.getSignal
      val sig2 = in2.getSignal
      afterDelay(delay) { out <== sig1 | sig2 }
    }
    in1 <= andAction
    in2 <= andAction
  } 
  
  def decoder(A: List[Wire], Y: List[Wire], delay: Int)(implicit simulator: Simulator) {
    import simulator._
    
    def decoderAction() {
      if (A filter (_.getSignal == Z) isEmpty) { 
        val i = bitsListToValue(busToBits(A))
        val n = Y.size
        for (k <- 0 until n) {
          afterDelay(delay) { 
            Y(k) <== (k == n - i - 1) 
          }
        }
      } else {
        Y foreach (_ <== Z)
      }
    }
    
    A foreach(_ <= decoderAction)
  }
}