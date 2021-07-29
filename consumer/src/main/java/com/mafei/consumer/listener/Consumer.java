package com.mafei.consumer.listener;


import com.mafei.bean.CustomMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static com.mafei.properties.Topics.TOPIC1;

@Slf4j
@Component
public class Consumer {

    private int count = 0;

    @KafkaListener(topics = TOPIC1)
    public void singleMessageConsumerWithManualAck(@Payload CustomMessage message, /*Acknowledgment acknowledgment, */
                                                   @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
                                                   @Header(KafkaHeaders.OFFSET) int offset
    ) {
        log.info("Partition: {} message {}", partition, message);
        if (count != offset) {
            System.exit(-1);
        }
        count++;
        /*if (receivedMessagedCount.get() < 1000)
            log.info("Partition: {} receivedMessagedCount:{}", partition, receivedMessagedCount.get());
        consumeMessage(message);*/
//        acknowledgment.acknowledge();
    }
}
