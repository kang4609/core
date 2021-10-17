package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {
    @Test
    void statefulServiceSingleton() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);


        int price1 = statefulService1.statelessOrder("userA", 10000);
        int price2 = statefulService2.statelessOrder("userB", 20000);

      // int price =  statefulService1.getPrice();
        System.out.println("price1 = " + price1);
        System.out.println("price2 = " + price2);
        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }

    static class  TestConfig {
        @Bean
        public StatefulService statefulService () {
            return new StatefulService();
        }
    }

}