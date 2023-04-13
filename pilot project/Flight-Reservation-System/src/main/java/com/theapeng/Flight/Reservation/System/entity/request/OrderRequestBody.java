package com.theapeng.Flight.Reservation.System.entity.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequestBody {
    private Integer id;
    private Integer flightId;
    private Integer seatNumber;

}
