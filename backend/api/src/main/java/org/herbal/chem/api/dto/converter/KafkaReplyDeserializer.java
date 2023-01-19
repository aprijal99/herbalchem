package org.herbal.chem.api.dto.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;
import org.herbal.chem.api.dto.KafkaReply;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class KafkaReplyDeserializer implements Deserializer<KafkaReply> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public KafkaReply deserialize(String s, byte[] bytes) {
        try {
            return objectMapper.readValue(new String(bytes, StandardCharsets.UTF_8), KafkaReply.class);
        } catch (IOException e) {
            throw new SerializationException(e);
        }
    }
}
