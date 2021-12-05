package com.example.spring.discount;

import com.example.spring.member.Grade;
import com.example.spring.member.Member;

public class FixDiscountPloicy implements DiscountPolicy {
    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
