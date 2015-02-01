package op.stud.diploma

import op.stud.diploma.Lib._
import op.stud.simulation.Wire
import op.stud.simulation.Wire.VCC
import op.stud.simulation.Wire.GND
import SimulatorImpl.context

object EP {
  import IO._
  import InternalWires._
  
  val dc1 = new TriggerDC(CLK, D1, nStart, Q1, new Wire)
  val dc2 = new TriggerDC(CLK, D2, nStart, Q2, new Wire)
  val dc3 = new TriggerDC(CLK, D3, nStart, Q3, new Wire)
  val dc4 = new TriggerDC(CLK, D4, nStart, Q4, new Wire)
  val dc5 = new TriggerDC(CLK, D5, nStart, Q5, new Wire)
}