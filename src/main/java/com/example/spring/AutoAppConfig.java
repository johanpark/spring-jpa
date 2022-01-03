package com.example.spring;

import com.example.spring.member.MemberRepository;
import com.example.spring.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)   //Configuration붙은 다른곳에 자동으로 등록되기때문에 작성
public class AutoAppConfig {

/*    @Bean(name= "memoryMemberRepository")
    MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }*/
}
