-------------------------------------------------------------------------------
--
-- Title       : No Title
-- Design      : Mili
-- Author      : Vovik
-- Company     : Konoval
--
-------------------------------------------------------------------------------
--
-- File        : c:\My_Designs\Mili\Mili\compile\Mili_delay.vhd
-- Generated   : Mon May 12 17:52:31 2014
-- From        : c:\My_Designs\Mili\Mili\src\Mili_delay.bde
-- By          : Bde2Vhdl ver. 2.6
--
-------------------------------------------------------------------------------
--
-- Description : 
--
-------------------------------------------------------------------------------
-- Design unit header --
library IEEE;
use IEEE.std_logic_1164.all;


-- other libraries declarations
library DE;
library ELEM;

entity Mili_delay is
  port(
       Clock : in STD_LOGIC;
       Start : in STD_LOGIC;
       X1 : in STD_LOGIC;
       X2 : in STD_LOGIC;
       X3 : in STD_LOGIC;
       X4 : in STD_LOGIC;
       y1 : out STD_LOGIC;
       y10 : out STD_LOGIC;
       y11 : out STD_LOGIC;
       y12 : out STD_LOGIC;
       y13 : out STD_LOGIC;
       y14 : out STD_LOGIC;
       y15 : out STD_LOGIC;
       y16 : out STD_LOGIC;
       y17 : out STD_LOGIC;
       y18 : out STD_LOGIC;
       y19 : out STD_LOGIC;
       y2 : out STD_LOGIC;
       y20 : out STD_LOGIC;
       y21 : out STD_LOGIC;
       y22 : out STD_LOGIC;
       y23 : out STD_LOGIC;
       y24 : out STD_LOGIC;
       y25 : out STD_LOGIC;
       y26 : out STD_LOGIC;
       y27 : out STD_LOGIC;
       y28 : out STD_LOGIC;
       y29 : out STD_LOGIC;
       y3 : out STD_LOGIC;
       y30 : out STD_LOGIC;
       y31 : out STD_LOGIC;
       y32 : out STD_LOGIC;
       y4 : out STD_LOGIC;
       y5 : out STD_LOGIC;
       y6 : out STD_LOGIC;
       y7 : out STD_LOGIC;
       y8 : out STD_LOGIC;
       y9 : out STD_LOGIC
  );
end Mili_delay;

architecture Mili_delay of Mili_delay is

---- Component declarations -----

component de_d
  port (
       C : in STD_LOGIC;
       D : in STD_LOGIC;
       nR : in STD_LOGIC;
       Q : out STD_LOGIC;
       nQ : out STD_LOGIC
  );
end component;
component and4_d
  port (
       In0 : in STD_LOGIC;
       In1 : in STD_LOGIC;
       In2 : in STD_LOGIC;
       In3 : in STD_LOGIC;
       Out0 : out STD_LOGIC
  );
end component;
component andor_d
  port (
       In0 : in STD_LOGIC;
       In1 : in STD_LOGIC;
       In2 : in STD_LOGIC;
       In3 : in STD_LOGIC;
       In4 : in STD_LOGIC;
       In5 : in STD_LOGIC;
       In6 : in STD_LOGIC;
       In7 : in STD_LOGIC;
       Out0 : out STD_LOGIC
  );
end component;
component DC5X32_d
  port (
       D1 : in STD_LOGIC;
       D2 : in STD_LOGIC;
       D3 : in STD_LOGIC;
       D4 : in STD_LOGIC;
       D5 : in STD_LOGIC;
       E : in STD_LOGIC;
       O1 : out STD_LOGIC;
       O10 : out STD_LOGIC;
       O11 : out STD_LOGIC;
       O12 : out STD_LOGIC;
       O13 : out STD_LOGIC;
       O14 : out STD_LOGIC;
       O15 : out STD_LOGIC;
       O16 : out STD_LOGIC;
       O17 : out STD_LOGIC;
       O18 : out STD_LOGIC;
       O19 : out STD_LOGIC;
       O2 : out STD_LOGIC;
       O20 : out STD_LOGIC;
       O21 : out STD_LOGIC;
       O22 : out STD_LOGIC;
       O23 : out STD_LOGIC;
       O24 : out STD_LOGIC;
       O25 : out STD_LOGIC;
       O26 : out STD_LOGIC;
       O27 : out STD_LOGIC;
       O28 : out STD_LOGIC;
       O29 : out STD_LOGIC;
       O3 : out STD_LOGIC;
       O30 : out STD_LOGIC;
       O31 : out STD_LOGIC;
       O32 : out STD_LOGIC;
       O4 : out STD_LOGIC;
       O5 : out STD_LOGIC;
       O6 : out STD_LOGIC;
       O7 : out STD_LOGIC;
       O8 : out STD_LOGIC;
       O9 : out STD_LOGIC
  );
