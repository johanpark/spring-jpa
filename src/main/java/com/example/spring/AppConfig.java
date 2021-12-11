package com.example.spring;

import com.example.spring.discount.DiscountPolicy;
import com.example.spring.discount.FixDiscountPloicy;
import com.example.spring.discount.RateDiscountPolicy;
import com.example.spring.member.MemberRepository;
import com.example.spring.member.MemberService;
import com.example.spring.member.MemberServiceImpl;
import com.example.spring.member.MemoryMemberRepository;
import com.example.spring.order.OrderService;
import com.example.spring.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
