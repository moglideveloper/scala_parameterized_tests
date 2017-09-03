package model

import apptypes.AppTypes.{Msg, TM}

/**
  * Created by mogli on 8/29/17.
  */
sealed trait BodyArgument {
  val testIndex: Int
  val msg: Msg

  def apply(): Unit
}

//TODO : mark this _testIndex, _testMsg as local not member
class ZeroBodyArgument(_testIndex: Int, _testMsg: Msg, body: () => Unit) extends (() => Unit) with BodyArgument {
  val testIndex = _testIndex
  val msg = _testMsg

  override def apply(): Unit = body()
}

//TODO : mark this _testIndex, _testMsg as local not member
class SingleBodyArgument[Z](_testIndex: Int, _testMsg: Msg, body: Z => Unit, t: TM[Z]) extends (() => Unit) with BodyArgument {
  val testIndex = _testIndex
  val msg = _testMsg

  override def apply(): Unit = body(t())
}

//TODO : mark this _testIndex, _testMsg as local not member
class DoubleBodyArgument[Z1, Z2](_testIndex: Int, _testMsg: Msg, body: ((Z1, Z2) => Unit), t1: TM[Z1], t2: TM[Z2]) extends (() => Unit) with BodyArgument {
  val testIndex = _testIndex
  val msg = _testMsg

  override def apply(): Unit = body(t1(), t2())
}

//TODO : mark this _testIndex, _testMsg as local not member
class TripleBodyArgument[Z1, Z2, Z3](_testIndex: Int, _testMsg: Msg, body: ((Z1, Z2, Z3) => Unit), t1: TM[Z1], t2: TM[Z2], t3: TM[Z3]) extends (() => Unit) with BodyArgument {
  val testIndex = _testIndex
  val msg = _testMsg

  override def apply(): Unit = body(t1(), t2(), t3())
}

//TODO : mark this _testIndex, _testMsg as local not member
class QuadrupleBodyArgument[Z1, Z2, Z3, Z4](_testIndex: Int, _testMsg: Msg, body: ((Z1, Z2, Z3, Z4) => Unit), t1: TM[Z1], t2: TM[Z2], t3: TM[Z3], t4 : TM[Z4]) extends (() => Unit) with BodyArgument {
  val testIndex = _testIndex
  val msg = _testMsg

  override def apply(): Unit = body(t1(), t2(), t3(), t4())
}

//TODO : mark this _testIndex, _testMsg as local not member
class QuinBodyArgument[Z1, Z2, Z3, Z4, Z5](_testIndex: Int, _testMsg: Msg, body: ((Z1, Z2, Z3, Z4, Z5) => Unit), t1: TM[Z1], t2: TM[Z2], t3: TM[Z3], t4 : TM[Z4], t5 : TM[Z5]) extends (() => Unit) with BodyArgument {
  val testIndex = _testIndex
  val msg = _testMsg

  override def apply(): Unit = body(t1(), t2(), t3(), t4(), t5())
}

//TODO : mark this _testIndex, _testMsg as local not member
class SexBodyArgument[Z1, Z2, Z3, Z4, Z5, Z6](_testIndex: Int, _testMsg: Msg, body: ((Z1, Z2, Z3, Z4, Z5, Z6) => Unit), t1: TM[Z1], t2: TM[Z2], t3: TM[Z3], t4 : TM[Z4], t5 : TM[Z5], t6 : TM[Z6]) extends (() => Unit) with BodyArgument {
  val testIndex = _testIndex
  val msg = _testMsg

  override def apply(): Unit = body(t1(), t2(), t3(), t4(), t5(), t6())
}

//TODO : mark this _testIndex, _testMsg as local not member
class SepBodyArgument[Z1, Z2, Z3, Z4, Z5, Z6, Z7](_testIndex: Int, _testMsg: Msg, body: ((Z1, Z2, Z3, Z4, Z5, Z6, Z7) => Unit), t1: TM[Z1], t2: TM[Z2], t3: TM[Z3], t4 : TM[Z4], t5 : TM[Z5], t6 : TM[Z6], t7 : TM[Z7]) extends (() => Unit) with BodyArgument {
  val testIndex = _testIndex
  val msg = _testMsg

  override def apply(): Unit = body(t1(), t2(), t3(), t4(), t5(), t6(), t7())
}