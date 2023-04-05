package com.theapeng.Flight.Reservation.System.entity.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class OrderRequestBody {
    private Integer orderId;
    private Integer flightId;
    private Integer customerId;
    private Integer seatNumber;

}
