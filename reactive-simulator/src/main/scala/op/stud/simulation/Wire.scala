package op.stud.simulation

class Wire {  
  import Wire._
  private var sigVal: Signal = Z
  private var actions: List[Simulator#Action] = List()
  
  def getSignal: Signal = sigVal
  
  def <==(s: Signal) {
    setSignal(s)
  }
  
  def setSignal(s: Signal) {
    if (s != sigVal) {
      sigVal = s
      actions.foreach(action => action())
    }
  }

  def <=(a: Simulator#Action) {
    addAction(a)
  }
  
  def addAction(a: Simulator#Action) {
    actions = a :: actions
    a()
  }  
}

object Wire {
  abstract class Signal {
    def value: Boolean
    def &(s: Signal): Signal
    def |(s: Signal): Signal
    def ^(s: Signal): Signal
    def unary_!(): Signal
    def !=(s: Signal) = !(==(s))
  }
  
  case object Z extends Signal {
    def value: Boolean = throw new IllegalStateException("State \"Z\" of the signal cannot have a value")
    def &(s: Signal) = s match {
      case Value(false) => Value (false)
      case _ => Z
    }
    def |(s: Signal) = s match {
      case Value(true) => Value(true)
      case _ => Z
    }
    def ^(s: Signal) = Z
    def unary_! = Z
    override def toString = "Z"
  }
  
  case class Value(sigVal: Boolean) extends Signal {  
    import ImplicitValue._
    
    def value: Boolean = sigVal
    def &(s: Signal) = if (s != Z) sigVal & s.value else Z & this
    def |(s: Signal) = if (s != Z) sigVal | s.value else Z | this
    def ^(s: Signal) = if (s != Z) sigVal ^ s.value else Z ^ this
    def unary_! = !sigVal
    def ==(s: Signal) = s match {
      case Z => false
      case _ => sigVal == s.value
    }
    override def toString = sigVal.toString
  }  
  
  object VCC extends Wire {
  import ImplicitValue._

    override def getSignal = true
    override def <==(s: Signal)  = { throw new IllegalAccessException("Cannot set a signal to the VCC wire") }
  }

  object GND extends Wire {
    import ImplicitValue._

    override def getSignal = false
    override def <==(s: Signal)  = { throw new IllegalAccessException("Cannot set a signal to the GND wire") }
  }
}

object ImplicitValue {
  import Wire._
  
  implicit def apply(sigVal: Boolean): Value = Value(sigVal)
  implicit def unapply(signal: Value): Boolean = signal.value
}
