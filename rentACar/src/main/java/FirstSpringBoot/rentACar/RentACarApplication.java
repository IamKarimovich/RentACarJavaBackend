package FirstSpringBoot.rentACar;

import FirstSpringBoot.rentACar.core.utilities.exceptions.BusinessExceptions;
import FirstSpringBoot.rentACar.core.utilities.exceptions.ExceptionDetails;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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

	@Bean
	public ModelMapper getModelMapper()
	{
		return new ModelMapper();
	}



}
