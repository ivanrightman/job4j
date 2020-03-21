package ru.job4j.strategy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class PaintTest {
    // поле содержит дефолтный вывод в консоль.
    private final PrintStream stdout = System.out;
    // буфер для результата.
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    @Test
    public void whenDrawSquare() {
        Square square = new Square();
        // выполняем действия пишушиее в консоль.
        new Paint().draw(square);
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder(System.lineSeparator())
                                .append("++++")
                                .append("+     +")
                                .append("+     +")
                                .append("++++")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    @Test
    public void whenDrawTriangle() {
        Triangle triangle = new Triangle();
        new Paint().draw(triangle);
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder(System.lineSeparator())
                                .append("   x ")
                                .append("  xxx ")
                                .append(" xxxxx ")
                                .append(System.lineSeparator())
                                .toString()

                )
        );
    }
}
