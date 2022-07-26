package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {
    @Test
    void statefulServiceSingleton(){

        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        /**
         * 무상태를 지키지 않은 코드
        //ThreadA: A 사용자 10000원 주문
        statefulService1.order("userA", 10000);
        //ThreadA: B 사용자 20000원 주문
        statefulService2.order("userB", 20000);
         */
        /**
         * 무상태를 지킨 코드
         */
        int userAPrice = statefulService1.order("userA", 10000);
        int userBPrice = statefulService1.order("userB", 20000);

        //ThreadA: 사용자 A 주문 금액 조회
        System.out.println("price = " + userAPrice);

//        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }

    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}