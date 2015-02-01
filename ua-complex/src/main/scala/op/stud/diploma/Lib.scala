package op.stud.diploma

import op.stud.simulation.lib.STD
import op.stud.simulation.Wire
import op.stud.simulation.Simulator
import op.stud.simulation.ImplicitValue._
import op.stud.simulation.Wire._
import op.stud.simulation.Utils._

object Lib {
  val triggerDelayQ = 10
  val triggerDelayNotQ = 11
  val asynchResetDelay = 2

  val inverterDelay = 2
  val and4Delay = 4
  val or4Delay = 4
  val and2Or4Delay = 6
  val decoderDelay = 8
  
  def inv(in: Wire, out: Wire)(implicit simulator: Simulator) {   
    STD.inverter(in, out, inverterDelay)   
  }
  
  class TriggerDC(
    C: Wire,
    D: Wire,
    nR: Wire,
    Q: Wire,
    nQ: Wire)(implicit simulator: Simulator) {
    import simulator._

    private var oldClock = C.getSignal
    def triggerAction() {
      val clockSig = C.getSignal
      if (oldClock != Z && (!oldClock & clockSig).value) {
        val dSig = D.getSignal

        afterDelay(triggerDelayQ) {
          Q <== dSig
        }
        afterDelay(triggerDelayNotQ) {
          nQ <== !dSig
        }
      }
      oldClock = clockSig
    }

    def asynchResetAction() {
      afterDelay(asynchResetDelay) {
        if (nR.getSignal != Z && !nR.getSignal.value) {
          Q <== false
          nQ <== true
        }
      }
    }

    C <= triggerAction
    nR <= asynchResetAction
  }

  def and4(
    in0: Wire,
    in1: Wire,
    in2: Wire,
    in3: Wire,
    out: Wire)(implicit simulator: Simulator) {
    import simulator._

    def andAction() {
      val sig0 = in0.getSignal
      val sig1 = in1.getSignal
      val sig2 = in2.getSignal
      val sig3 = in3.getSignal
      afterDelay(and4Delay) { out <== !(sig0 & sig1 & sig2 & sig3) }
    }

    in0 <= andAction
    in1 <= andAction
    in2 <= andAction
    in3 <= andAction
  }

  def or4(
    in0: Wire,
    in1: Wire,
    in2: Wire,
    in3: Wire,
    out: Wire)(implicit simulator: Simulator) {
    import simulator._
    
    def orAction() {
      val sig0 = in0.getSignal
      val sig1 = in1.getSignal
      val sig2 = in2.getSignal
      val sig3 = in3.getSignal
      afterDelay(and4Delay) { out <== !(sig0 | sig1 | sig2 | sig3) }
    }

    in0 <= orAction
    in1 <= orAction
    in2 <= orAction
    in3 <= orAction
  }
  
  def andor (
       in0: Wire,
       in1: Wire,
       in2: Wire,
       in3: Wire,
       in4: Wire,
       in5: Wire,
       in6: Wire,
       in7: Wire,
       out: Wire)(implicit simulator: Simulator) {
    import simulator._

    def andorAction() {
      val sig0 = in0.getSignal
      val sig1 = in1.getSignal
      val sig2 = in2.getSignal
      val sig3 = in3.getSignal
      val sig4 = in4.getSignal
      val sig5 = in5.getSignal
      val sig6 = in6.getSignal
      val sig7 = in7.getSignal
      
      afterDelay(and2Or4Delay) {
        out <== !((sig0 & sig1) | (sig2 & sig3 & sig4) | (sig5 & sig6 & sig7))
      }     
    }

    in0 <= andorAction
    in1 <= andorAction
    in2 <= andorAction
    in3 <= andorAction
    in4 <= andorAction
    in5 <= andorAction
    in6 <= andorAction
    in7 <= andorAction
  }
  
  def DC5X32(
       D1 : Wire, D2 : Wire, D3 : Wire, D4 : Wire, D5 : Wire,
       E : Wire,
       O1 : Wire,
       O2 : Wire,
       O3 : Wire,
       O4 : Wire,
       O5 : Wire,
       O6 : Wire,
       O7 : Wire,
       O8 : Wire,
       O9 : Wire,
       O10 : Wire,
       O11 : Wire,
       O12 : Wire,
       O13 : Wire,
       O14 : Wire,
       O15 : Wire,
       O16 : Wire,
       O17 : Wire,
       O18 : Wire,
       O19 : Wire,
       O20 : Wire,
       O21 : Wire,
       O22 : Wire,
       O23 : Wire,
       O24 : Wire,
       O25 : Wire,
       O26 : Wire,
       O27 : Wire,
       O28 : Wire,
       O29 : Wire,
       O30 : Wire,
       O31 : Wire,
       O32 : Wire
  )(implicit simulator: Simulator) {
    import simulator._
        
    val X = List(D5, D4, D3, D2, D1)
    val Y = List(
        O32, O31, O30, 
    	O29, O28, O27, O26, O25, O24, O23, O22, O21, O20,
    	O19, O18, O17, O16, O15, O14, O13, O12, O11, O10,
    	 O9,  O8,  O7,  O6,  O5,  O4,  O3,  O2,  O1
    )

    def decoderAction() {
      E.getSignal match {
        case Z => afterDelay(decoderDelay) { Y foreach (_ <== Z) }
        case Value(false) => afterDelay(decoderDelay) { Y foreach (_ <== false) }
        case Value(true) => STD.decoder(X, Y, decoderDelay)(simulator)
      }
    }
    
    X foreach (_ <= decoderAction)
    E <= decoderAction
  } 
}

