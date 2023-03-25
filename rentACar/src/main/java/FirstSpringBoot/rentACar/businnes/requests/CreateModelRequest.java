package FirstSpringBoot.rentACar.businnes.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateModelRequest {

    @NotNull
    @Size(min = 3,max = 20)
    @NotBlank
    private String name;

    @NotNull
    private int brandId;

}
