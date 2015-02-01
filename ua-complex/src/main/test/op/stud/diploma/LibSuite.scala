package op.stud.diploma

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import op.stud.simulation.Simulator
import op.stud.simulation.Simulator
import op.stud.simulation.NullProbe
import org.scalatest.FunSuite

@RunWith(classOf[JUnitRunner])
class LibSuite extends Simulator with NullProbe with FunSuite {
  test("test") {
    assert(true)
  }  
}