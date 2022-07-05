package by.grsu.repository;

import by.grsu.model.autoscanner.Make;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MakeRepository extends JpaRepository<Make, Long> {
//    @Query("select distinct m from Make m left join fetch Model")
//    List<Make> findAll();
}
