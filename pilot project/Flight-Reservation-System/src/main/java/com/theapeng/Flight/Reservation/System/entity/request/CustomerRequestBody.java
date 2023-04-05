package com.theapeng.Flight.Reservation.System.entity.request;
import lombok.*;

@Builder
@Getter
@Setter
public class CustomerRequestBody {
    private Integer id;
    private String username;
    private String email;
    private String phoneNumber;

}
