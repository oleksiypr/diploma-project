package op.stud.simulation

trait WaveForm {
  self: CircuitRun =>
  import context.run

  protected type Agenda = List[WaveEvent]
  case class WaveEvent(wire: Wire, time: Int, signal: Boolean)
  protected[simulation] var agenda: Agenda = List()
  protected[simulation] def fill: Unit

  def fireEvent(event: WaveEvent) {
    def insert(ag: Agenda): Agenda =
      if (ag.isEmpty || event.time < ag.head.time) event :: ag
      else ag.head :: insert(ag.tail)
    agenda = insert(agenda)
  }

  def process() {
    run
    fill
    while (!agenda.isEmpty) { next }
  }

  private def next {
    import context.currentTime
    import ImplicitValue._
    
    agenda match {
      case List() => {}
      case WaveEvent(wire, time, signal) :: rest =>
        agenda = rest
        currentTime = time
        wire <== signal
        run
    }
  }
}