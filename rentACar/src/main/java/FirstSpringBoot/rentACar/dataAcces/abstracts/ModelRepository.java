package FirstSpringBoot.rentACar.dataAcces.abstracts;

import FirstSpringBoot.rentACar.entities.concretes.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ModelRepository extends JpaRepository<Model,Integer> {



    @Query("select (count(m) > 0) from Model m where m.name = ?1")
    boolean existsByName(String name);

}
