package guru.qa;

import org.junit.jupiter.api.*;

public class SimpleJUnitTest {

    @BeforeAll
    static void beforeAll(){
        System.out.println("### @BeforeAll!!!!!!!!!!!!!!!!!!!!!");
    }
    @AfterAll
    static void afterAll(){
        System.out.println("### @AfterAll!!!!!!!!!!!!!!!!!!!!!");
    }

    @BeforeEach
    void beforEach(){
        System.out.println("### @BeforeEach");
    }

    @AfterEach
    void afterEach(){
        System.out.println("### @AfterEach");
    }


    @Test
    void firstTest() {
        System.out.println("### @Test firstTest");
        Assertions.assertTrue(2 * 2 == 4);
    }
    @Test
    void secondTest() {
        System.out.println("### @Test secondTest");
        Assertions.assertTrue(2 + 2 == 4);
    }

}
