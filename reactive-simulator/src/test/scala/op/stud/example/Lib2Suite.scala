package op.stud.example

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import op.stud.simulation.Simulator
import org.scalatest.FunSuite
import op.stud.simulation.NullProbe
import op.stud.simulation.Wire
import op.stud.simulation.Wire._
import op.stud.example.Lib2._
import op.stud.simulation.ImplicitValue._

@RunWith(classOf[JUnitRunner])
class Lib2Suite extends Simulator with NullProbe with FunSuite {
  test ("inverter") {
    val out  = new Wire
    inverter(GND, out)
    
    currentTime = 0
    run
    assert(out.getSignal == Value(true))
    assert(currentTime == invertorDelay)
  }
  
  test ("and") {
    val in, out  = new Wire
    and(GND, VCC, out)
    
    val t0 = currentTime 
    run
    assert(out.getSignal == Value(false))
    assert(currentTime == t0 + andDelay)
    
    
    val t1 = currentTime 
    and(VCC, VCC, out)
    run
    assert(out.getSignal == Value(true))
    assert(currentTime == t1 + andDelay)
    
    and(VCC, in, out)
    in.<==(false)
    run
    assert(out.getSignal == Value(false))
  }
}