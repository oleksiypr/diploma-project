package op.stud.example

import op.stud.simulation.Simulator
import op.stud.simulation.ConsoleProbe
import op.stud.simulation.Wire
import op.stud.simulation.CircuitRun
import op.stud.simulation.WaveForm

object SimulatorImpl2 extends Simulator with ConsoleProbe
import SimulatorImpl2.context

object MyCircuit2 {
  import Lib2._

  val in1, in2, out, y = new Wire  
  and(in1, in2, out)
  inverter(out, y)
}

object MyCircuitRun2 extends CircuitRun with WaveForm {
  import MyCircuit2._
  import SimulatorImpl2._

  val begin = 0
  val end = 20

  probe("IN1", in1)
  probe("IN2", in2)
  probe("OUT", out)
  probe("Y", y)

  process

  def fill() {
    fireEvent(WaveEvent(in1, 0, true))
    fireEvent(WaveEvent(in2, 0, true))

    fireEvent(WaveEvent(in2, 10, false))
  }  
}

object MyCircuit3 {
  import Lib2._

  val in1, in2, out = new Wire  
  or(in1, in2, out)
}

object MyCircuitRun3 extends CircuitRun with WaveForm {
  import MyCircuit3._
  import SimulatorImpl2._

  val begin = 0
  val end = 20

  probe("IN1", in1)
  probe("IN2", in2)
  probe("OUT", out)

  process

  def fill() {
    fireEvent(WaveEvent(in1, 0, false))
    fireEvent(WaveEvent(in2, 0, true))

    fireEvent(WaveEvent(in2, 10, false))
  }  
}

object MyCircuit4 {
  import Lib2._

  val in1, in2, out = new Wire  
  andNot(in1, in2, out)
}

object MyCircuitRun4 extends CircuitRun with WaveForm {
  import MyCircuit4._
  import SimulatorImpl2._

  val begin = 0
  val end = 20

  probe("IN1", in1)
  probe("IN2", in2)
  probe("OUT", out)

  process

  def fill() {
    fireEvent(WaveEvent(in2, 0, false))
  }  
}