end component;
component inv_d
  port (
       In0 : in STD_LOGIC;
       Out0 : out STD_LOGIC
  );
end component;
component or4_d
  port (
       In0 : in STD_LOGIC;
       In1 : in STD_LOGIC;
       In2 : in STD_LOGIC;
       In3 : in STD_LOGIC;
       Out0 : out STD_LOGIC
  );
end component;

----     Constants     -----
constant VCC_CONSTANT   : STD_LOGIC := '1';
constant GND_CONSTANT   : STD_LOGIC := '0';

---- Signal declarations used on the diagram ----

signal a0 : STD_LOGIC;
signal a1 : STD_LOGIC;
signal a10 : STD_LOGIC;
signal a11 : STD_LOGIC;
signal a12 : STD_LOGIC;
signal a13 : STD_LOGIC;
signal a14 : STD_LOGIC;
signal a15 : STD_LOGIC;
signal a16 : STD_LOGIC;
signal a17 : STD_LOGIC;
signal a18 : STD_LOGIC;
signal a19 : STD_LOGIC;
signal a2 : STD_LOGIC;
signal a20 : STD_LOGIC;
signal a21 : STD_LOGIC;
signal a22 : STD_LOGIC;
signal a23 : STD_LOGIC;
signal a24 : STD_LOGIC;
signal a25 : STD_LOGIC;
signal a26 : STD_LOGIC;
signal a27 : STD_LOGIC;
signal a28 : STD_LOGIC;
signal a29 : STD_LOGIC;
signal a3 : STD_LOGIC;
signal a30 : STD_LOGIC;
signal a31 : STD_LOGIC;
signal a4 : STD_LOGIC;
signal a5 : STD_LOGIC;
signal a6 : STD_LOGIC;
signal a7 : STD_LOGIC;
signal a8 : STD_LOGIC;
signal a9 : STD_LOGIC;
signal C : STD_LOGIC;
signal D1 : STD_LOGIC;
signal D2 : STD_LOGIC;
signal D3 : STD_LOGIC;
signal D4 : STD_LOGIC;
signal D5 : STD_LOGIC;
signal F1 : STD_LOGIC;
signal F2 : STD_LOGIC;
signal F3 : STD_LOGIC;
signal F4 : STD_LOGIC;
signal F5 : STD_LOGIC;
signal F6 : STD_LOGIC;
signal F7 : STD_LOGIC;
signal F8 : STD_LOGIC;
signal GND : STD_LOGIC;
signal M1 : STD_LOGIC;
signal M2 : STD_LOGIC;
signal M3 : STD_LOGIC;
signal M4 : STD_LOGIC;
signal M5 : STD_LOGIC;
signal NET1162 : STD_LOGIC;
signal NET1166 : STD_LOGIC;
signal NET1217 : STD_LOGIC;
signal NET1275 : STD_LOGIC;
signal NET2004 : STD_LOGIC;
signal NET2026 : STD_LOGIC;
signal NET2135 : STD_LOGIC;
signal NET2137 : STD_LOGIC;
signal NET2143 : STD_LOGIC;
signal NET2373 : STD_LOGIC;
signal NET2377 : STD_LOGIC;
signal NET2555 : STD_LOGIC;
signal NET2559 : STD_LOGIC;
signal NET2831 : STD_LOGIC;
signal NET2833 : STD_LOGIC;
signal NET409 : STD_LOGIC;
signal NET411 : STD_LOGIC;
signal NET439 : STD_LOGIC;
signal NET4814 : STD_LOGIC;
signal NET5100 : STD_LOGIC;
signal NET5113 : STD_LOGIC;
signal NET5126 : STD_LOGIC;
signal NET5165 : STD_LOGIC;
signal NET5191 : STD_LOGIC;
signal NET5204 : STD_LOGIC;
signal NET523 : STD_LOGIC;
signal NET525 : STD_LOGIC;
signal NET5308 : STD_LOGIC;
signal NET5334 : STD_LOGIC;
signal NET5347 : STD_LOGIC;
signal NET5360 : STD_LOGIC;
signal NET5408 : STD_LOGIC;
signal NET5482 : STD_LOGIC;
signal NET5517 : STD_LOGIC;
signal NET5530 : STD_LOGIC;
signal NET5543 : STD_LOGIC;
signal NET5556 : STD_LOGIC;
signal NET5569 : STD_LOGIC;
signal NET5582 : STD_LOGIC;
signal NET5604 : STD_LOGIC;
signal NET5617 : STD_LOGIC;
signal NET5630 : STD_LOGIC;
signal NET5643 : STD_LOGIC;
signal NET5656 : STD_LOGIC;
signal NET5678 : STD_LOGIC;
signal NET5691 : STD_LOGIC;
signal NET5717 : STD_LOGIC;
signal NET5748 : STD_LOGIC;
signal NET5761 : STD_LOGIC;
signal NET5774 : STD_LOGIC;
signal NET580 : STD_LOGIC;
signal NET6165 : STD_LOGIC;
signal NET645 : STD_LOGIC;
signal NET647 : STD_LOGIC;
signal NET712 : STD_LOGIC;
signal NET714 : STD_LOGIC;
signal NET784 : STD_LOGIC;
signal NET786 : STD_LOGIC;
signal NET844 : STD_LOGIC;
signal NET846 : STD_LOGIC;
signal NET910 : STD_LOGIC;
signal NET916 : STD_LOGIC;
signal nx1 : STD_LOGIC;
signal nx2 : STD_LOGIC;
signal nx3 : STD_LOGIC;
signal nx4 : STD_LOGIC;
signal Q1 : STD_LOGIC;
signal Q2 : STD_LOGIC;
signal Q3 : STD_LOGIC;
signal Q4 : STD_LOGIC;
signal Q5 : STD_LOGIC;
signal v0 : STD_LOGIC;
signal v5 : STD_LOGIC;
signal VCC : STD_LOGIC;

