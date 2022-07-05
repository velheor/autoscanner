package com.autoscanner.repository;

import com.autoscanner.model.autoscanner.Make;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface MakeRepository extends JpaRepository<Make, Long> {
//    @Query("select distinct m from Make m left join fetch Model")
//    List<Make> findAll();
}
