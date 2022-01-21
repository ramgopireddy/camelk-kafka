import org.apache.camel.builder.RouteBuilder;

public class FileToKafka extends RouteBuilder {
  @Override
  public void configure() throws Exception {
  log.info("About to start route: File -> Kafka ");
  from("file://" + "/opt/jboss/container/s2i/core")
  .split(body().convertToString().tokenize("\n"))
    .to("kafka:{{producer.topic}}")
    .log("Message correctly sent to the topic:" +body());
  }
}