---- Configuration specifications for declared components 

for U1 : andor_d use entity elem.andor_d;
for U10 : inv_d use entity elem.inv_d;
for U100 : inv_d use entity elem.inv_d;
for U101 : or4_d use entity elem.or4_d;
for U103 : andor_d use entity elem.andor_d;
for U104 : inv_d use entity elem.inv_d;
for U105 : andor_d use entity elem.andor_d;
for U106 : inv_d use entity elem.inv_d;
for U107 : andor_d use entity elem.andor_d;
for U108 : inv_d use entity elem.inv_d;
for U109 : or4_d use entity elem.or4_d;
for U11 : andor_d use entity elem.andor_d;
for U110 : inv_d use entity elem.inv_d;
for U112 : inv_d use entity elem.inv_d;
for U113 : or4_d use entity elem.or4_d;
for U114 : inv_d use entity elem.inv_d;
for U115 : andor_d use entity elem.andor_d;
for U116 : or4_d use entity elem.or4_d;
for U117 : and4_d use entity elem.and4_d;
for U118 : andor_d use entity elem.andor_d;
for U119 : inv_d use entity elem.inv_d;
for U12 : or4_d use entity elem.or4_d;
for U13 : and4_d use entity elem.and4_d;
for U14 : or4_d use entity elem.or4_d;
for U15 : inv_d use entity elem.inv_d;
for U16 : andor_d use entity elem.andor_d;
for U17 : or4_d use entity elem.or4_d;
for U18 : and4_d use entity elem.and4_d;
for U19 : andor_d use entity elem.andor_d;
for U2 : andor_d use entity elem.andor_d;
for U20 : or4_d use entity elem.or4_d;
for U21 : and4_d use entity elem.and4_d;
for U22 : andor_d use entity elem.andor_d;
for U23 : or4_d use entity elem.or4_d;
for U24 : and4_d use entity elem.and4_d;
for U25 : andor_d use entity elem.andor_d;
for U26 : or4_d use entity elem.or4_d;
for U27 : and4_d use entity elem.and4_d;
for U28 : andor_d use entity elem.andor_d;
for U29 : or4_d use entity elem.or4_d;
for U3 : inv_d use entity elem.inv_d;
for U30 : and4_d use entity elem.and4_d;
for U31 : or4_d use entity elem.or4_d;
for U32 : de_d use entity de.de_d;
for U33 : de_d use entity de.de_d;
for U34 : de_d use entity de.de_d;
for U35 : de_d use entity de.de_d;
for U36 : de_d use entity de.de_d;
for U37 : DC5X32_d use entity elem.DC5X32_d;
for U38 : andor_d use entity elem.andor_d;
for U39 : or4_d use entity elem.or4_d;
for U4 : inv_d use entity elem.inv_d;
for U40 : andor_d use entity elem.andor_d;
for U41 : inv_d use entity elem.inv_d;
for U42 : inv_d use entity elem.inv_d;
for U43 : inv_d use entity elem.inv_d;
for U44 : andor_d use entity elem.andor_d;
for U45 : inv_d use entity elem.inv_d;
for U46 : andor_d use entity elem.andor_d;
for U47 : inv_d use entity elem.inv_d;
for U48 : andor_d use entity elem.andor_d;
for U49 : inv_d use entity elem.inv_d;
for U5 : inv_d use entity elem.inv_d;
for U50 : or4_d use entity elem.or4_d;
for U51 : inv_d use entity elem.inv_d;
for U52 : or4_d use entity elem.or4_d;
for U53 : inv_d use entity elem.inv_d;
for U54 : or4_d use entity elem.or4_d;
for U55 : inv_d use entity elem.inv_d;
for U56 : or4_d use entity elem.or4_d;
for U57 : inv_d use entity elem.inv_d;
for U58 : or4_d use entity elem.or4_d;
for U59 : inv_d use entity elem.inv_d;
for U6 : inv_d use entity elem.inv_d;
for U60 : and4_d use entity elem.and4_d;
for U61 : inv_d use entity elem.inv_d;
for U62 : andor_d use entity elem.andor_d;
for U63 : inv_d use entity elem.inv_d;
for U64 : andor_d use entity elem.andor_d;
for U65 : andor_d use entity elem.andor_d;
for U66 : and4_d use entity elem.and4_d;
for U67 : inv_d use entity elem.inv_d;
for U68 : inv_d use entity elem.inv_d;
for U69 : or4_d use entity elem.or4_d;
for U7 : or4_d use entity elem.or4_d;
for U70 : inv_d use entity elem.inv_d;
for U71 : andor_d use entity elem.andor_d;
for U72 : or4_d use entity elem.or4_d;
for U73 : and4_d use entity elem.and4_d;
for U74 : inv_d use entity elem.inv_d;
for U75 : or4_d use entity elem.or4_d;
for U76 : inv_d use entity elem.inv_d;
for U77 : or4_d use entity elem.or4_d;
for U78 : inv_d use entity elem.inv_d;
for U79 : andor_d use entity elem.andor_d;
for U8 : and4_d use entity elem.and4_d;
for U80 : inv_d use entity elem.inv_d;
for U81 : or4_d use entity elem.or4_d;
for U82 : inv_d use entity elem.inv_d;
for U83 : andor_d use entity elem.andor_d;
for U84 : inv_d use entity elem.inv_d;
for U85 : or4_d use entity elem.or4_d;
for U86 : or4_d use entity elem.or4_d;
for U87 : and4_d use entity elem.and4_d;
for U88 : inv_d use entity elem.inv_d;
for U89 : inv_d use entity elem.inv_d;
for U9 : or4_d use entity elem.or4_d;
for U90 : inv_d use entity elem.inv_d;
for U91 : and4_d use entity elem.and4_d;
for U92 : or4_d use entity elem.or4_d;
for U93 : inv_d use entity elem.inv_d;
for U94 : andor_d use entity elem.andor_d;
for U95 : inv_d use entity elem.inv_d;
for U96 : or4_d use entity elem.or4_d;
for U97 : inv_d use entity elem.inv_d;
for U98 : or4_d use entity elem.or4_d;
for U99 : and4_d use entity elem.and4_d;

