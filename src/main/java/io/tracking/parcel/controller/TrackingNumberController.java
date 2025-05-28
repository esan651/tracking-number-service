package io.tracking.parcel.controller;

import io.tracking.parcel.dto.TrackingNumberRequest;
import io.tracking.parcel.service.TrackingNumberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import java.util.Map;

@RestController
@RequestMapping(path = "${tracking.service.prefix}/next-tracking-number")
@RequiredArgsConstructor
@Slf4j
public class TrackingNumberController {

    private final TrackingNumberService trackingNumberService;

    @GetMapping
    public Mono<ResponseEntity<Map<String, Object>>> getTrackingNumber(@Valid TrackingNumberRequest request) {
        return trackingNumberService.createTrackingNumber(request)
                .map(tn -> ResponseEntity.ok(Map.of(
                        "tracking_number", tn.getTrackingNumber(),
                        "created_at", tn.getCreatedAt().toString()
                )));
    }
}
