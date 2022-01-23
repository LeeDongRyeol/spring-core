package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {

    // Ctrl + E -> 과거에 사용한 히스토리 클래스들이 다 나옴

    // 생성자 주입
    // Ctrl + Alt + M => Extract Method
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository(); // DBRepository로 바뀔때 여기만 바꾸면 된다.
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();  // RateDiscountPolicy로 바꿀때 여기만 바꾸면 된다.
    }

    // 메서드를 보면 역할들을 다 알 수 있다.


}
