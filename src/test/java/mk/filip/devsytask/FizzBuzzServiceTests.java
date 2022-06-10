package mk.filip.devsytask;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FizzBuzzServiceTests {

    @Autowired
    private FizzBuzzService fizzBuzzService;

    @Test
    public void given15_whenFizzBuzzInvoked_thenFizzBuzz() {
        assertEquals("fizzbuzz", fizzBuzzService.fizzBuzz(15));
    }

    @Test
    public void given5_whenFizzBuzzInvoked_thenBuzz() {
        assertEquals("buzz", fizzBuzzService.fizzBuzz(5));
    }

    @Test
    public void given3_whenFizzBuzzInvoked_thenFizz() {
        assertEquals("buzz", fizzBuzzService.fizzBuzz(5));
    }

    @Test
    public void givenNon3Nor5_whenFizzBuzzInvoked_thenEntry() {
        assertEquals("1", fizzBuzzService.fizzBuzz(1));
    }

    @Test
    public void whenGenerateFirst100Invoked_thenListSizeIs100() {
        FizzBuzzListResponse fizzBuzzListResponse = fizzBuzzService.generateFirst100();
        assertEquals(100, fizzBuzzListResponse.getOutput().size());
    }

}
