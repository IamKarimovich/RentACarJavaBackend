package FirstSpringBoot.rentACar.dataAcces.abstracts;

import FirstSpringBoot.rentACar.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface BrandRepository extends JpaRepository<Brand,Integer> {


    @Query("select (count(b) > 0) from Brand b where b.name = ?1")
    public boolean existsByName(String name);
}

