package com.project.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
public class SeatsDTO {

    private Long seatID;
    private String seatNum;
    private Integer productId;
    private boolean isBooked;

}
