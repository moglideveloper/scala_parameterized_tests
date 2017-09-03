package kafkatests

import testdata.BasicTestData
import paramtest._
import scala.util.Random

/**
  * Created by mogli on 9/1/17.
  */
class SampleKafkaTest extends KafkaSpec with BasicTestData {

  val random = Random

  def getValue(u: Unit): Int = {
    random.nextInt(100)
  }

  (1, "test no. 1" will "pass").with1ƒ (getValue _, ()) { x =>

    var i = x
    while (true) {
      i = i + 1
      publishStringMessageToKafka("abcd", i + ". hello from embedded kafka spec")

      Thread.sleep(5678)
    }
  }

  executeTests()
}