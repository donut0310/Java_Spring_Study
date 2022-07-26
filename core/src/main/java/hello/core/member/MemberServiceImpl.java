package hello.core.member;

public class MemberServiceImpl implements MemberService {
    /**
     * 현재 클래스(MemberServiceImpl)의
     * 할당하는 부분이 인터페이스와 구현체를 모두 의존 => "DIP 위반"
     * 옳은 방법이 아니다.
     */
//      private final MemberRepository memberRepository = new MemoryMemberRepository();

    /**
     * 추상화(인터페이스)에만 의존
     *  생성자를 통해 어떤 구현 객체가 들어올지 알 수 없다
     *  객체 주입은 AppConfig에서 결정된다
     *  의존관계는 AppConfig에서 담당하고, MemberServiceImpl은 실행에만 집중한다
     *  즉, MerberServiceImpl 입장에선 의존관계를 외부에서 주입해주는것과 같다
     *  이를 DI, 의존관계 주입이라고 한다.
     */
    private final MemberRepository memberRepository;
    public MemberServiceImpl(MemberRepository memberRepository) {
        // 생성자 주입, AppConfig에서 관리
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
