import org.junit.Test
import org.junit.jupiter.api.Assertions

class MyTestClass {
    @Test
    fun test1() {
        Assertions.assertEquals(1, 1)
    }

    @Test
    fun test2() {
        Assertions.assertTrue("pedro" == "PEDRO".lowercase())
    }
}