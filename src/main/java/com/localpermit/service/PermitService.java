package com.localpermit.service;

import com.localpermit.dto.PermitFilterDto;
import com.localpermit.entity.Permit;
import com.localpermit.entity.PermitType;
import com.localpermit.entity.Status;

import java.util.List;
import java.util.Map;

public interface PermitService {

    Permit save(Permit permit);

    Permit findById(Long id);

    List<Permit> findAll();

    void deleteById(Long id);

    List<Permit> findAllFiltered(PermitFilterDto filter);

    Map<String, Map<String, Long>> getDashboardData();
}
