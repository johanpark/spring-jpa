package com.example.spring.singleton;

import com.example.spring.AppConfig;
import com.example.spring.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();

        MemberService memberService = appConfig.memberService();

        MemberService memberService1 = appConfig.memberService();

        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService = " + memberService);

        Assertions.assertThat(memberService).isNotSameAs(memberService1);
    }
}
