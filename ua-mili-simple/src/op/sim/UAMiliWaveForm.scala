package op.sim

import op.stud.simulation.ClockWaveForm
import op.stud.simulation.CircuitRun
import op.stud.simulation.ClockWave

import SimulatorImpl.context

object UAMiliWaveForm extends CircuitRun with ClockWaveForm  {
  import InOutWires._
  import InternalWires._
  import Circuit.a2
  import SimulatorImpl._
  
  val begin = 0
  val end = 60
  
  val CLK = InOutWires.CLK
  val cloackWave = new ClockWave(2, 30, 26)
  
  probe("#START", nStart)
  probe("CLK", CLK)
  
  probe("D1", D1)
  probe("D0", D0)
  
  probe("Q1", Q1)
  probe("Q0", Q0)
  
  probe("a2", a2)
  probe("a1", a1)
  probe("a0", a0)
  
  probe("y4", y4)
  probe("y3", y3)
  probe("y2", y2)
  probe("y1", y1)

  probe("x2", x2)
  probe("x1", x1)
  
  fireEvent(WaveEvent(x1, begin, true))
  fireEvent(WaveEvent(x2, begin, true))
  
  fireEvent(WaveEvent(x1, begin + 20, false))
  
  fireEvent(WaveEvent(nStart, begin, false))
  fireEvent(WaveEvent(nStart, begin + 1, true))
  
  process()
}