package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

/**
 * 애플리케이션의 실제 동작에 필요한 "구현 객체를 생성"
 * 생성한 객체 인스턴스의 참조를 "생성자를 통해서 주입"
 * "DIP 완성"
 * "관심사의 분리" => 객체를 생성하고 연결하는 역할과, 실행하는 역할이 명확히 분리됨
 */
public class AppConfig {
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }
}
