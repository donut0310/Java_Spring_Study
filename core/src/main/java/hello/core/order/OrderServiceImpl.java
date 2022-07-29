package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
//@RequiredArgsConstructor // final이 붙은 필드의 생성자를 만들어주는 lombok 라이브러리
public class OrderServiceImpl implements OrderService{
    /**
     * 현재 클래스(MemberServiceImpl)의
     * 할당하는 부분이 인터페이스와 구현체를 모두 의존 => "DIP 위반"
     * RateDiscountPolicy로 변경하는 순간 OrderServiceImpl(클라이언트) 코드도 함께 변경된다 "OCP 위반"
     * 옳은 방법이 아니다.
     */
//        private final MemberRepository memberRepository = new MemoryMemberRepository();
//        private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//        private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    /**
     * 추상화(인터페이스)에만 의존
     *  생성자를 통해 어떤 구현 객체가 들어올지 알 수 없다
     *  객체 주입은 AppConfig에서 결정된다
     *  의존관계는 AppConfig에서 담당하고, MemberServiceImpl은 실행에만 집중한다
     *  즉, MerberServiceImpl 입장에선 의존관계를 외부에서 주입해주는것과 같다
     *  이를 DI, 의존관계 주입이라고 한다.
     */
    private final DiscountPolicy discountPolicy;
    private final MemberRepository memberRepository;

    @Autowired // 컴포넌트 스캔 사용 시 의존관계 자동 주입, 생성자가 딱 1개라면 생략 가능
//    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy rateDiscountPolicy) { // 1. 여러 빈이 조회될 때, 필드 명으로 빈 이름 설정하여 해결
//    public OrderServiceImpl(MemberRepository memberRepository, @Qualifier("mainDiscountPolicy") DiscountPolicy discountPolicy) { // 2. 여러 빈이 조회될 때, @Qualifier로  해결
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
//        this.discountPolicy = rateDiscountPolicy; 1.
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
