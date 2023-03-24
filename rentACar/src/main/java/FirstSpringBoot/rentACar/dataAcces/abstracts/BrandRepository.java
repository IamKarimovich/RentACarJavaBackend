package FirstSpringBoot.rentACar.dataAcces.abstracts;

import FirstSpringBoot.rentACar.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BrandRepository extends JpaRepository<Brand,Integer> {

}