begin

----  Component instantiations  ----

U1 : andor_d
  port map(
       In0 => a6,
       In1 => nx1,
       In2 => a25,
       In3 => v5,
       In4 => v5,
       In5 => a27,
       In6 => v5,
       In7 => v5,
       Out0 => NET409
  );

U10 : inv_d
  port map(
       In0 => NET439,
       Out0 => M2
  );

U100 : inv_d
  port map(
       In0 => a20,
       Out0 => NET2559
  );

U101 : or4_d
  port map(
       In0 => a0,
       In1 => a1,
       In2 => a29,
       In3 => v0,
       Out0 => NET5643
  );

U103 : andor_d
  port map(
       In0 => a7,
       In1 => v5,
       In2 => a22,
       In3 => nx2,
       In4 => v5,
       In5 => a3,
       In6 => nx3,
       In7 => x4,
       Out0 => NET5408
  );

U104 : inv_d
  port map(
       In0 => NET5717,
       Out0 => y10
  );

U105 : andor_d
  port map(
       In0 => a1,
       In1 => v5,
       In2 => a2,
       In3 => v5,
       In4 => v5,
       In5 => a3,
       In6 => nx3,
       In7 => x4,
       Out0 => NET2831
  );

U106 : inv_d
  port map(
       In0 => a4,
       Out0 => NET2143
  );

