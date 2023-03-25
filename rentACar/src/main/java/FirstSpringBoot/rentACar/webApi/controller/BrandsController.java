package FirstSpringBoot.rentACar.webApi.controller;

import FirstSpringBoot.rentACar.businnes.abstracts.BrandService;
import FirstSpringBoot.rentACar.businnes.requests.CreateBrandRequest;
import FirstSpringBoot.rentACar.businnes.requests.UpdateBrandRequest;
import FirstSpringBoot.rentACar.businnes.responses.GetAllBrandsResponse;
import FirstSpringBoot.rentACar.businnes.responses.GetByIdResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @GetMapping("/{id}")
    public GetByIdResponse getById(@PathVariable int id)
    {
        return brandService.getById(id);
    }

    @PutMapping
    public void update(@RequestBody UpdateBrandRequest brandRequest)
    {
        this.brandService.update(brandRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id)
    {
        this.brandService.delete(id);
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addBrand(@RequestBody @Valid CreateBrandRequest brandRequest){
        brandService.add(brandRequest);
    }

}
