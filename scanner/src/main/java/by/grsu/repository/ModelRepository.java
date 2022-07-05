package by.grsu.repository;

import by.grsu.model.autoscanner.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {
    @Query("select distinct model " +
            "from Model model " +
            "where model.make.id = :makeId " +
            "order by model.name")
    List<Model> findAllByMakeId(Long makeId);

//    List<Model> findAllByBrand(String brand);
}
