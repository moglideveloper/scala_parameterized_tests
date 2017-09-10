package kafkatests

import org.scalatest.Matchers._
import paramtest._
import testdata.BasicTestData

import scala.util.Random

/**
  * Created by mogli on 9/1/17.
  */
class SampleKafkaTest extends KafkaSpec with BasicTestData {

  val random = Random

  def getValue(count: Int): Seq[String] = {
    val msgs = for (i <- 1 to count) yield "msg no. " + i
    msgs
  }

  (1, "test no. 1" will "pass").with1ƒ(getValue _, 3) { msgs =>

    writeToKafka("test", msgs)
    Thread.sleep(3210)
    val responseMsgs = consumeFromKafka("test")
    responseMsgs foreach println
    msgs should be(responseMsgs)
  }

  executeTests()
}