package com.skillbox.fibonacci;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class FibonacciControllerTest extends PostgresTestContainerInitializer {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private FibonacciRepository repository;

    @LocalServerPort
    private Integer port;

    @Autowired
    private TestRestTemplate template = new TestRestTemplate();

    @BeforeAll
    public static void beforeAll() {
        postgres.start();
    }

    @AfterAll
    public static void afterAll() {
        postgres.stop();
    }

    @BeforeEach
    public void fillingData() {
        FibonacciNumber fibonacciNumber = new FibonacciNumber();
        fibonacciNumber.setId(1);
        fibonacciNumber.setIndex(10);
        fibonacciNumber.setValue(55);
        repository.save(fibonacciNumber);
    }

    @AfterEach
    public void clearDataBase() {
        repository.deleteAll();
    }

    @Test
    @DisplayName("Http-ответ со статусом 'ok'")
    public void givenIndexMoreThanOne_whenGetNumber_thenStatusOk() throws Exception {
        mockMvc.perform(get("/fibonacci/{id}" , 10))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.value").value(55));
    }

    @Test
    @DisplayName("Http-ответ со статусом 'bad request'")
    public void givenIndexLessThanOne_whenGetNumber_thenBAdRequest() throws Exception {
        final String expResult = "Index should be greater or equal to 1";
        mockMvc.perform(get("/fibonacci/{id}" , -1))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(containsString("Index should be greater or equal to 1")));
    }
}
