package io.tracking.parcel.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("tracking_numbers")
public class TrackingNumber {

    @Id
    private Long id;

    private String trackingNumber;

    private OffsetDateTime createdAt;
}
