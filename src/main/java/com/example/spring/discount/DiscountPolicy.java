package com.example.spring.discount;

import com.example.spring.member.Member;

public interface DiscountPolicy {
    /**
     * 할인 대상 금액
     * @param member
     * @param price
     * @return
     */
    int discount(Member member, int price);
}
