package lesson3;

import org.junit.jupiter.api.*;

import java.io.IOException;
import java.util.logging.*;

import static org.junit.jupiter.api.Assertions.*;

class HomeWorkApp3Test {

    private HomeWorkApp3 hwa3;

    protected static final Logger logger1 = Logger.getLogger("HomeWorkApp3Test1");
    protected static final Logger logger2 = Logger.getLogger("HomeWorkApp3Test2");

    @BeforeAll
    static void mainStart() throws IOException {
        Handler handler1 = new FileHandler("src/main/resources/logs/logFromTest1");
        logger1.addHandler(handler1);
        handler1.setFormatter(new SimpleFormatter());
        logger1.info("MAIN START");

        Handler handler2 = new FileHandler("src/main/resources/logs/logFromTest2");
        logger2.addHandler(handler2);
        handler2.setFormatter(new SimpleFormatter());
        logger2.info("MAIN START");
    }

    @AfterAll
    static void mainEnd(){
        logger1.info("MAIN END");
        logger2.info("MAIN END");
    }

    @DisplayName("Тест метода isLeftRightEquals для 1, 4, 5, 2, 9, 3")
    @Test
    void LeftRightEqualsTest1(){
        logger1.info("Begin test1 for isLeftRightEquals()");
        Assertions.assertEquals(true, hwa3.isLeftRightEquals(1, 4, 5, 2, 9, 3));
        logger1.info("End test1");
    }

    @DisplayName("Тест метода isLeftRightEquals для 1, 3, 5, 2, 9, 3")
    @Test
     void LeftRightEqualsTest2(){
        logger1.info("Begin test2 for isLeftRightEquals()");
        Assertions.assertEquals(false, hwa3.isLeftRightEquals(1, 3, 5, 2, 9, 3));
        logger1.info("End test2");
    }

    @DisplayName("Тест метода shiftN для 1, 3, 5, 2, 9, 3")
    @Test
    void shiftNTest(){
        logger2.info("Begin test3 for shiftN()");
        Assertions.assertArrayEquals(new int[]{ 3, 5, 6, 1}, hwa3.shiftN(2, new int[]{6, 1, 3, 5}));
        logger2.info("End test3");
    }

}