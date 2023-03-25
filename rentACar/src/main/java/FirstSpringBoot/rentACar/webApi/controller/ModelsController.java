package FirstSpringBoot.rentACar.webApi.controller;

import FirstSpringBoot.rentACar.businnes.abstracts.ModelService;
import FirstSpringBoot.rentACar.businnes.requests.CreateModelRequest;
import FirstSpringBoot.rentACar.businnes.responses.GetAllModelsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/models")
public class ModelsController {

    private ModelService modelService;

    @Autowired
    public ModelsController(ModelService modelService) {
        this.modelService = modelService;
    }

    @GetMapping()
    public List<GetAllModelsResponse> getAll()
    {
        return modelService.getAll();
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addModel(@RequestBody @Valid CreateModelRequest createModelRequest)
    {
        this.modelService.add(createModelRequest);
    }
}
