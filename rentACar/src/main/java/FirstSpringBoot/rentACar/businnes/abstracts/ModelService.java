package FirstSpringBoot.rentACar.businnes.abstracts;

import FirstSpringBoot.rentACar.businnes.requests.CreateModelRequest;
import FirstSpringBoot.rentACar.businnes.responses.GetAllModelsResponse;

import java.util.List;

public interface ModelService {
    List<GetAllModelsResponse> getAll();

    void add(CreateModelRequest createModelRequest);
}
