package org.herbal.chem.api.dto.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;
import org.herbal.chem.api.dto.KafkaReply;

public class KafkaReplySerializer implements Serializer<KafkaReply> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public byte[] serialize(String s, KafkaReply kafkaReply) {
        try {
            return objectMapper.writeValueAsBytes(kafkaReply);
        } catch (JsonProcessingException e) {
            throw new SerializationException(e);
        }
    }
}
