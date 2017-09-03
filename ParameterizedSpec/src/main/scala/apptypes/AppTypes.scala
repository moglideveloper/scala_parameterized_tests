package apptypes

import model.TestMarker

/**
  * Created by mogli on 9/1/17.
  */
object AppTypes {

  type TM[Z] = TestMarker[Z]
  type Msg = TestMsgWrapper
}

object FunParamTypes{
  //TODO : logic to not pass () for no argument
  //type ZeroParamFun[Z] = (() => Z, ())
  type OneParamFun[A, Z] = (A => Z, A)
  type TwoParamsFun[A, B, Z] = ( (A, B) => Z, A, B)
  type ThreeParamsFun[A, B, C, Z] = ( (A, B, C) => Z, A, B, C)
  type FourParamsFun[A, B, C, D, Z] = ( (A, B, C, D) => Z, A, B, C, D)
  type FiveParamsFun[A, B, C, D, E, Z] = ( (A, B, C, D, E) => Z, A, B, C, D, E)
  type SixParamsFun[A, B, C, D, E, F, Z] = ( (A, B, C, D, E, F) => Z, A, B, C, D, E, F)
  type SevenParamsFun[A, B, C, D, E, F, G, Z] = ( (A, B, C, D, E, F, G) => Z, A, B, C, D, E, F, G)
  type EightParamsFun[A, B, C, D, E, F, G, H, Z] = ( (A, B, C, D, E, F, G, H) => Z, A, B, C, D, E, F, G, H)
  type NineParamsFun[A, B, C, D, E, F, G, H, I, Z] = ( (A, B, C, D, E, F, G, H, I) => Z, A, B, C, D, E, F, G, H, I)
}

case class TestMsgWrapper(prefix : String, suffix : String)