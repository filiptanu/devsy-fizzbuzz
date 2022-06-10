package mk.filip.devsytask;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FizzBuzzServiceTests {

    @Autowired
    private FizzBuzzService fizzBuzzService;

    @Test
    public void given15_whenFizzBuzzInvoked_thenFizzBuzz() {
        FizzBuzzSingleResponse expectedFizzBuzzSingleResponse = new FizzBuzzSingleResponse("15", "fizzbuzz");
        assertEquals(expectedFizzBuzzSingleResponse, fizzBuzzService.fizzBuzz(15));
    }

    @Test
    public void given5_whenFizzBuzzInvoked_thenBuzz() {
        FizzBuzzSingleResponse expectedFizzBuzzSingleResponse = new FizzBuzzSingleResponse("5", "buzz");
        assertEquals(expectedFizzBuzzSingleResponse, fizzBuzzService.fizzBuzz(5));
    }

    @Test
    public void given3_whenFizzBuzzInvoked_thenFizz() {
        FizzBuzzSingleResponse expectedFizzBuzzSingleResponse = new FizzBuzzSingleResponse("3", "fizz");
        assertEquals(expectedFizzBuzzSingleResponse, fizzBuzzService.fizzBuzz(3));
    }

    @Test
    public void givenNon3Nor5_whenFizzBuzzInvoked_thenEntry() {
        FizzBuzzSingleResponse expectedFizzBuzzSingleResponse = new FizzBuzzSingleResponse("1", "1");
        assertEquals(expectedFizzBuzzSingleResponse, fizzBuzzService.fizzBuzz(1));
    }

    @Test
    public void whenGenerateFirst100Invoked_thenListSizeIs100() {
        FizzBuzzListResponse fizzBuzzListResponse = fizzBuzzService.generateFirst100();
        assertEquals(100, fizzBuzzListResponse.getOutput().size());
    }

    @Test
    public void givenAListOfIntegers_whenfizzBuzzManyInvoked_thenListSizeIsSameAsInputListSize() {
        FizzBuzzListResponse fizzBuzzListResponse = fizzBuzzService.fizzBuzzMany(Arrays.asList(1, 2, 3, 4, 5));
        assertEquals(5, fizzBuzzListResponse.getOutput().size());
    }

}
