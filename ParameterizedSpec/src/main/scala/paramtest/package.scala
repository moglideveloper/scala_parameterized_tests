import apptypes.AppTypes.{Msg, TM}
import apptypes.FunParamTypes._
import apptypes.TestMsgWrapper
import model._
import ptest.ParametrizedTest

/**
  * Created by mogli on 9/2/17.
  */
package object paramtest {

  implicit class MsgExtension(indexMsgTuple: (Int, TestMsgWrapper)) extends ParametrizedTest {

    def withNoƒ(body: (() => Unit)) = {
      val testIndex = indexMsgTuple._1
      val msg = indexMsgTuple._2
      pTest(testIndex, msg)(body)
    }

    def with1ƒ[Z1](t1: TM[Z1])(body: ((Z1) => Unit)) = {
      val testIndex = indexMsgTuple._1
      val msg = indexMsgTuple._2
      pTest(testIndex, msg, t1)(body)
    }

    def with2ƒ[Z1, Z2](t1: TM[Z1])(t2: TM[Z2])(body: ((Z1, Z2) => Unit)) = {
      val testIndex = indexMsgTuple._1
      val msg = indexMsgTuple._2
      pTest(testIndex, msg, t1, t2)(body)
    }

    def with3ƒ[Z1, Z2, Z3](t1: TM[Z1])(t2: TM[Z2])(t3: TM[Z3])(body: ((Z1, Z2, Z3) => Unit)) = {
      val testIndex = indexMsgTuple._1
      val msg = indexMsgTuple._2
      pTest(testIndex, msg, t1, t2, t3)(body)
    }

    def with4ƒ[Z1, Z2, Z3, Z4](t1: TM[Z1])(t2: TM[Z2])(t3: TM[Z3])(t4: TM[Z4])(body: ((Z1, Z2, Z3, Z4) => Unit)) = {
      val testIndex = indexMsgTuple._1
      val msg = indexMsgTuple._2
      pTest(testIndex, msg, t1, t2, t3, t4)(body)
    }

    def with5ƒ[Z1, Z2, Z3, Z4, Z5](t1: TM[Z1])(t2: TM[Z2])(t3: TM[Z3])(t4: TM[Z4])(t5: TM[Z5])(body: ((Z1, Z2, Z3, Z4, Z5) => Unit)) = {
      val testIndex = indexMsgTuple._1
      val msg = indexMsgTuple._2
      pTest(testIndex, msg, t1, t2, t3, t4, t5)(body)
    }

    def with6ƒ[Z1, Z2, Z3, Z4, Z5, Z6](t1: TM[Z1])(t2: TM[Z2])(t3: TM[Z3])(t4: TM[Z4])(t5: TM[Z5])(t6: TM[Z6])(body: ((Z1, Z2, Z3, Z4, Z5, Z6) => Unit)) = {
      val testIndex = indexMsgTuple._1
      val msg = indexMsgTuple._2
      pTest(testIndex, msg, t1, t2, t3, t4, t5, t6)(body)
    }

    def with7ƒ[Z1, Z2, Z3, Z4, Z5, Z6, Z7](t1: TM[Z1])(t2: TM[Z2])(t3: TM[Z3])(t4: TM[Z4])(t5: TM[Z5])(t6: TM[Z6])(t7: TM[Z7])(body: ((Z1, Z2, Z3, Z4, Z5, Z6, Z7) => Unit)) = {
      val testIndex = indexMsgTuple._1
      val msg = indexMsgTuple._2
      pTest(testIndex, msg, t1, t2, t3, t4, t5, t6, t7)(body)
    }
  }

  implicit class StringExtension(str: String) {
    def will(suffix: String): Msg = TestMsgWrapper(str, suffix)
  }

  implicit def f[Z](fun: () => Z): ZeroF[Z] = {
    new ZeroF(fun)
  }

  implicit def f[A, Z](param: OneParamFun[A, Z]): OneF[A, Z] = {
    new OneF(param._1, param._2)
  }

  implicit def f[A, B, Z](param: TwoParamsFun[A, B, Z]): TwoF[A, B, Z] = {
    new TwoF(param._1, param._2, param._3)
  }

  implicit def f[A, B, C, Z](param: ThreeParamsFun[A, B, C, Z]): ThreeF[A, B, C, Z] = {
    new ThreeF(param._1, param._2, param._3, param._4)
  }

  implicit def f[A, B, C, D, Z](param: FourParamsFun[A, B, C, D, Z]): FourF[A, B, C, D, Z] = {
    new FourF(param._1, param._2, param._3, param._4, param._5)
  }

  implicit def f[A, B, C, D, E, Z](param: FiveParamsFun[A, B, C, D, E, Z]): FiveF[A, B, C, D, E, Z] = {
    new FiveF(param._1, param._2, param._3, param._4, param._5, param._6)
  }

  implicit def f[A, B, C, D, E, F, Z](param: SixParamsFun[A, B, C, D, E, F, Z]): SixF[A, B, C, D, E, F, Z] = {
    new SixF(param._1, param._2, param._3, param._4, param._5, param._6, param._7)
  }

  implicit def f[A, B, C, D, E, F, G, Z](param: SevenParamsFun[A, B, C, D, E, F, G, Z]): SevenF[A, B, C, D, E, F, G, Z] = {
    new SevenF(param._1, param._2, param._3, param._4, param._5, param._6, param._7, param._8)
  }

  implicit def f[A, B, C, D, E, F, G, H, Z](param: EightParamsFun[A, B, C, D, E, F, G, H, Z]): EightF[A, B, C, D, E, F, G, H, Z] = {
    new EightF(param._1, param._2, param._3, param._4, param._5, param._6, param._7, param._8, param._9)
  }

  implicit def f[A, B, C, D, E, F, G, H, I, Z](param: NineParamsFun[A, B, C, D, E, F, G, H, I, Z]): NineF[A, B, C, D, E, F, G, H, I, Z] = {
    new NineF(param._1, param._2, param._3, param._4, param._5, param._6, param._7, param._8, param._9, param._10)
  }
}