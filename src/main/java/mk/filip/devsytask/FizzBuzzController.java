package mk.filip.devsytask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FizzBuzzController {

    @Autowired
    private FizzBuzzService fizzBuzzService;

    @GetMapping("/fizzbuzz")
    public FizzBuzzResponse fizzBuzz(@RequestParam(name="entry") int entry) {
        return fizzBuzzService.fizzBuzz(entry);
    }

    @GetMapping("/manyfizzbuzz")
    public FizzBuzzResponse manyFizzBuzz(@RequestParam(name="entries") List<Integer> entries) {
        return fizzBuzzService.fizzBuzzMany(entries);
    }

}
