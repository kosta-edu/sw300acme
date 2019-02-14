package com.sw300.acme;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface Streams {

    @Output("class-topic")
    MessageChannel outboundChannel();

}
