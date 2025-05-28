package io.tracking.parcel.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TrackingNumberRequest {

    @NotBlank
    @Pattern(regexp = "^[A-Z]{2}$", message = "origin_country_id must be 2 uppercase letters")
    private String originCountryId;

    @NotBlank
    @Pattern(regexp = "^[A-Z]{2}$", message = "destination_country_id must be 2 uppercase letters")
    private String destinationCountryId;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    private Double weight;

    @NotNull
    private OffsetDateTime createdAt;

    @NotNull
    private UUID customerId;

    @NotBlank
    private String customerName;

    @NotBlank
    private String customerSlug;
}

