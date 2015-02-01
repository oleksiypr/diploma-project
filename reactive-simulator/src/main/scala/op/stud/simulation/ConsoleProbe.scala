package op.stud.simulation

trait ConsoleProbe extends Probable {
  self: Simulator =>
  def probeAction(name: String, wire: Wire) {
    println("  " + currentTime + ": " + name + " -> " + wire.getSignal)
  }
}