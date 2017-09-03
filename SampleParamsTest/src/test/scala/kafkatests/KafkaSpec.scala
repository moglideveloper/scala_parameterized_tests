package kafkatests

import model.BodyArgument
import net.manub.embeddedkafka.{EmbeddedKafka, EmbeddedKafkaConfig}
import paramtest.BaseSpec

/**
  * Created by mogli on 9/1/17.
  */
class KafkaSpec extends BaseSpec with EmbeddedKafka {

  implicit val config = EmbeddedKafkaConfig(kafkaPort = 9092, zooKeeperPort = 2181)

  override def executeTestBody(body: BodyArgument): Unit = {

    body.msg.prefix should body.msg.suffix in {
      withRunningKafka {
        body()
      }
    }
  }
}
