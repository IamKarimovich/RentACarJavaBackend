package FirstSpringBoot.rentACar.businnes.abstracts;

import FirstSpringBoot.rentACar.businnes.requests.CreateBrandRequest;
import FirstSpringBoot.rentACar.businnes.responses.GetAllBrandsResponse;

import java.util.List;

public interface BrandService {
    List<GetAllBrandsResponse> getAll();

    void add(CreateBrandRequest brandRequest);

}
