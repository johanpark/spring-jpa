package com.example.spring;

import com.example.spring.discount.DiscountPolicy;
import com.example.spring.discount.RateDiscountPolicy;
import com.example.spring.member.MemberRepository;
import com.example.spring.member.MemberService;
import com.example.spring.member.MemberServiceImpl;
import com.example.spring.member.MemoryMemberRepository;
import com.example.spring.order.OrderService;
import com.example.spring.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
