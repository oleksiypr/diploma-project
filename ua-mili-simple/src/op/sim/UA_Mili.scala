package op.sim

import op.stud.simulation.Simulator
import op.stud.simulation.ConsoleProbe
import op.stud.simulation.Wire
import op.stud.simulation.Wire._
import op.stud.simulation.ImplicitValue._
import op.stud.simulation.Utils._
import op.sim.Lib._

object SimulatorImpl extends Simulator with ConsoleProbe
import SimulatorImpl.context

object InOutWires {
  val x1, x2 = new Wire
  val CLK = new Wire
  val nStart = new Wire
  
  val y1, y2, y3, y4 = new Wire    
}

object InternalWires {
  val a0, a1 = new Wire
      
  val Q0, Q1 = new Wire
  val D0, D1 = new Wire
  val nx1, nx2 = new Wire
  
  val D0f1 = new Wire
  val D1f1, D1f2 = new Wire
  
  val y1f1 = new Wire
  val y2f1 = new Wire
  val y3f1, y3f2 = new Wire
}

object SFVP {
  import InOutWires._
  import InternalWires._
  
  inverter(x1, nx1)
  inverter(x2, nx2)
  
  and3(a1, x1, x2, D0f1)
  or(a0, D0f1, D0)
  
  and(a1, nx1, D1f2)
  and3(a1, x1, nx2, D1f1)
  or(D1f2, D1f1, D1)  
}

object EP {
  import InOutWires._
  import InternalWires._
  
  val trigger1 = new TriggerDC(D1, nStart, CLK, Q1)
  val trigger0 = new TriggerDC(D0, nStart, CLK, Q0)
}

object DS {
  import InOutWires._
  import InternalWires._
  
  val a2 = InOutWires.y4
  val decoderIn = List(Q1, Q0)
  val decoderOut = List(a2, a1, a0) 
  decoder(decoderIn, decoderOut)
}

object SFVS {
  import InOutWires._
  import InternalWires._
  
  val a2 = InOutWires.y4
  and(a1, nx1, y3f2)
  and3(a1, x1, nx2, y3f1)
  or(y3f2, y3f1, y3)
  
  and3(a1, x1, x2, y2f1)
  or3(a0, y2f1, a2, y2)
  
  and(a1, x1, y1f1)
  or(a0, y1f1, y1)  
}

object Circuit {
  val a2 = InOutWires.y4

  SFVP
  EP
  DS
  SFVS
}
