package op.sim

import op.stud.simulation.Wire
import op.stud.simulation.Simulator
import op.stud.simulation.ImplicitValue._
import op.stud.simulation.Wire._
import op.stud.simulation.Utils._

object Lib {
  val invertorDelay = 1
  val and3Delay = 2
  val or3Delay = 2
  val andDelay = 2
  val orDelay = 2
  val decoderDelay = 4
  
  val triggerDelayDC = 6 
  val asynchResetDelay = 2
  
  def inverter(in: Wire, out: Wire)(implicit simulator: Simulator) {
    import simulator._
    
    def invertAction() {
      val inputSig = in.getSignal
      afterDelay(invertorDelay) { out <== !inputSig }
    }
    in <= invertAction
  }
  
  def and(in1: Wire, in2: Wire, out: Wire)(implicit simulator: Simulator) {
    import simulator._
    
    def andAction() {
      val sig1 = in1.getSignal
      val sig2 = in2.getSignal
      afterDelay(andDelay) { out <== sig1 & sig2 }
    }
    in1 <= andAction
    in2 <= andAction
  } 
  
  def and3(in1: Wire, in2: Wire, in3: Wire, out: Wire)(implicit simulator: Simulator) {
    import simulator._
    
    def andAction() {
      val sig1 = in1.getSignal
      val sig2 = in2.getSignal
      val sig3 = in3.getSignal
      afterDelay(and3Delay) { out <== sig1 & sig2 & sig3 }
    }
    in1 <= andAction
    in2 <= andAction
    in3 <= andAction
  } 
  
  def or3(in1: Wire, in2: Wire, in3: Wire, out: Wire)(implicit simulator: Simulator) {
    import simulator._
    
    def andAction() {
      val sig1 = in1.getSignal
      val sig2 = in2.getSignal
      val sig3 = in2.getSignal
      afterDelay(or3Delay) { out <== sig1 | sig2 | sig3 }
    }
    in1 <= andAction
    in2 <= andAction
    in3 <= andAction
  } 
  
  def or(in1: Wire, in2: Wire, out: Wire)(implicit simulator: Simulator) {
    import simulator._
    
    def andAction() {
      val sig1 = in1.getSignal
      val sig2 = in2.getSignal
      afterDelay(orDelay) { out <== sig1 | sig2 }
    }
    in1 <= andAction
    in2 <= andAction
  } 
  
  def decoder(A: List[Wire], Y: List[Wire])(implicit simulator: Simulator) {
    import simulator._
    
    def decoderAction() {
      if (A filter (_.getSignal == Z) isEmpty) { 
        val i = bitsListToValue(busToBits(A))
        val n = Y.size
        for (k <- 0 until n) {
          afterDelay(decoderDelay) { 
            Y(k) <== (k == n - i - 1) 
          }
        }
      } else {
        Y foreach (_ <== Z)
      }
    }
    
    A foreach(_ <= decoderAction)
  }
  
  class TriggerDC(d: Wire, nR: Wire, clock: Wire, q: Wire)(implicit simulator: Simulator) {
    import simulator._
    
    private var oldClock = clock.getSignal
    def triggerAction() {
      val clockSig = clock.getSignal
      if (oldClock != Z && (!oldClock & clockSig).value) {    
        val dSig = d.getSignal
        afterDelay(triggerDelayDC) { 
          q <== dSig 
        }
      }      
      oldClock = clockSig
    }

    def asynchResetAction() {
      simulator.afterDelay(asynchResetDelay) {
        if (nR.getSignal !=Z && !nR.getSignal.value) q <== false 
      }
    }
    
    clock <= triggerAction
    nR <= asynchResetAction
  }
}