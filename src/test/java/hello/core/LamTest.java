package hello.core;

import org.junit.jupiter.api.Test;

public class LamTest {

    @Test
    void test() {

        // 람다사용
        Runnable r1 = () -> System.out.println("Hello World 1");

        // 익명 클래스 사용
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World 2");
            }
        };

        process(r1);

        process(r2);

        // 직접 전달된 람다 표현식으로 출력
        process(() -> System.out.println("Hello world 3"));
    }

    public static void process(Runnable r) {
        r.run();
    }
}
