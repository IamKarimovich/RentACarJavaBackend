package FirstSpringBoot.rentACar;

import FirstSpringBoot.rentACar.core.utilities.exceptions.BusinessExceptions;
import FirstSpringBoot.rentACar.core.utilities.exceptions.ExceptionDetails;
import FirstSpringBoot.rentACar.core.utilities.exceptions.ValidationExceptionDetails;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@SpringBootApplication
@RestControllerAdvice
public class RentACarApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentACarApplication.class, args);

	}

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ExceptionDetails handleBusinessException(BusinessExceptions businessExceptions)
	{
		ExceptionDetails exceptionDetails = new ExceptionDetails();
		exceptionDetails.setMessage(businessExceptions.getMessage());
		return exceptionDetails;
	}

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ValidationExceptionDetails handleValidationException(MethodArgumentNotValidException methodArgumentNotValidException)
	{
		ValidationExceptionDetails validationExceptionDetails = new ValidationExceptionDetails();
		validationExceptionDetails.setMessage("VALIDATION.ERROR");
		validationExceptionDetails.setValidationProblems(new HashMap<String,String>());

		for (FieldError fieldError: methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
			validationExceptionDetails.getValidationProblems().put(fieldError.getField(),fieldError.getDefaultMessage());
		}

		return validationExceptionDetails;
	}

	@Bean
	public ModelMapper getModelMapper()
	{
		return new ModelMapper();
	}



}
