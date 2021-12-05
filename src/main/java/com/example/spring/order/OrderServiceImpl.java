package com.example.spring.order;

import com.example.spring.discount.DiscountPolicy;
import com.example.spring.discount.FixDiscountPloicy;
import com.example.spring.member.Member;
import com.example.spring.member.MemberRepository;
import com.example.spring.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPloicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
