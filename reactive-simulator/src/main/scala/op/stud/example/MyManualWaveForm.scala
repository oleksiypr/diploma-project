package op.stud.example

import op.stud.simulation.Wire
import op.stud.simulation.WaveForm
import op.stud.simulation.CircuitRun
import op.stud.simulation.ImplicitValue._

trait MyManualWaveForm extends WaveForm {
  self: CircuitRun =>
  
  import SimulatorImpl._
  import MyCircuit._
  
  def fill() { /*   
    clock.setSignal(true)
    y.setSignal(false)
    run

    currentTime = 2
    clock.setSignal(false)
    run

    currentTime = 6
    clock.setSignal(true)
    run

    currentTime = 12
    clock.setSignal(false)
    run

    currentTime = 16
    clock.setSignal(true)
    run

    currentTime = 20
    clock.setSignal(true)
    run*/
  }
}