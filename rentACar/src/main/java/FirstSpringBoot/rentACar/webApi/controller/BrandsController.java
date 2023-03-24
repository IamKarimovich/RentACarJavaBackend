package FirstSpringBoot.rentACar.webApi.controller;

import FirstSpringBoot.rentACar.businnes.abstracts.BrandService;
import FirstSpringBoot.rentACar.businnes.requests.CreateBrandRequest;
import FirstSpringBoot.rentACar.businnes.responses.GetAllBrandsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
public class BrandsController {

    private BrandService brandService;
    @Autowired
    public BrandsController(BrandService brandService) {
        this.brandService = brandService;
    }
    @GetMapping()
    public List<GetAllBrandsResponse> getAll()
    {
        return brandService.getAll();
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addBrand(CreateBrandRequest brandRequest){
        brandService.add(brandRequest);
    }

}
