package com.example.spring.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class PrototypeTest {
    @Test
    void prototypeBeanFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);

        System.out.println("find PrototypeBean1");
        PrototypeBean prototypeBean1  = ac.getBean(PrototypeBean.class);
        System.out.println("find PrototypeBean2");
        PrototypeBean prototypeBean2  = ac.getBean(PrototypeBean.class);
        System.out.println("prototypeBean1 = " + prototypeBean1);
        System.out.println("prototypeBean2 = " + prototypeBean2);
        Assertions.assertThat(prototypeBean1).isNotSameAs(prototypeBean2);
        ac.close();
        //싱글톤 빈은 스프링 컨테이너 생성 시점에 초기화 메서드가 실행
        //프로토타입 스코프의 빈은 스프링 컨테이너에서 빈을 조회할때 생성되고, 초기화 메서드도 실행된다.

        //싱글톤 빈은 스프링 컨테이너가 관리하기 때문에 스프링 컨테이너가 종료될 때 빈의 종료 메서드가 실행
        //프로토타입 빈은 스프링 컨테이너가 생성과 의존관계 주입 그리고 초기화까지만 관여하고 더는 관리하지 않음
        //프로토타입 빈은 스프링 컨테이너가 종료될 때 @PreDestroy같은 종료 메서드가 실행되지 않음
    }

    @Scope("prototype")
    static class PrototypeBean {
        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean.init");
        }

        @PreDestroy
        public void destory() {
            System.out.println("PrototypeBean.destory");
        }
    }
}
