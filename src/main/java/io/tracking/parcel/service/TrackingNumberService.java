package io.tracking.parcel.service;

import io.tracking.parcel.dto.TrackingNumberRequest;
import io.tracking.parcel.model.TrackingNumber;
import io.tracking.parcel.repository.TrackingNumberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import java.security.SecureRandom;
import java.time.OffsetDateTime;

@Service
@RequiredArgsConstructor
public class TrackingNumberService {

    private final TrackingNumberRepository repository;
    private final SecureRandom random = new SecureRandom();
    private static final int MAX_ATTEMPTS = 5;

    public Mono<TrackingNumber> createTrackingNumber(TrackingNumberRequest request) {
        return tryGenerateUniqueTrackingNumber(request, 0);
    }

    private Mono<TrackingNumber> tryGenerateUniqueTrackingNumber(TrackingNumberRequest request, int attempt) {
        if (attempt >= MAX_ATTEMPTS) {
            return Mono.error(new RuntimeException("Failed to generate unique tracking number after retries"));
        }

        String tracking = generateTracking(request);

        return repository.existsByTrackingNumber(tracking)
                .flatMap(exists -> {
                    if (exists) {
                        return tryGenerateUniqueTrackingNumber(request, attempt + 1);
                    } else {
                        TrackingNumber tn = new TrackingNumber();
                        tn.setTrackingNumber(tracking);
                        tn.setCreatedAt(OffsetDateTime.now());
                        return repository.save(tn);
                    }
                });
    }

    private String generateTracking(TrackingNumberRequest request) {
        String prefix = (request.getOriginCountryId() + request.getDestinationCountryId()).toUpperCase();
        String randomPart = Long.toString(Math.abs(random.nextLong()), 36).toUpperCase();
        String tracking = (prefix + randomPart).replaceAll("[^A-Z0-9]", "");
        return tracking.length() > 16 ? tracking.substring(0, 16) : tracking;
    }
}
