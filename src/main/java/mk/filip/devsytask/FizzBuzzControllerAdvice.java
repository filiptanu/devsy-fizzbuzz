package mk.filip.devsytask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class FizzBuzzControllerAdvice {

    @Autowired
    private FizzBuzzService fizzBuzzService;

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<FizzBuzzResponse> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException exception) {
        if (exception.getCause() instanceof NumberFormatException) {
            // NOTE (filip): This is a workaround, since there was an overlap between a NuberFormatException and MissingServletRequestParameterException
            if (exception.getMessage().contains("For input string: \"\"")) {
                return new ResponseEntity<>(fizzBuzzService.generateFirst100(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new FizzBuzzErrorResponse("Number format error"), HttpStatus.BAD_REQUEST);
            }
        }

        return new ResponseEntity<>(fizzBuzzService.generateFirst100(), HttpStatus.OK);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<FizzBuzzResponse> handleMissingArgument(MissingServletRequestParameterException exception) {
        return new ResponseEntity<>(fizzBuzzService.generateFirst100(), HttpStatus.OK);
    }

}
