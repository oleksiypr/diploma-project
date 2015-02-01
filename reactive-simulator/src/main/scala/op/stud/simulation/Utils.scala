package op.stud.simulation

import op.stud.simulation.ImplicitValue._
import op.stud.simulation.Wire._
import scala.math._
import scala.annotation.tailrec

object Utils {
  def busToBits(bus: List[Wire]) = bus map (w => if (w.getSignal.value) 1 else 0)
  
  def bitsListToValue(bits: List[Int]): Int = {
    val n = bits.size - 1
    
    @tailrec
    def bitsListToValueAcc(bitsAcc: List[Int], xAcc: Int): Int = bitsAcc match {
      case List() => xAcc
      case b::rest => if (b > 0) bitsListToValueAcc(rest, xAcc + (pow(2, rest.size)).toInt) 
      				  else bitsListToValueAcc(rest, xAcc)
    }
    
    bitsListToValueAcc(bits, 0)
  }
  
  def setupBus(bus: List[Wire])(signals: Int*): Unit = {
	  (0 until signals.size) foreach (i => bus(i) <== signals(i) > 0)
  }
}