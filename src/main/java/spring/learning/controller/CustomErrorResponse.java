package spring.learning.controller;

public class CustomErrorResponse {
    private final String message;
    private final long timestamp;

    public CustomErrorResponse(String message) {
        this.message = message;
        this.timestamp = System.currentTimeMillis();
    }

    public String getMessage() {
        return message;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
