package kafkatests

import java.util
import java.util.Properties

import model.BodyArgument
import net.manub.embeddedkafka.{EmbeddedKafka, EmbeddedKafkaConfig}
import org.apache.kafka.clients.consumer.{ConsumerConfig, KafkaConsumer}
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}
import paramtest.BaseSpec

/**
  * Created by mogli on 9/1/17.
  */
class KafkaSpec extends BaseSpec with EmbeddedKafka {

  implicit val config = EmbeddedKafkaConfig(kafkaPort = 9092, zooKeeperPort = 2181)

  def writeToKafka(topic:String, msgs : Seq[String]) = {
    val props = new Properties()
    props.put("bootstrap.servers", "localhost:9092")
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    val producer = new KafkaProducer[String,String](props)
    for(msg <- msgs) {
      val record = new ProducerRecord[String, String](topic,msg)
      producer.send(record)
    }
  }

  def consumeFromKafka(topic: String): Seq[String] = {
    val props = new Properties()
    props.put("bootstrap.servers", "localhost:9092")
    props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
    props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
    props.put("group.id", "something")
    props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest")

    val consumer: KafkaConsumer[String, String] = new KafkaConsumer[String, String](props)
    consumer.subscribe(util.Collections.singletonList(topic))

    import scala.collection.JavaConverters._

    val records = consumer.poll(5000).asScala.toList.map(_.value())
    records
  }

  override def executeTestBody(body: BodyArgument): Unit = {

    body.msg.prefix should body.msg.suffix in {
      withRunningKafka {
        body()
      }
    }
  }
}
