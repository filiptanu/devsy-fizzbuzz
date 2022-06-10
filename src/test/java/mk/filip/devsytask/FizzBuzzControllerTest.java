package mk.filip.devsytask;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class FizzBuzzControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private FizzBuzzController fizzBuzzController;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void given15_whenInvoked_thenFizzBuzz() throws Exception {
        FizzBuzzSingleResponse fizzBuzzSingleResponse = new FizzBuzzSingleResponse("15", "fizzbuzz");
        final String expectedFizzBuzzContent = objectMapper.writeValueAsString(fizzBuzzSingleResponse);

        this.mockMvc.perform(get("/fizzbuzz?entry=15")).andExpect(status().isOk()).andExpect(content().json(expectedFizzBuzzContent));
    }

    @Test
    public void given5_whenInvoked_thenBuzz() throws Exception {
        FizzBuzzSingleResponse fizzBuzzSingleResponse = new FizzBuzzSingleResponse("5", "buzz");
        final String expectedFizzBuzzContent = objectMapper.writeValueAsString(fizzBuzzSingleResponse);

        this.mockMvc.perform(get("/fizzbuzz?entry=5")).andExpect(status().isOk()).andExpect(content().json(expectedFizzBuzzContent));
    }

    @Test
    public void given3_whenInvoked_thenFizz() throws Exception {
        FizzBuzzSingleResponse fizzBuzzSingleResponse = new FizzBuzzSingleResponse("3", "fizz");
        final String expectedFizzBuzzContent = objectMapper.writeValueAsString(fizzBuzzSingleResponse);

        this.mockMvc.perform(get("/fizzbuzz?entry=3")).andExpect(status().isOk()).andExpect(content().json(expectedFizzBuzzContent));
    }

    @Test
    public void givenNon3Nor5_whenInvoked_thenEntry() throws Exception {
        FizzBuzzSingleResponse fizzBuzzSingleResponse = new FizzBuzzSingleResponse("1", "1");
        final String expectedFizzBuzzContent = objectMapper.writeValueAsString(fizzBuzzSingleResponse);

        this.mockMvc.perform(get("/fizzbuzz?entry=1")).andExpect(status().isOk()).andExpect(content().json(expectedFizzBuzzContent));
    }

    @Test
    public void givenParamWithoutValue_whenInvoked_thenGenerateFirst100() throws Exception {
        this.mockMvc.perform(get("/fizzbuzz?entry=")).andExpect(status().isOk()).andExpect(jsonPath("$.output", hasSize(100)));
    }

    @Test
    public void givenMissingParam_whenInvoked_thenGenerateFirst100() throws Exception {
        this.mockMvc.perform(get("/fizzbuzz")).andExpect(status().isOk()).andExpect(jsonPath("$.output", hasSize(100)));
    }

    @Test
    public void givenBadNumberFormat_whenInvoked_thenFizzBuzzError() throws Exception {
        this.mockMvc.perform(get("/fizzbuzz?entry=abc")).andExpect(status().isBadRequest()).andExpect(jsonPath("$.message", is("Number format error")));
    }

}
