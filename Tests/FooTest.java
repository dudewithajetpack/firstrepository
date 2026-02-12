import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FooTest {

    @Test
    void readFooVar() {
        Foo foo = new Foo();
        assertEquals(1,foo.getFooVar());
    }
}