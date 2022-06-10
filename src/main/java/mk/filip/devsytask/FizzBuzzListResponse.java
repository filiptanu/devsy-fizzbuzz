package mk.filip.devsytask;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzzListResponse extends FizzBuzzResponse {

    private List<FizzBuzzSingleResponse> output;

    public FizzBuzzListResponse() {
        output = new ArrayList<>();
    }

    public void addFizzBuzzResponse(FizzBuzzSingleResponse fizzBuzzSingleResponse) {
        output.add(fizzBuzzSingleResponse);
    }

    public List<FizzBuzzSingleResponse> getOutput() {
        return output;
    }
}
