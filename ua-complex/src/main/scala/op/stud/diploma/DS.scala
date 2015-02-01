package op.stud.diploma

import op.stud.diploma.Lib._
import op.stud.simulation.Wire
import op.stud.simulation.Wire.VCC
import op.stud.simulation.Wire.GND
import SimulatorImpl.context

object DS {
  import IO._
  import InternalWires._
  
  DC5X32(Q5, Q4, Q3, Q2, Q1, VCC,
		  a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21, a22, a23, a24, a25, a26, a27, a28, a29, new Wire, new Wire)
}