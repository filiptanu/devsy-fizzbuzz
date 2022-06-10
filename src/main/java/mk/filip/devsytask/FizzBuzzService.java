package mk.filip.devsytask;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class FizzBuzzService {

    public FizzBuzzSingleResponse fizzBuzz(int entry) {
        String stringEntry = String.valueOf(entry);

        if (entry % 3 == 0 && entry % 5 == 0) {
            return new FizzBuzzSingleResponse(stringEntry, "fizzbuzz");
        } else if (entry % 5 == 0) {
            return new FizzBuzzSingleResponse(stringEntry, "buzz");
        } else if (entry % 3 == 0) {
            return new FizzBuzzSingleResponse(stringEntry, "fizz");
        }
        return new FizzBuzzSingleResponse(stringEntry, stringEntry);
    }

    public FizzBuzzListResponse generateFirst100() {
        return fizzBuzzMany(IntStream.rangeClosed(1, 100).boxed().collect(Collectors.toList()));
    }

    public FizzBuzzListResponse fizzBuzzMany(List<Integer> entries) {
        FizzBuzzListResponse fizzBuzzListResponse = new FizzBuzzListResponse();

        for (Integer entry : entries) {
            fizzBuzzListResponse.addFizzBuzzResponse(fizzBuzz(entry));
        }

        return fizzBuzzListResponse;
    }

}
