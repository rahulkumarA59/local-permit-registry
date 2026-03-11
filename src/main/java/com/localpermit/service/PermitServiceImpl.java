package com.localpermit.service;

import com.localpermit.dto.PermitFilterDto;
import com.localpermit.entity.Permit;
import com.localpermit.entity.PermitType;
import com.localpermit.entity.Status;
import com.localpermit.repository.PermitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PermitServiceImpl implements PermitService {

    @Autowired
    private PermitRepository permitRepository;

    @Override
    public Permit save(Permit permit) {
        return permitRepository.save(permit);
    }

    @Override
    public Permit findById(Long id) {
        Optional<Permit> permit = permitRepository.findById(id);
        return permit.orElse(null);
    }

    @Override
    public List<Permit> findAll() {
        return permitRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        permitRepository.deleteById(id);
    }

    @Override
    public List<Permit> findAllFiltered(PermitFilterDto filter) {
        // For simplicity, if all filters are null, return all
        if (filter.getWardOrArea() == null && filter.getPermitType() == null &&
            filter.getStatus() == null && filter.getStartDate() == null && filter.getEndDate() == null) {
            return permitRepository.findAll();
        }
        // Otherwise, use the custom method (assuming all filters are provided; in real app, handle optional filters)
        return permitRepository.findByWardOrAreaAndPermitTypeAndStatusAndApplicationDateBetween(
                filter.getWardOrArea(), filter.getPermitType(), filter.getStatus(),
                filter.getStartDate(), filter.getEndDate());
    }

    @Override
    public Map<String, Map<String, Long>> getDashboardData() {
        List<Object[]> results = permitRepository.findGroupedCounts();
        Map<String, Map<String, Long>> data = new HashMap<>();
        // Initialize all combinations to 0
        for (PermitType type : PermitType.values()) {
            Map<String, Long> statusMap = new HashMap<>();
            for (Status status : Status.values()) {
                statusMap.put(status.name(), 0L);
            }
            data.put(type.name(), statusMap);
        }
        // Update with actual counts
        for (Object[] row : results) {
            PermitType type = (PermitType) row[0];
            Status status = (Status) row[1];
            Long count = (Long) row[2];
            data.get(type.name()).put(status.name(), count);
        }
        return data;
    }
}
