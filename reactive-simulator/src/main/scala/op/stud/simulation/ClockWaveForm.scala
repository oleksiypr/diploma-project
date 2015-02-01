package op.stud.simulation

trait ClockWaveForm extends WaveForm {
  self: CircuitRun =>  
    
  val CLK: Wire
  val cloackWave: ClockWave
  
  def fill() {   
    val T = cloackWave.T
    val phi0 = cloackWave.phi0
    val dt1 = cloackWave.dt1
    val dt2 = cloackWave.dt2
    
    val n = (end - begin)/T
    val r = end - (phi0 + n*T)
    
    fireEvent(WaveEvent(CLK, begin, phi0 > 0 && phi0 <= dt2))
    fireEvent(WaveEvent(CLK, phi0, false))
    
    for (i <- 0 until n) {
      val t1 = i*T + dt1 + phi0
      if (t1 <= end) fireEvent(WaveEvent(CLK, t1, true))
      
      val t2 = (i + 1)*T + phi0
      if (t2 <= end) fireEvent(WaveEvent(CLK, t2, false))
    }

    fireEvent(WaveEvent(CLK, end, r >= 0 && r < dt1 || r < 0 && -r < dt2))
  }
}