U107 : andor_d
  port map(
       In0 => a3,
       In1 => nx3,
       In2 => a1,
       In3 => v5,
       In4 => v5,
       In5 => a2,
       In6 => v5,
       In7 => v5,
       Out0 => NET2135
  );

U108 : inv_d
  port map(
       In0 => NET5748,
       Out0 => y13
  );

U109 : or4_d
  port map(
       In0 => a13,
       In1 => a15,
       In2 => v0,
       In3 => v0,
       Out0 => NET5691
  );

U11 : andor_d
  port map(
       In0 => a11,
       In1 => x3,
       In2 => a12,
       In3 => v5,
       In4 => v5,
       In5 => a13,
       In6 => v5,
       In7 => v5,
       Out0 => NET523
  );

U110 : inv_d
  port map(
       In0 => NET5761,
       Out0 => y14
  );

U112 : inv_d
  port map(
       In0 => NET5482,
       Out0 => y15
  );

U113 : or4_d
  port map(
       In0 => a15,
       In1 => a24,
       In2 => F7,
       In3 => a29,
       Out0 => NET5717
  );

U114 : inv_d
  port map(
       In0 => NET5774,
       Out0 => y16
  );

U115 : andor_d
  port map(
       In0 => F5,
       In1 => v5,
       In2 => v0,
       In3 => v0,
       In4 => v0,
       In5 => a21,
       In6 => nx3,
       In7 => x4,
       Out0 => NET5482
  );

U116 : or4_d
  port map(
       In0 => a6,
       In1 => a20,
       In2 => F1,
       In3 => F5,
       Out0 => NET2137
  );

U117 : and4_d
  port map(
       In0 => NET2831,
       In1 => NET2833,
       In2 => v5,
       In3 => v5,
       Out0 => y32
  );

U118 : andor_d
  port map(
       In0 => a9,
       In1 => v5,
       In2 => a22,
       In3 => nx2,
       In4 => v5,
       In5 => a27,
       In6 => v5,
       In7 => v5,
       Out0 => NET6165
  );

U119 : inv_d
  port map(
       In0 => NET6165,
       Out0 => y31
  );

U12 : or4_d
  port map(
       In0 => a14,
       In1 => a16,
       In2 => a18,
       In3 => a22,
       Out0 => NET525
  );

U13 : and4_d
  port map(
       In0 => NET523,
       In1 => NET525,
       In2 => v5,
       In3 => v5,
       Out0 => M3
  );

U14 : or4_d
  port map(
       In0 => a5,
       In1 => a8,
       In2 => a10,
       In3 => v0,
       Out0 => NET580
  );

U15 : inv_d
  port map(
       In0 => NET580,
       Out0 => M4
  );

U16 : andor_d
  port map(
       In0 => a11,
       In1 => nx3,
       In2 => a15,
       In3 => v5,
       In4 => v5,
       In5 => a17,
       In6 => v5,
       In7 => v5,
       Out0 => NET645
  );

U17 : or4_d
  port map(
       In0 => a21,
       In1 => a23,
       In2 => a24,
       In3 => M1,
       Out0 => NET647
  );

U18 : and4_d
  port map(
       In0 => NET645,
       In1 => NET647,
       In2 => NET1275,
       In3 => v5,
       Out0 => D1
  );

U19 : andor_d
  port map(
       In0 => a3,
       In1 => nx3,
       In2 => a4,
       In3 => v5,
       In4 => v5,
       In5 => a21,
       In6 => nx3,
       In7 => v5,
       Out0 => NET784
  );

U2 : andor_d
  port map(
       In0 => a3,
       In1 => x3,
       In2 => a7,
       In3 => v5,
       In4 => v5,
       In5 => a21,
       In6 => x3,
       In7 => v5,
       Out0 => NET712
  );

U20 : or4_d
  port map(
       In0 => M5,
       In1 => a23,
       In2 => a24,
       In3 => M3,
       Out0 => NET714
  );

U21 : and4_d
  port map(
       In0 => NET712,
       In1 => NET714,
       In2 => v5,
       In3 => v5,
       Out0 => D2
  );

U22 : andor_d
  port map(
       In0 => a1,
       In1 => v5,
       In2 => a3,
       In3 => nx3,
       In4 => nx4,
       In5 => a25,
       In6 => v5,
       In7 => v5,
       Out0 => NET844
  );

