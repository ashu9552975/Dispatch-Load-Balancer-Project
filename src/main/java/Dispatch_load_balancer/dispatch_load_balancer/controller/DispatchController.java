package Dispatch_load_balancer.dispatch_load_balancer.controller;

import Dispatch_load_balancer.dispatch_load_balancer.dto.request.OrderBatchRequest;
import Dispatch_load_balancer.dispatch_load_balancer.dto.request.VehicleBatchRequest;
import Dispatch_load_balancer.dispatch_load_balancer.dto.response.ApiResponse;
import Dispatch_load_balancer.dispatch_load_balancer.dto.response.DispatchPlanResponse;
import Dispatch_load_balancer.dispatch_load_balancer.service.DispatchService;
import Dispatch_load_balancer.dispatch_load_balancer.service.OrderService;
import Dispatch_load_balancer.dispatch_load_balancer.service.VehicleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/dispatch")
@RequiredArgsConstructor
public class DispatchController {

    private final OrderService orderService;
    private final VehicleService vehicleService;
    private final DispatchService dispatchService;


    @PostMapping("/orders")
    public ApiResponse orders(@Valid @RequestBody OrderBatchRequest req) {
        orderService.save(req);
        return new ApiResponse("Delivery orders accepted.", "success");
    }

    @PostMapping("/vehicles")
    public ApiResponse vehicles(@Valid @RequestBody VehicleBatchRequest req) {
        vehicleService.save(req);
        return new ApiResponse("Vehicle details accepted.", "success");
    }

    @GetMapping("/plan")
    public DispatchPlanResponse plan() {
        return dispatchService.generatePlan();
    }
}

