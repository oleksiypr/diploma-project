package op.stud.simulation

abstract class Simulator extends Probable {
  protected type Agenda = List[WorkItem]
  type Action = () => Unit
  case class WorkItem(time: Int, action: Action)
  
  protected[simulation] var agenda: Agenda = List()
  protected[simulation] var currentTime = 0
  implicit lazy val context = this
  
  def afterDelay(delay: Int)(action: => Unit) {
    val item = WorkItem(currentTime + delay, () => action)
    def insert(ag: Agenda): Agenda =
      if (ag.isEmpty || item.time < ag.head.time) item :: ag
      else ag.head :: insert(ag.tail)
    agenda = insert(agenda)
  }
  
  protected[simulation] def run {
    println("*** New propagation ***")
    while (!agenda.isEmpty) { next }
  } 

  private def next {
    agenda match {
      case List() => {}
      case WorkItem(time, action) :: rest =>
        agenda = rest
        currentTime = time
        action()
    }
  }   
}

trait Probable {
  self: Simulator =>
  protected[simulation] def probeAction(name: String, wire: Wire)
  def probe(name: String, wire: Wire) {
    wire addAction { () =>
      afterDelay(0) { probeAction(name, wire) }
    }
  }
}