U23 : or4_d
  port map(
       In0 => v0,
       In1 => M1,
       In2 => M4,
       In3 => M3,
       Out0 => NET786
  );

U24 : and4_d
  port map(
       In0 => NET784,
       In1 => NET786,
       In2 => v5,
       In3 => v5,
       Out0 => D3
  );

U25 : andor_d
  port map(
       In0 => a3,
       In1 => x3,
       In2 => a3,
       In3 => nx3,
       In4 => nx4,
       In5 => a6,
       In6 => v5,
       In7 => v5,
       Out0 => NET910
  );

U26 : or4_d
  port map(
       In0 => a13,
       In1 => a2,
       In2 => M4,
       In3 => M2,
       Out0 => NET846
  );

U27 : and4_d
  port map(
       In0 => NET844,
       In1 => NET846,
       In2 => v5,
       In3 => NET1217,
       Out0 => D4
  );

U28 : andor_d
  port map(
       In0 => a22,
       In1 => x2,
       In2 => a11,
       In3 => nx3,
       In4 => nx4,
       In5 => a21,
       In6 => nx3,
       In7 => nx4,
       Out0 => NET916
  );

U29 : or4_d
  port map(
       In0 => a24,
       In1 => a26,
       In2 => a0,
       In3 => M2,
       Out0 => NET1166
  );

U3 : inv_d
  port map(
       In0 => x1,
       Out0 => nx1
  );

U30 : and4_d
  port map(
       In0 => NET910,
       In1 => NET916,
       In2 => NET1166,
       In3 => NET1162,
       Out0 => D5
  );

U31 : or4_d
  port map(
       In0 => a2,
       In1 => a4,
       In2 => a18,
       In3 => a12,
       Out0 => NET1162
  );

U32 : de_d
  port map(
       C => C,
       D => D1,
       Q => Q1,
       nR => Start
  );

U33 : de_d
  port map(
       C => C,
       D => D2,
       Q => Q2,
       nR => Start
  );

U34 : de_d
  port map(
       C => C,
       D => D3,
       Q => Q3,
       nR => Start
  );

U35 : de_d
  port map(
       C => C,
       D => D4,
       Q => Q4,
       nR => Start
  );

U36 : de_d
  port map(
       C => C,
       D => D5,
       Q => Q5,
       nR => Start
  );

U37 : DC5X32_d
  port map(
       D1 => Q5,
       D2 => Q4,
       D3 => Q3,
       D4 => Q2,
       D5 => Q1,
       E => v5,
       O1 => a0,
       O10 => a9,
       O11 => a10,
       O12 => a11,
       O13 => a12,
       O14 => a13,
       O15 => a14,
       O16 => a15,
       O17 => a16,
       O18 => a17,
       O19 => a18,
       O2 => a1,
       O20 => a19,
       O21 => a20,
       O22 => a21,
       O23 => a22,
       O24 => a23,
       O25 => a24,
       O26 => a25,
       O27 => a26,
       O28 => a27,
       O29 => a28,
       O3 => a2,
       O30 => a29,
       O31 => a30,
       O32 => a31,
       O4 => a3,
       O5 => a4,
       O6 => a5,
       O7 => a6,
       O8 => a7,
       O9 => a8
  );

U38 : andor_d
  port map(
       In0 => a12,
       In1 => v5,
       In2 => a13,
       In3 => v5,
       In4 => v5,
       In5 => a11,
       In6 => nx4,
       In7 => nx3,
       Out0 => NET5100
  );

U39 : or4_d
  port map(
       In0 => a17,
       In1 => a21,
       In2 => M5,
       In3 => a27,
       Out0 => NET1217
  );

U4 : inv_d
  port map(
       In0 => x2,
       Out0 => nx2
  );

U40 : andor_d
  port map(
       In0 => a6,
       In1 => x1,
       In2 => a26,
       In3 => v5,
       In4 => v5,
       In5 => a9,
       In6 => v5,
       In7 => v5,
       Out0 => NET4814
  );

U41 : inv_d
  port map(
       In0 => NET4814,
       Out0 => M5
  );

U42 : inv_d
  port map(
       In0 => a26,
       Out0 => NET1275
  );

U43 : inv_d
  port map(
       In0 => NET5100,
       Out0 => F1
  );

U44 : andor_d
  port map(
       In0 => a4,
       In1 => v5,
       In2 => a25,
       In3 => v5,
       In4 => v5,
       In5 => a21,
       In6 => nx3,
       In7 => x4,
       Out0 => NET5126
  );

U45 : inv_d
  port map(
       In0 => NET5113,
       Out0 => y17
  );

