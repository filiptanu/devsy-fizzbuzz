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
    public void given15_whenInvoked_thenFizzBuzz() {
        assertEquals("fizzbuzz", fizzBuzzService.fizzBuzz(15));
    }

    @Test
    public void given5_whenInvoked_thenBuzz() {
        assertEquals("buzz", fizzBuzzService.fizzBuzz(5));
    }

    @Test
    public void given3_whenInvoked_thenFizz() {
        assertEquals("buzz", fizzBuzzService.fizzBuzz(5));
    }

    @Test
    public void givenNon3Nor5_whenInvoked_thenEntry() {
        assertEquals("1", fizzBuzzService.fizzBuzz(1));
    }

}
