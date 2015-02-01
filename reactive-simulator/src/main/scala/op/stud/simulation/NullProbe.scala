package op.stud.simulation

trait NullProbe extends Probable {
  self: Simulator =>
  def probeAction(name: String, wire: Wire) {
  }
}