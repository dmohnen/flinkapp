package com.example.flinkapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.datastream.DataStream;

@SpringBootApplication
public class FlinkApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlinkApplication.class, args);
    }

    @Bean
    public StreamExecutionEnvironment env() {
        return StreamExecutionEnvironment.getExecutionEnvironment();
    }

    @Bean
    public DataStream<String> dataStream(StreamExecutionEnvironment env) {
        // Create a data stream
        return env.fromElements("Hello", "World");
    }

    @Bean
    public DataStream<String> printStream(DataStream<String> dataStream) {
        dataStream.print();
        return dataStream;
    }
}