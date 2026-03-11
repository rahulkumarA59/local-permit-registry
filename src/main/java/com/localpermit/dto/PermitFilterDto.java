package com.localpermit.dto;

import com.localpermit.entity.PermitType;
import com.localpermit.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PermitFilterDto {

    private String wardOrArea;
    private PermitType permitType;
    private Status status;
    private LocalDate startDate;
    private LocalDate endDate;
}
