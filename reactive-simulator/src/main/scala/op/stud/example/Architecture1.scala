package op.stud.example

import op.stud.simulation.Simulator
import op.stud.simulation.Wire
import op.stud.simulation.Probable
import op.stud.simulation.CircuitRun
import op.stud.simulation.ClockWaveForm
import op.stud.simulation.ClockWave
import op.stud.simulation.ConsoleProbe

object SimulatorImpl extends Simulator with ConsoleProbe
import SimulatorImpl.context

object MyCircuit {
  import Lib1._
  import Lib2._  
  
  val in = new Wire
  val y = new Wire
  val x = new Wire
  val clock = new Wire 
  val nR = new Wire 

  andNot(y, in, x)
  DC(x, nR, clock, y)  
}

object MyCircuitRunClock extends CircuitRun with ClockWaveForm {
  import SimulatorImpl._
  import MyCircuit._
  
  val begin = 0
  val end = 20
  
  val CLK = MyCircuit.clock
  val cloackWave = new ClockWave(4, 6, 2)
  
  probe("#RESET", nR)
  probe("CLK", clock)
  probe("Y", y)
  probe("X", x)  
  probe("in", in)

  fireEvent(WaveEvent(nR, begin, false))
  fireEvent(WaveEvent(nR, begin + 1, true))
  fireEvent(WaveEvent(in, begin, true))
  
  process()
}

object MyCircuitRunManual extends CircuitRun with MyManualWaveForm {
  import SimulatorImpl.probe
  import MyCircuit._
  
  val begin = 0
  val end = 20
  
  probe("CLK", clock)
  probe("Y", y)
  probe("X", x)
  
  process()
}




