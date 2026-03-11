package com.localpermit.repository;

import com.localpermit.entity.Permit;
import com.localpermit.entity.PermitType;
import com.localpermit.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PermitRepository extends JpaRepository<Permit, Long> {

    @Query("SELECT p FROM Permit p WHERE p.wardOrArea = ?1 AND p.permitType = ?2 AND p.status = ?3 AND p.applicationDate BETWEEN ?4 AND ?5")
    List<Permit> findByWardOrAreaAndPermitTypeAndStatusAndApplicationDateBetween(
            String wardOrArea,
            PermitType permitType,
            Status status,
            LocalDate startDate,
            LocalDate endDate
    );

    // Custom query for dashboard: group by permitType and status, count
    @Query("SELECT p.permitType, p.status, COUNT(p) FROM Permit p GROUP BY p.permitType, p.status")
    List<Object[]> findGroupedCounts();
}
