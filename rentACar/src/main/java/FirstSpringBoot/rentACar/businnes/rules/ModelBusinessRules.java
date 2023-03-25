package FirstSpringBoot.rentACar.businnes.rules;

import FirstSpringBoot.rentACar.core.utilities.exceptions.BusinessExceptions;
import FirstSpringBoot.rentACar.dataAcces.abstracts.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModelBusinessRules {
    private ModelRepository modelRepository;

    @Autowired
    public ModelBusinessRules(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    public void checkIfModelExists(String name)
    {
        if(this.modelRepository.existsByName(name)){
            throw new BusinessExceptions("Model name already exists!");
        }
    }
}
