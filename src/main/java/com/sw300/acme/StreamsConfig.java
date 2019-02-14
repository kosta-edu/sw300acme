package com.sw300.acme;


import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Profile;

@EnableBinding(Streams.class)
@Profile("event-driven")
public class StreamsConfig {
}
