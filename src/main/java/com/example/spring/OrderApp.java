package com.example.spring;

import com.example.spring.member.Grade;
import com.example.spring.member.Member;
import com.example.spring.member.MemberService;
import com.example.spring.member.MemberServiceImpl;
import com.example.spring.order.Order;
import com.example.spring.order.OrderService;
import com.example.spring.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

       Order order =  orderService.createOrder(memberId, "itemA", 9000);
        System.out.println("Order= "+order);
        System.out.println("Order.calculatePrice = "+order.calculatePrice());
    }
}
