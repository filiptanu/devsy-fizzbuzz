package mk.filip.devsytask;

import org.springframework.stereotype.Service;

@Service
public class FizzBuzzService {

    public String fizzBuzz(int entry) {
        if (entry % 3 == 0 && entry % 5 == 0) {
            return "fizzbuzz";
        } else if (entry % 5 == 0) {
            return "buzz";
        } else if (entry % 3 == 0) {
            return "fizz";
        }
        return String.valueOf(entry);
    }

    public FizzBuzzListResponse generateFirst100() {
        FizzBuzzListResponse fizzBuzzListResponse = new FizzBuzzListResponse();

        for (int i = 1; i <= 100; i++) {
            fizzBuzzListResponse.addFizzBuzzResponse(new FizzBuzzSingleResponse(String.valueOf(i), fizzBuzz(i)));
        }

        return fizzBuzzListResponse;
    }

}