U46 : andor_d
  port map(
       In0 => a6,
       In1 => v5,
       In2 => a21,
       In3 => nx3,
       In4 => x4,
       In5 => a3,
       In6 => nx3,
       In7 => x4,
       Out0 => NET5113
  );

U47 : inv_d
  port map(
       In0 => NET5126,
       Out0 => F2
  );

U48 : andor_d
  port map(
       In0 => a1,
       In1 => v5,
       In2 => v0,
       In3 => v0,
       In4 => v0,
       In5 => a3,
       In6 => nx4,
       In7 => nx3,
       Out0 => NET5165
  );

U49 : inv_d
  port map(
       In0 => NET5517,
       Out0 => y19
  );

U5 : inv_d
  port map(
       In0 => x3,
       Out0 => nx3
  );

U50 : or4_d
  port map(
       In0 => a2,
       In1 => a9,
       In2 => a27,
       In3 => F4,
       Out0 => NET5543
  );

U51 : inv_d
  port map(
       In0 => NET5530,
       Out0 => y20
  );

U52 : or4_d
  port map(
       In0 => a16,
       In1 => a23,
       In2 => F2,
       In3 => v0,
       Out0 => NET5569
  );

U53 : inv_d
  port map(
       In0 => NET5165,
       Out0 => F4
  );

U54 : or4_d
  port map(
       In0 => a10,
       In1 => a12,
       In2 => a14,
       In3 => a17,
       Out0 => NET2555
  );

U55 : inv_d
  port map(
       In0 => NET5543,
       Out0 => y21
  );

U56 : or4_d
  port map(
       In0 => a5,
       In1 => a8,
       In2 => F5,
       In3 => v0,
       Out0 => NET5617
  );

U57 : inv_d
  port map(
       In0 => NET5191,
       Out0 => y22
  );

U58 : or4_d
  port map(
       In0 => a14,
       In1 => a17,
       In2 => a18,
       In3 => v0,
       Out0 => NET5630
  );

U59 : inv_d
  port map(
       In0 => NET5204,
       Out0 => F7
  );

U6 : inv_d
  port map(
       In0 => x4,
       Out0 => nx4
  );

U60 : and4_d
  port map(
       In0 => a21,
       In1 => x3,
       In2 => v5,
       In3 => v5,
       Out0 => NET5656
  );

U61 : inv_d
  port map(
       In0 => NET5556,
       Out0 => F3
  );

U62 : andor_d
  port map(
       In0 => a26,
       In1 => v5,
       In2 => v0,
       In3 => v0,
       In4 => v0,
       In5 => a3,
       In6 => x3,
       In7 => v5,
       Out0 => NET5204
  );

U63 : inv_d
  port map(
       In0 => NET5569,
       Out0 => y23
  );

U64 : andor_d
  port map(
       In0 => a18,
       In1 => v5,
       In2 => a6,
       In3 => nx1,
       In4 => v5,
       In5 => a3,
       In6 => nx3,
       In7 => x4,
       Out0 => NET5191
  );

U65 : andor_d
  port map(
       In0 => a26,
       In1 => v5,
       In2 => a3,
       In3 => x3,
       In4 => v5,
       In5 => a3,
       In6 => nx3,
       In7 => x4,
       Out0 => NET5308
  );

U66 : and4_d
  port map(
       In0 => NET2004,
       In1 => NET2026,
       In2 => v5,
       In3 => v5,
       Out0 => y8
  );

U67 : inv_d
  port map(
       In0 => NET5582,
       Out0 => F5
  );

U68 : inv_d
  port map(
       In0 => NET5604,
       Out0 => F6
  );

U69 : or4_d
  port map(
       In0 => a7,
       In1 => a24,
       In2 => v0,
       In3 => v0,
       Out0 => NET5678
  );

U7 : or4_d
  port map(
       In0 => a19,
       In1 => a22,
       In2 => v0,
       In3 => v0,
       Out0 => NET411
  );

U70 : inv_d
  port map(
       In0 => NET5630,
       Out0 => F8
  );

U71 : andor_d
  port map(
       In0 => a22,
       In1 => x2,
       In2 => a11,
       In3 => nx3,
       In4 => x4,
       In5 => a21,
       In6 => nx3,
       In7 => nx4,
       Out0 => NET5334
  );

U72 : or4_d
  port map(
       In0 => a14,
       In1 => F3,
       In2 => v0,
       In3 => v0,
       Out0 => NET2833
  );

