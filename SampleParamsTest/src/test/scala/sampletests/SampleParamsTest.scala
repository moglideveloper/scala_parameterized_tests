package sampletests

import org.scalatest.Matchers._
import paramtest._
import testdata.BasicTestData

/**
  * Created by mogli on 8/21/17.
  */


class SampleParamsTest extends BaseSpec with BasicTestData{

  (1, "even number reminder with 2" will " be 0").with1ƒ (getEven _, ()) { a =>
    (a % 2) should be(0)
  }

  (2, "option even number reminder with 2" will " be 0").with1ƒ (getEven _ andThen (toOption), ()) { a =>
    (a.get % 2) should be(0)
  }

  (3, "a" will "not be equal to b").with1ƒ (oneToTwo _, ()) { case (a, b) =>
    a should not be(b)
  }

  (4, "sum of 4 and 5" will "be 9").with1ƒ (sumOfTwoNumbers _, 4, 5) { x =>
    x should be(9)
  }

  (5, "sum of all optionals" will " be 5").with1ƒ (openOptional _, Option(2), None, None) { a =>
    a should be(5)
  }

  (6, "sum of config optionals" will "be 7").with1ƒ (packedOptional _, Config(Option(4))) { a =>
    a should be(7)
  }

  (7, "even number" will "never be equal to odd").with2ƒ (getEven _, ()) (getOdd _, ()) { case (even, odd) =>
    even should not be (odd)
  }

  val num = number _
  (8, "sum of 3, 5, 7" will "be 15").with3ƒ (num, "3") (num, "5") (num, "7") {case (a, b, c) =>
    (a + b + c) should be (15)
  }

  executeTests()
}