package Dispatch_load_balancer.dispatch_load_balancer.dto.response;

import lombok.Data;

@Data
public class ApiResponse {

    private String message;
    private String status;

    public ApiResponse() {
        // default constructor
    }

    public ApiResponse(String message, String status) {
        this.message = message;
        this.status = status;
    }
}

