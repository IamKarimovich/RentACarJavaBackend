package FirstSpringBoot.rentACar.core.utilities.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidationExceptionDetails extends ExceptionDetails{
    private Map<String,String> validationProblems;
}
