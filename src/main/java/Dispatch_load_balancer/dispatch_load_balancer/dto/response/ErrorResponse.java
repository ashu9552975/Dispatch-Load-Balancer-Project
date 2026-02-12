package Dispatch_load_balancer.dispatch_load_balancer.dto.response;

import lombok.Data;

import java.util.Map;

@Data
public class ErrorResponse {

    private String status;
    private String message;
    private Map<String, String> fieldErrors;

    public ErrorResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public ErrorResponse(String status, String message, Map<String, String> fieldErrors) {
        this.status = status;
        this.message = message;
        this.fieldErrors = fieldErrors;
    }
}

