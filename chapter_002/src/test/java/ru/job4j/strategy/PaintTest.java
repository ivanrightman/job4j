package ru.job4j.strategy;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.util.StringJoiner;

public class PaintTest {
    @Test
    public void whenDrawSquare() {
        Square square = new Square();
        // получаем ссылку на стандартный вывод в консоль.
        PrintStream stdout = System.out;
        // Создаем буфур для хранения вывода.
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        //Заменяем стандартный вывод на вывод в пямять для тестирования.
        System.setOut(new PrintStream(out));
        // выполняем действия пишушиее в консоль.
        new Paint().draw(square);
        // проверяем результат вычисления
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
        // возвращаем обратно стандартный вывод в консоль.
        System.setOut(stdout);
    }

    @Test
    public void whenDrawTriangle() {
        Triangle triangle = new Triangle();
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
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
        System.setOut(stdout);
    }
}