U73 : and4_d
  port map(
       In0 => NET2135,
       In1 => NET2137,
       In2 => NET2143,
       In3 => v5,
       Out0 => y12
  );

U74 : inv_d
  port map(
       In0 => NET5617,
       Out0 => y25
  );

U75 : or4_d
  port map(
       In0 => a16,
       In1 => F8,
       In2 => a29,
       In3 => v0,
       Out0 => NET5748
  );

U76 : inv_d
  port map(
       In0 => NET5643,
       Out0 => y2
  );

U77 : or4_d
  port map(
       In0 => a5,
       In1 => a8,
       In2 => a10,
       In3 => v0,
       Out0 => NET5761
  );

U78 : inv_d
  port map(
       In0 => NET5308,
       Out0 => y26
  );

U79 : andor_d
  port map(
       In0 => a11,
       In1 => v5,
       In2 => a23,
       In3 => x3,
       In4 => v5,
       In5 => a21,
       In6 => nx3,
       In7 => nx4,
       Out0 => NET5347
  );

U8 : and4_d
  port map(
       In0 => NET409,
       In1 => NET411,
       In2 => v5,
       In3 => v5,
       Out0 => M1
  );

U80 : inv_d
  port map(
       In0 => NET5656,
       Out0 => y5
  );

U81 : or4_d
  port map(
       In0 => a4,
       In1 => a16,
       In2 => F1,
       In3 => F4,
       Out0 => NET5774
  );

U82 : inv_d
  port map(
       In0 => NET5334,
       Out0 => y7
  );

U83 : andor_d
  port map(
       In0 => a11,
       In1 => x3,
       In2 => a11,
       In3 => nx3,
       In4 => nx4,
       In5 => a13,
       In6 => v5,
       In7 => v5,
       Out0 => NET2004
  );

U84 : inv_d
  port map(
       In0 => NET5347,
       Out0 => y27
  );

U85 : or4_d
  port map(
       In0 => a10,
       In1 => F5,
       In2 => F6,
       In3 => v0,
       Out0 => NET5517
  );

U86 : or4_d
  port map(
       In0 => a5,
       In1 => a20,
       In2 => a8,
       In3 => F8,
       Out0 => NET2373
  );

U87 : and4_d
  port map(
       In0 => NET2373,
       In1 => NET2377,
       In2 => v5,
       In3 => v5,
       Out0 => y18
  );

U88 : inv_d
  port map(
       In0 => a2,
       Out0 => NET2377
  );

U89 : inv_d
  port map(
       In0 => NET5360,
       Out0 => y28
  );

U9 : or4_d
  port map(
       In0 => a14,
       In1 => a15,
       In2 => a16,
       In3 => a18,
       Out0 => NET439
  );

U90 : inv_d
  port map(
       In0 => a9,
       Out0 => NET2026
  );

U91 : and4_d
  port map(
       In0 => a6,
       In1 => x1,
       In2 => v5,
       In3 => v5,
       Out0 => NET5530
  );

U92 : or4_d
  port map(
       In0 => a16,
       In1 => a17,
       In2 => a18,
       In3 => a20,
       Out0 => NET5556
  );

U93 : inv_d
  port map(
       In0 => NET5678,
       Out0 => y29
  );

U94 : andor_d
  port map(
       In0 => a10,
       In1 => v5,
       In2 => a22,
       In3 => x2,
       In4 => v5,
       In5 => a6,
       In6 => x1,
       In7 => v5,
       Out0 => NET5360
  );

U95 : inv_d
  port map(
       In0 => NET5691,
       Out0 => y30
  );

U96 : or4_d
  port map(
       In0 => a19,
       In1 => a28,
       In2 => v0,
       In3 => v0,
       Out0 => NET5582
  );

U97 : inv_d
  port map(
       In0 => NET5408,
       Out0 => y9
  );

U98 : or4_d
  port map(
       In0 => a9,
       In1 => a25,
       In2 => a27,
       In3 => v0,
       Out0 => NET5604
  );

U99 : and4_d
  port map(
       In0 => NET2555,
       In1 => NET2559,
       In2 => v5,
       In3 => v5,
       Out0 => y24
  );


---- Power , ground assignment ----

VCC <= VCC_CONSTANT;
GND <= GND_CONSTANT;
v5 <= VCC;
v0 <= GND;

---- Terminal assignment ----

    -- Inputs terminals
	C <= Clock;

    -- Output\buffer terminals
	y1 <= a0;
	y11 <= a0;
	y3 <= a1;
	y4 <= a0;
	y6 <= a1;


end Mili_delay;
