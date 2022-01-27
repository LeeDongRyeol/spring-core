package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//public class AppConfig {
//
//    // Ctrl + E -> 과거에 사용한 히스토리 클래스들이 다 나옴
//
//    // 생성자 주입
//    // Ctrl + Alt + M => Extract Method
//    public MemberService memberService() {
//        return new MemberServiceImpl(memberRepository());
//    }
//
//    public MemoryMemberRepository memberRepository() {
//        return new MemoryMemberRepository(); // DBRepository로 바뀔때 여기만 바꾸면 된다.
//    }
//
//    public OrderService orderService() {
//        return new OrderServiceImpl(memberRepository(), discountPolicy());
//    }
//
//    public DiscountPolicy discountPolicy() {
////        return new FixDiscountPolicy();
//        return new RateDiscountPolicy();  // RateDiscountPolicy로 바꿀때 여기만 바꾸면 된다.
//    }
//
//    // 메서드를 보면 역할들을 다 알 수 있다.
//}

@Configuration  // : ==> 설정정보
public class AppConfig {

            // Key : memberService , Value : new MemberServiceImpl(memberRepository())
    @Bean   // @Bean 을 붙여주면 스프링 컨테이너에 등록된다.
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository(); // DBRepository로 바뀔때 여기만 바꾸면 된다.
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository()
                                    , discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();  // RateDiscountPolicy로 바꿀때 여기만 바꾸면 된다.
    }
}
