package op.stud.diploma

import op.stud.simulation.ClockWaveForm
import op.stud.simulation.CircuitRun
import op.stud.simulation.ClockWave
import SimulatorImpl.context

object Circuit {
  SFVP
  EP
  DS
  SFVS
}

object CiruitWaveForm extends CircuitRun with ClockWaveForm {
  import SimulatorImpl._
  import IO._
  import InternalWires._
  
  val begin = 0
  val end = 180
  
  Circuit
  val CLK = IO.CLK
  val cloackWave = new ClockWave(63, 100, 26) 
  
  probe("#START", nStart)
  probe("CLK", CLK)
  probe("Q5", Q5)
  probe("Q4", Q4)
  probe("Q3", Q3)
  probe("Q2", Q2)
  probe("Q1", Q1)
  
  probe("D5", D5)
  probe("D4", D4)
  probe("D3", D3)
  probe("D2", D2)
  probe("D1", D1)
  
  probe("a0", a0)
  probe("a1", a1)
  
  probe("y1", y1)
  probe("y2", y2)
  probe("y3", y3)
  probe("y4", y4)
  probe("y6", y6)
  probe("y11", y11)
  probe("y12", y12)
  probe("y16", y16)
  probe("y21", y21)
  probe("y32", y32)
  
  fireEvent(WaveEvent(X1, begin, false))
  fireEvent(WaveEvent(X2, begin, true))
  fireEvent(WaveEvent(X3, begin, true))
  fireEvent(WaveEvent(X4, begin, false))
  
  fireEvent(WaveEvent(nStart, begin, false))
  fireEvent(WaveEvent(nStart, begin + 10, true))
  
  process
}