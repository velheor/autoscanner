package com.autoscanner.repository;

import com.autoscanner.model.autoscanner.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    @Query("select distinct v from Vehicle v where v.make.id = :makeId order by v.price")
    List<Vehicle> findAllByMakeId(final Long makeId);

    @Query("select distinct v from Vehicle v where v.model.id = :modelId order by v.price")
    List<Vehicle> findAllByModelId(final Long modelId);

    @Query("select distinct v " +
            "from Vehicle v " +
            "where v.make.id = :makeId " +
            "and v.model.id = :modelId " +
            "and v.year between :fromYear and :toYear " +
            "and v.price between :fromPrice and :toPrice")
    List<Vehicle> findByParams(Long makeId, Long modelId, BigDecimal fromPrice, BigDecimal toPrice, Short fromYear, Short toYear);
}
