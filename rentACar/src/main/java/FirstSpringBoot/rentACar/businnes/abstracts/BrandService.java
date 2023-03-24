package FirstSpringBoot.rentACar.businnes.abstracts;

import FirstSpringBoot.rentACar.businnes.requests.CreateBrandRequest;
import FirstSpringBoot.rentACar.businnes.requests.UpdateBrandRequest;
import FirstSpringBoot.rentACar.businnes.responses.GetAllBrandsResponse;
import FirstSpringBoot.rentACar.businnes.responses.GetByIdResponse;

import java.util.List;

public interface BrandService {
    List<GetAllBrandsResponse> getAll();

    GetByIdResponse getById(int id);
    void add(CreateBrandRequest brandRequest);

    void update(UpdateBrandRequest updateBrandRequest);
    void delete(int id);
}
