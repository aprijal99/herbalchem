package org.herbal.chem.api.dto;

import org.springframework.http.HttpStatus;

import java.util.Map;

public class KafkaReply {
    private HttpStatus status;
    private String message;
    private Map<String, Object> data;

    public KafkaReply() {
    }

    public KafkaReply(HttpStatus status, String message, Map<String, Object> data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "KafkaReply{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
