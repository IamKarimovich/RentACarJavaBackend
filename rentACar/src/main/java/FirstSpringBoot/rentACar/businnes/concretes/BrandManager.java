package FirstSpringBoot.rentACar.businnes.concretes;

import FirstSpringBoot.rentACar.businnes.abstracts.BrandService;
import FirstSpringBoot.rentACar.businnes.requests.CreateBrandRequest;
import FirstSpringBoot.rentACar.businnes.responses.GetAllBrandsResponse;
import FirstSpringBoot.rentACar.core.utilities.mappers.ModelMapperService;
import FirstSpringBoot.rentACar.dataAcces.abstracts.BrandRepository;
import FirstSpringBoot.rentACar.entities.concretes.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class BrandManager implements BrandService {

    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;

    @Autowired
    public BrandManager(BrandRepository brandRepository, ModelMapperService modelMapperService) {
        this.brandRepository = brandRepository;
        this.modelMapperService = modelMapperService;
    }




    @Override
    public List<GetAllBrandsResponse> getAll() {

        List<Brand> brands = brandRepository.findAll();

        List<GetAllBrandsResponse> brandsResponses = brands.stream().map
                (brand -> this.modelMapperService.forResponse().map(brand,GetAllBrandsResponse.class)).collect(Collectors.toList());

        return  brandsResponses;

    }

    @Override
    public void add(CreateBrandRequest brandRequest) {
        Brand brand = modelMapperService.forRequest().map(brandRequest,Brand.class);

        this.brandRepository.save(brand);
    }
}
