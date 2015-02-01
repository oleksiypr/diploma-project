package op.sim

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import op.stud.simulation.Simulator
import op.stud.simulation.NullProbe
import org.scalatest.FunSuite
import op.sim.Lib._
import op.stud.simulation.Wire
import op.stud.simulation.Wire._
import op.stud.simulation.ImplicitValue._
import op.stud.simulation.Utils._

@RunWith(classOf[JUnitRunner])
class LibSuite extends Simulator with NullProbe with FunSuite {  
  test("Z state input decoder") {
    val A = List(new Wire, new Wire)
    val Y = List(new Wire, new Wire, new Wire, new Wire)    
    decoder(A, Y)
    
    setupBus(Y)(0, 0, 1, 0)
    run
    
    A(1) <== true
    A(0) <== Z
    run
    
    assert(Y(3).getSignal == Z)
    assert(Y(2).getSignal == Z)
    assert(Y(1).getSignal == Z)
    assert(Y(0).getSignal == Z)
  }
  
  test("full decoder") {
    val A = List(new Wire, new Wire)
    val Y = List(new Wire, new Wire, new Wire, new Wire)    
    decoder(A, Y)
    
    setupBus(A)(0, 0)  
    run
    assert(busToBits(Y) === List(0, 0, 0, 1))
    
    setupBus(A)(0, 1)  
    run
    assert(busToBits(Y) === List(0, 0, 1, 0))    
    
    setupBus(A)(1, 0)  
    run
    assert(busToBits(Y) === List(0, 1, 0, 0))   
    
    setupBus(A)(1, 1)  
    run
    assert(busToBits(Y) === List(1, 0, 0, 0))  
  }
  
  test("non full decoder") {
    val A = List(new Wire, new Wire)
    val Y = List(new Wire, new Wire, new Wire)    
    decoder(A, Y)
    
    setupBus(A)(0, 0)  
    run
    assert(busToBits(Y) === List(0, 0, 1))
    
    setupBus(A)(0, 1)  
    run
    assert(busToBits(Y) === List(0, 1, 0))    
    
    setupBus(A)(1, 0)  
    run
    assert(busToBits(Y) === List(1, 0, 0))   
    
    setupBus(A)(1, 1)  
    run
    assert(busToBits(Y) === List(0, 0, 0))  
  }
  
  test("Signal not changed. Q = 0, D = 0, CLK == 0 ") {
    val D, Q, CLK, nR = new Wire
    val trigger = new TriggerDC(D, nR, CLK, Q)

    D <== false
    Q <== false
    CLK <== false
    run   
    assert(Q.getSignal == Value(false))  
  }
  
  
  test("Signal not changed. Q = 0, D = 1, CLK == 0 ") {
    val D, Q, CLK, nR = new Wire
    val trigger = new TriggerDC(D, nR, CLK, Q)

    D <== true
    Q <== false
    CLK <== false
    run   
    assert(Q.getSignal == Value(false))  
  }
  
  test("Signal not changed. Q = 1, D = 0, CLK == 0 ") {
    val D, Q, CLK, nR = new Wire
    val trigger = new TriggerDC(D, nR, CLK, Q)

    D <== false
    Q <== true
    CLK <== false
    run   
    assert(Q.getSignal == Value(true))  
  }
  
  test("Signal not changed. Q = 1, D = 1, CLK == 0 ") {
    val D, Q, CLK, nR = new Wire
    val trigger = new TriggerDC(D, nR, CLK, Q)
    
    D <== true
    Q <== true
    CLK <== false
    run   
    assert(Q.getSignal == Value(true))  
  }
  
  test("Signal not changed. CLK == 1 -> 0 ") {
    val D, Q, CLK, nR = new Wire
    val trigger = new TriggerDC(D, nR, CLK, Q)

    D <== false
    Q <== true
    CLK <== true
    run  
    CLK <== false
    run 
    assert(Q.getSignal == Value(true))  
  }
  
   test("Signal сhanged. CLK == 0 -> 1 ") {
    val D, Q, CLK, nR = new Wire
    val trigger = new TriggerDC(D, nR, CLK, Q)

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
    
    CLK <== true
    run
    assert(Q.getSignal == Value(true)) 
  }
}