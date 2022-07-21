package hello.core.member;

public class MemberServiceImpl implements MemberService {
    // 현재 클래스(MemberServiceImpl)의
    // 할당하는 부분이 구현체를 의존, 즉 추상화에도 의존, 구체화에도 의존하기에 옳은 방법이 아니다.
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
