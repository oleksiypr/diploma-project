package op.stud.example

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import op.stud.simulation.Simulator
import op.stud.simulation.NullProbe
import org.scalatest.FunSuite
import op.stud.example.Lib1._
import op.stud.simulation.Wire
import op.stud.simulation.Wire._
import op.stud.simulation.ImplicitValue._

@RunWith(classOf[JUnitRunner])
class Lib1Suite extends Simulator with NullProbe with FunSuite {
  import op.stud.example.Lib1._
  
  test("Signal not changed. Q = 0, D = 0, CLK == 0 ") {
    val D, Q, CLK, nR = new Wire
    DC(D, nR, CLK, Q)

    D <== false
    Q <== false
    CLK <== false
    run   
    assert(Q.getSignal == Value(false))  
  }
  
  
  test("Signal not changed. Q = 0, D = 1, CLK == 0 ") {
    val D, Q, CLK, nR = new Wire
    DC(D, nR, CLK, Q)

    D <== true 
    Q <== false 
    CLK <== false 
    run   
    assert(Q.getSignal == Value(false))  
  }
  
  test("Signal not changed. Q = 1, D = 0, CLK == 0 ") {
    val D, Q, CLK, nR = new Wire
    DC(D, nR, CLK, Q)

    D <== false
    Q <== true
    CLK <== false
    run   
    assert(Q.getSignal == Value(true))  
  }
  
  test("Signal not changed. Q = 1, D = 1, CLK == 0 ") {
    val D, Q, CLK, nR = new Wire
    DC(D, nR, CLK, Q)
    
    D <== true
    Q <== true 
    CLK <== false
    run   
    assert(Q.getSignal == Value(true))  
  }
  
  test("Signal not changed. CLK == 1 -> 0 ") {
    val D, Q, CLK, nR = new Wire
    DC(D, nR, CLK, Q)

    D <== false
    Q <== true
    CLK <== true
    run  
    CLK <== false
    run 
    assert(Q.getSignal == Value(true))  
  }
  
   test("Signal ??hanged. CLK == 0 -> 1 ") {
    val D, Q, CLK, nR = new Wire
    DC(D, nR, CLK, Q)

    D <== false
    Q <== true
    CLK <== false
    run  
    CLK <== true
    run 
    assert(Q.getSignal == Value(false))  
    
    D <== true 
    CLK <== false
    run 
    
    CLK.<==(true)
    run
    assert(Q.getSignal == Value(true)) 
  }
}