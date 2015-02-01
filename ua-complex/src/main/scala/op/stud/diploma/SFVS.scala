package op.stud.diploma

import op.stud.diploma.Lib._
import op.stud.simulation.Wire
import op.stud.simulation.Wire.VCC
import op.stud.simulation.Wire.GND
import SimulatorImpl.context

object SFVS {
  import IO._
  import InternalWires._
  
  andor(a12, VCC, a13, VCC, VCC, a11, nx4, nx3, NET5235)
  or4(a17, a21, M5, a27, NET3650)
  inv(X2, nx2)
  andor(a6, X1, a26, VCC, VCC, a9, VCC, VCC, NET4054)
  inv(NET4054, M5)
  inv(a26, NET4726)
  inv(NET5235, F1)
  andor(a4, VCC, a25, VCC, VCC, a21, nx3, X4, NET5289)
  inv(NET5289, F2)
  andor(a1, VCC, GND, GND, GND, a3, nx4, nx3, NET5366)
  inv(NET5366, F4)
  andor(a26, VCC, GND, GND, GND, a3, X3, VCC, NET5513)
  inv(NET5513, F7)
  inv(X3, nx3)
  or4(a16, a17, a18, a20, NET5576)
  inv(NET5576, F3)
  or4(a19, a28, GND, GND, NET5631)
  inv(NET5631, F5)
  or4(a9, a25, a27, GND, NET5681)
  inv(NET5681, F6)
  or4(a14, a17, a18, GND, NET5731)
  inv(NET5731, F8)
  or4(a0, a1, a29, GND, NET6672)
  inv(NET6672, y2)
  inv(X4, nx4)
  and4(a21, X3, VCC, VCC, NET6766)
  inv(NET6766, y5)
  andor(a22, X2, a11, nx3, X4, a21, nx3, nx4, NET6803)
  inv(NET6803, y7)
  andor(a11, X3, a11, nx3, nx4, a13, VCC, VCC, NET6913)
  andor(a7, VCC, a22, nx2, VCC, a3, nx3, X4, NET7083)
  and4(NET6913, NET7025, VCC, VCC, y8)
  inv(a9, NET7025)
  inv(NET7083, y9)
  or4(a15, a24, F7, a29, NET7140)
  or4(a19, a22, GND, GND, NET584)
  inv(NET7140, y10)
  andor(a3, nx3, a1, VCC, VCC, a2, VCC, VCC, NET7684)
  or4(a6, a20, F1, F5, NET7686)
  and4(NET7684, NET7686, NET7711, VCC, y12)
  inv(a4, NET7711)
  or4(a16, F8, a29, GND, NET7803)
  inv(NET7803, y13)
  or4(a5, a8, a10, GND, NET7852)
  inv(NET7852, y14)
  andor(F5, VCC, GND, GND, GND, a21, nx3, X4, NET7921)
  and4(NET580, NET584, VCC, VCC, M1)
  inv(NET7921, y15)
  or4(a4, a16, F1, F4, NET7978)
  inv(NET7978, y16)
  andor(a6, VCC, a21, nx3, X4, a3, nx3, X4, NET8047)
  inv(NET8047, y17)
  or4(a10, F5, F6, GND, NET8577)
  or4(a5, a20, a8, F8, NET8361)
  and4(NET8361, NET8369, VCC, VCC, y18)
  inv(a2, NET8369)
  inv(NET8577, y19)
  or4(a14, a15, a16, a18, NET651)
  inv(NET8656, y20)
  and4(a6, X1, VCC, VCC, NET8656)
  or4(a2, a9, a27, F4, NET8689)
  inv(NET8689, y21)
  andor(a18, VCC, a6, nx1, VCC, a3, nx3, X4, NET8758)
  inv(NET8758, y22)
  or4(a16, a23, F2, GND, NET8815)
  inv(NET8815, y23)
  or4(a10, a12, a14, a17, NET8889)
  and4(NET8889, NET8895, VCC, VCC, y24)

  
  val net0, net1 = new Wire
  inv(a0, net0)
  inv(net0, y1)
  
  inv(net0, y11)
  inv(net0, y4)
  
  inv(a1, net1)
  inv(net1, y3)
  inv(net1, y6)
}