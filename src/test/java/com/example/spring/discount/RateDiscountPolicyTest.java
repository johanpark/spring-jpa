package com.example.spring.discount;

import com.example.spring.member.Grade;
import com.example.spring.member.Member;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



class RateDiscountPolicyTest {
    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10%할인이 적용되어야 한다 >ㅅㅇ")
    void vip_discount() {
        //given
        Member member = new Member(1L, "memberVIP", Grade.VIP);
        //when
        int discount = rateDiscountPolicy.discount(member, 10000);
        //then
        Assertions.assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인 적용이 안되어야한다.")
    void basic_discount() {
        //given
        Member member = new Member(2L, "memberBASIC", Grade.BASIC);
        //when
        int discount = rateDiscountPolicy.discount(member, 10000);
        //then
        Assertions.assertThat(discount).isEqualTo(1000);
    }
}