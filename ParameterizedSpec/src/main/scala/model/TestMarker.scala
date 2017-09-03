package model

import apptypes.AppTypes.TM
import apptypes.FunParamTypes._


/**
  * Created by mogli on 8/29/17.
  */
sealed trait TestMarker[Z] {
  def apply(): Z
}

class ZeroF[Z](val f: () => Z) extends (() => Z) with TM[Z] {
  override def apply(): Z = f()
}

class OneF[A, Z](param : OneParamFun[A, Z]) extends (() => Z) with TM[Z] {
  override def apply(): Z = param._1(param._2)
}

class TwoF[A, B, Z](param : TwoParamsFun[A, B, Z]) extends (() => Z) with TM[Z] {
  override def apply(): Z = param._1(param._2, param._3)
}

class ThreeF[A, B, C, Z](param : ThreeParamsFun[A, B, C, Z]) extends (() => Z) with TM[Z] {
  override def apply(): Z = param._1(param._2, param._3, param._4)
}

class FourF[A, B, C, D, Z](param : FourParamsFun[A, B, C, D, Z]) extends (() => Z) with TM[Z] {
  override def apply(): Z = param._1(param._2, param._3, param._4, param._5)
}

class FiveF[A, B, C, D, E, Z](param : FiveParamsFun[A, B, C, D, E, Z]) extends (() => Z) with TM[Z] {
  override def apply(): Z = param._1(param._2, param._3, param._4, param._5, param._6)
}

class SixF[A, B, C, D, E, F, Z](param : SixParamsFun[A, B, C, D, E, F, Z]) extends (() => Z) with TM[Z] {
  override def apply(): Z = param._1(param._2, param._3, param._4, param._5, param._6, param._7)
}

class SevenF[A, B, C, D, E, F, G, Z](param : SevenParamsFun[A, B, C, D, E, F, G, Z]) extends (() => Z) with TM[Z] {
  override def apply(): Z = param._1(param._2, param._3, param._4, param._5, param._6, param._7, param._8)
}

class EightF[A, B, C, D, E, F, G, H, Z](param : EightParamsFun[A, B, C, D, E, F, G, H, Z]) extends (() => Z) with TM[Z] {
  override def apply(): Z = param._1(param._2, param._3, param._4, param._5, param._6, param._7, param._8, param._9)
}

class NineF[A, B, C, D, E, F, G, H, I, Z](param : NineParamsFun[A, B, C, D, E, F, G, H, I, Z]) extends (() => Z) with TM[Z] {
  override def apply(): Z = param._1(param._2, param._3, param._4, param._5, param._6, param._7, param._8, param._9, param._10)
}