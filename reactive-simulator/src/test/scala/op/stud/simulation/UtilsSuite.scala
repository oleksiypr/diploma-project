package op.stud.simulation

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import op.stud.simulation.Utils._
import op.stud.simulation.ImplicitValue._
import op.stud.simulation.Wire._

@RunWith(classOf[JUnitRunner])
class UtilsSuite extends FunSuite {
  test ("Bus to list test. Empty.") {
    val empty = List[Wire]() 
    val emptyBits = busToBits(empty)
    
    assert(emptyBits === List())
  }
  
  test ("Bus to list test. Non empty: 0, 0, 0") {
    val w0, w1, w2 = new Wire
    w0 <== false
    w1 <== false
    w2 <== false
    
    val wires = List(w2, w1, w0) 
    val bits = busToBits(wires)
    
    assert(bits === List(0, 0, 0))
  }
  
  test ("Bus to list test. Non empty: 1, 0, 0") {
    val w0, w1, w2 = new Wire
    w2 <== true
    w1 <== false
    w0 <== false
        
    val wires = List(w2, w1, w1) 
    val bits = busToBits(wires)
    
    assert(bits === List(1, 0, 0))
  }
  
  test ("Bus to list test. Non empty: 0, 0, 1") {
    val w0, w1, w2 = new Wire
    w2 <== false
    w1 <== false
    w0 <== true
        
    val wires = List(w2, w1, w0) 
    val bits = busToBits(wires)
    
    assert(bits === List(0, 0, 1))
  }
  
  test ("Bus to list test. Non empty: 1, 1, 1") {
    val w0, w1, w2 = new Wire
    w2 <== true
    w1 <== true
    w0 <== true
        
    val wires = List(w2, w1, w0) 
    val bits = busToBits(wires)
    
    assert(bits === List(1, 1, 1))
  }
  
  test ("Bits List To Value. Empty") {
    val value = bitsListToValue(List())    
    assert(value == 0)
  }
  
  test ("Bits List To Value. Non empty.") {
    assert(bitsListToValue(List(0, 0, 0)) == 0)
    assert(bitsListToValue(List(0, 0, 1)) == 1)
    assert(bitsListToValue(List(0, 1, 0)) == 2)
    assert(bitsListToValue(List(0, 1, 1)) == 3)
    assert(bitsListToValue(List(1, 0, 0)) == 4)
    assert(bitsListToValue(List(1, 0, 1)) == 5)
    assert(bitsListToValue(List(1, 1, 0)) == 6)
    assert(bitsListToValue(List(1, 1, 1)) == 7)
  }
}