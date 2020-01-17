package ru.job4j.array;

import com.sun.org.apache.xpath.internal.FoundIndex;
import com.sun.prism.shader.FillRoundRect_Color_Loader;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class FindLoopTest {

    @Test
    public void whenArrayHas5Then0() {
        FindLoop find = new FindLoop();
        int[] data = new int[] {5, 10, 3};
        int el = 5;
        int result = find.indexOf(data, el);
        int expect = 0;
        assertThat(result, is(expect));
    }

    @Test
    public void noElementInArray() {
        FindLoop find = new FindLoop();
        int[] data = new int[] {20, 33, 44};
        int el = 15;
        int result = find.indexOf(data, el);
        int expect = -1;
        assertThat(result, is(expect));
    }

}
