package io.tracking.parcel.repository;

import io.tracking.parcel.model.TrackingNumber;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface TrackingNumberRepository extends ReactiveCrudRepository<TrackingNumber, Long> {
    Mono<Boolean> existsByTrackingNumber(String trackingNumber);
}
