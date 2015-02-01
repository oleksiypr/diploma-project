package op.stud.diploma

import op.stud.diploma.Lib._
import op.stud.simulation.Wire
import op.stud.simulation.Wire.VCC
import op.stud.simulation.Wire.GND
import SimulatorImpl.context

object SFVP {
  import IO._
  import InternalWires._
  
  andor(a6, nx1, a25, VCC, VCC, a27, VCC, VCC, NET580)
  inv(NET651, M2)
  inv(a20, NET8895)
  or4(a5, a8, F5, GND, NET8966)
  inv(NET8966, y25)
  andor(a26, VCC, a3, X3, VCC, a3, nx3, X4, NET9034)
  inv(NET9034, y26)
  andor(a11, VCC, a23, X3, VCC, a21, nx3, nx4, NET9113)
  inv(NET9113, y27)
  andor(a10, VCC, a22, X2, VCC, a6, X1, VCC, NET9265)
  inv(NET9265, y28)
  or4(a7, a24, GND, GND, NET9322)
  andor(a11, X3, a12, VCC, VCC, a13, VCC, VCC, NET748)
  inv(NET9322, y29)
  or4(a13, a15, GND, GND, NET9371)
  inv(NET9371, y30)
  andor(a9, VCC, a22, nx2, VCC, a27, VCC, VCC, NET11030)
  inv(NET11030, y31)
  andor(a1, VCC, a2, VCC, VCC, a3, nx3, X4, NET9522)
  or4(a14, F3, GND, GND, NET9524)
  and4(NET9522, NET9524, VCC, VCC, y32)
  or4(a14, a16, a18, a22, NET750)
  and4(NET748, NET750, VCC, VCC, M3)
  or4(a5, a8, a10, GND, NET851)
  inv(NET851, M4)
  andor(a11, nx3, a15, VCC, VCC, a17, VCC, VCC, NET929)
  or4(a21, a23, a24, M1, NET931)
  and4(NET929, NET931, NET4726, VCC, D1)
  andor(a3, X3, a7, VCC, VCC, a21, X3, VCC, NET1070)
  andor(a22, X2, a11, nx3, nx4, a21, nx3, nx4, NET1786)
  or4(M5, a23, a24, M3, NET1072)
  and4(NET1070, NET1072, VCC, VCC, D2)
  andor(a3, nx3, a4, VCC, VCC, a21, nx3, VCC, NET1210)
  or4(GND, M1, M4, M3, NET1212)
  and4(NET1210, NET1212, VCC, VCC, D3)
  andor(a1, VCC, a3, nx3, nx4, a25, VCC, VCC, NET1349)
  or4(a13, a2, M4, M2, NET1351)
  and4(NET1349, NET1351, VCC, NET3650, D4)
  andor(a3, X3, a3, nx3, nx4, a6, VCC, VCC, NET1489)
  or4(a24, a26, a0, M2, NET2626)
  inv(X1, nx1)
  and4(NET1489, NET1786, NET2626, NET2611, D5)
  or4(a2, a4, a18, a12, NET2611)
}
