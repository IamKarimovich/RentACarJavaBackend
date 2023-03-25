package FirstSpringBoot.rentACar.businnes.rules;

import FirstSpringBoot.rentACar.core.utilities.exceptions.BusinessExceptions;
import FirstSpringBoot.rentACar.dataAcces.abstracts.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandBusinessRules {

    private BrandRepository brandRepository;

    @Autowired
    public BrandBusinessRules(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public void checkIfBrandNameExists(String name) {
        if(this.brandRepository.existsByName(name))
        {
            throw new BusinessExceptions("Brand name already exists!");
        }
    }


}
