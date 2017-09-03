package ptest

import apptypes.AppTypes.{Msg, TM}
import model._

import scala.collection.mutable.ListBuffer

/**
  * Created by mogli on 8/29/17.
  */

object ParametrizedTest {
  //TODO : either make it synchronize or use some thread safe collection for writes
  val bodyBuffer: ListBuffer[BodyArgument] = ListBuffer()
}

class ParametrizedTest {

  import ParametrizedTest._

  def pTest(testIndex: Int, testMsg: Msg)(body: (() => Unit)): Unit = {
    val singleBody = new ZeroBodyArgument(testIndex, testMsg, body)
    bodyBuffer += singleBody
  }

  def pTest[Z1](testIndex: Int, testMsg: Msg, t1: TM[Z1])(body: ((Z1) => Unit)): Unit = {
    val singleBody = new SingleBodyArgument(testIndex, testMsg, body, t1)
    bodyBuffer += singleBody
  }

  def pTest[Z1, Z2](testIndex: Int, testMsg: Msg, t1: TM[Z1], t2: TM[Z2])(body: ((Z1, Z2) => Unit)): Unit = {
    val doubleBody = new DoubleBodyArgument(testIndex, testMsg, body, t1, t2)
    bodyBuffer += doubleBody
  }

  def pTest[Z1, Z2, Z3](testIndex: Int, testMsg: Msg, t1: TM[Z1], t2: TM[Z2], t3: TM[Z3])(body: ((Z1, Z2, Z3) => Unit)): Unit = {
    val tripleBody = new TripleBodyArgument(testIndex, testMsg, body, t1, t2, t3)
    bodyBuffer += tripleBody
  }

  def pTest[Z1, Z2, Z3, Z4](testIndex: Int, testMsg: Msg, t1: TM[Z1], t2: TM[Z2], t3: TM[Z3], t4: TM[Z4])(body: ((Z1, Z2, Z3, Z4) => Unit)): Unit = {
    val tripleBody = new QuadrupleBodyArgument(testIndex, testMsg, body, t1, t2, t3, t4)
    bodyBuffer += tripleBody
  }

  def pTest[Z1, Z2, Z3, Z4, Z5](testIndex: Int, testMsg: Msg, t1: TM[Z1], t2: TM[Z2], t3: TM[Z3], t4: TM[Z4], t5: TM[Z5])(body: ((Z1, Z2, Z3, Z4, Z5) => Unit)): Unit = {
    val tripleBody = new QuinBodyArgument(testIndex, testMsg, body, t1, t2, t3, t4, t5)
    bodyBuffer += tripleBody
  }

  def pTest[Z1, Z2, Z3, Z4, Z5, Z6](testIndex: Int, testMsg: Msg, t1: TM[Z1], t2: TM[Z2], t3: TM[Z3], t4: TM[Z4], t5: TM[Z5], t6: TM[Z6])(body: ((Z1, Z2, Z3, Z4, Z5, Z6) => Unit)): Unit = {
    val tripleBody = new SexBodyArgument(testIndex, testMsg, body, t1, t2, t3, t4, t5, t6)
    bodyBuffer += tripleBody
  }

  def pTest[Z1, Z2, Z3, Z4, Z5, Z6, Z7](testIndex: Int, testMsg: Msg, t1: TM[Z1], t2: TM[Z2], t3: TM[Z3], t4: TM[Z4], t5: TM[Z5], t6: TM[Z6], t7: TM[Z7])(body: ((Z1, Z2, Z3, Z4, Z5, Z6, Z7) => Unit)): Unit = {
    val tripleBody = new SepBodyArgument(testIndex, testMsg, body, t1, t2, t3, t4, t5, t6, t7)
    bodyBuffer += tripleBody
  }
}