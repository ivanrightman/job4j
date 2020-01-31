package ru.job4j.condition;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class MultiMaxTest {
    @Test
    public void whenSecondMax() {
        MultiMax check = new MultiMax();
        int result = check.max(1, 4, 2);
        assertThat(result, is(4));
    }

    @Test
    public void whenFirstMax() {
        MultiMax check = new MultiMax();
        int result = check.max(983, 982, 981);
        assertThat(result, is(983));
    }

    @Test
    public void whenThirdMax() {
        MultiMax check = new MultiMax();
        int result = check.max(123456, 1234567, 12345678);
        assertThat(result, is(12345678));
    }

    @Test
    public void whenAllEqual() {
        MultiMax check = new MultiMax();
        int result = check.max(12345, 12345, 12345);
        assertThat(result, is(12345));
    }
}
