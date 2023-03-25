package FirstSpringBoot.rentACar.businnes.concretes;

import FirstSpringBoot.rentACar.businnes.abstracts.ModelService;
import FirstSpringBoot.rentACar.businnes.requests.CreateModelRequest;
import FirstSpringBoot.rentACar.businnes.responses.GetAllModelsResponse;
import FirstSpringBoot.rentACar.businnes.rules.ModelBusinessRules;
import FirstSpringBoot.rentACar.core.utilities.mappers.ModelMapperService;
import FirstSpringBoot.rentACar.dataAcces.abstracts.ModelRepository;
import FirstSpringBoot.rentACar.entities.concretes.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class ModelManager implements ModelService {

    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;

    private ModelBusinessRules modelBusinessRules;

    @Autowired
    public ModelManager(ModelRepository modelRepository, ModelMapperService modelMapperService, ModelBusinessRules modelBusinessRules) {
        this.modelRepository = modelRepository;
        this.modelMapperService = modelMapperService;
        this.modelBusinessRules = modelBusinessRules;
    }
    @Override
    public List<GetAllModelsResponse> getAll() {
        List<Model> models = modelRepository.findAll();
        List<GetAllModelsResponse> modelsResponses =
                models.stream().map(model -> this.modelMapperService.forResponse().map(model, GetAllModelsResponse.class)).collect(Collectors.toList());
        return modelsResponses;
    }

    @Override
    public void add(CreateModelRequest createModelRequest) {

        this.modelBusinessRules.checkIfModelExists(createModelRequest.getName());
        Model model = modelMapperService.forRequest().map(createModelRequest,Model.class);
        this.modelRepository.save(model);

    }
}
