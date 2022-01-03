package com.example.spring.autowired;

import com.example.spring.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutoWiredTest {

    @Test
    void AutowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    //자동 주입 대상을 옵션으로 처리하는 방법
    static class TestBean {
        @Autowired(required = false)
        public void setNoBean1(Member member1) {
            System.out.println("member1 = " + member1);
        }
        @Autowired
        public void setNoBean2(@Nullable Member member2) {
            System.out.println("member2 = " + member2);
        }
        @Autowired
        public void setNoBean3(Optional<Member> member3) {
            System.out.println("member3 = " + member3);
        }
    }
}
