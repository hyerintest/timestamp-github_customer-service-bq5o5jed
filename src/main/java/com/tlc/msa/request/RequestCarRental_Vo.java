package com.tlc.msa.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "RequestCarRental_Vo DTO")
public class RequestCarRental_Vo {

    @Schema(description = "customerId")
    private String customerId;

    @Schema(description = "carId")
    private String carId;

    @Schema(description = "rentalPeriod")
    private String rentalPeriod;

}