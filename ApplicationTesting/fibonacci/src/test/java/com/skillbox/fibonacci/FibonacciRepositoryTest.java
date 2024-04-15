package com.skillbox.fibonacci;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FibonacciRepositoryTest extends PostgresTestContainerInitializer {

    @Autowired
    FibonacciRepository repository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    EntityManager entityManager;

    private final int expectedIndex = 10;
    private final int expectedValue = 55;

    @BeforeAll
    public static void beforeAll() {
        postgres.start();
    }

    @BeforeEach
    public void fillingDatabase() throws InterruptedException {
        FibonacciNumber fibonacciNumber = new FibonacciNumber(10, 55);
        repository.save(fibonacciNumber);
        entityManager.flush();
        entityManager.detach(fibonacciNumber);
    }

    @AfterAll
    public static void afterAll() {
        postgres.stop();
    }

    @AfterEach()
    public void clearDatabase() {
        repository.deleteAll();
    }

    @Test
    @DisplayName("Новые числа Фибоначчи сохраняются в базу данных")
    public void givenNewIndex_whenFibonacciNumber_thenNewFibonacciNumberSave() {
        List<FibonacciNumber> actual = jdbcTemplate.query(
                "SELECT * FROM fibonacci_number WHERE id = (select  max(id) from fibonacci_number)",
                (rs, rowNum) -> new FibonacciNumber(rs.getInt("index"), rs.getInt("value"))
        );
        assertEquals(1, actual.size());
        assertEquals(expectedIndex, actual.get(0).getIndex());
        assertEquals(expectedValue, actual.get(0).getValue());
    }

    @Test
    @DisplayName("При поиске по индексу возвращается соответствующее число из БД")
    public void givenIndex_whenFibonacciNumber_thenFibonacciNumberFromDatabase() {
        List<FibonacciNumber> actual = jdbcTemplate.query(
                "SELECT * FROM fibonacci_number WHERE index = 10",
                (rs, rowNum) -> new FibonacciNumber(rs.getInt("index"), rs.getInt("value"))
        );
        assertEquals(55, actual.get(0).getValue());
    }

    @Test
    @DisplayName("Не возникает исключений и дубликатов")
    public void givenDuplicateNumber_whenFibonacciNumber_thenNoExceptionsAreThrown() {
        boolean hasException = false;
        try {
            fillingDatabase();
        } catch (Exception ex) {
            hasException = true;
        }

        List<FibonacciNumber> actual = jdbcTemplate.query(
                "SELECT * FROM fibonacci_number WHERE index = 10",
                (rs, rowNum) -> new FibonacciNumber(rs.getInt("index"), rs.getInt("value"))
        );

        assertEquals(1, actual.size());
        assertFalse(hasException);
    }

}
