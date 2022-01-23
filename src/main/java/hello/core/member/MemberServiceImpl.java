package hello.core.member;

public class MemberServiceImpl implements MemberService{

    // Ctrl + Shift + Enter : 세미콜론까지 완성
    // private final MemberRepository memberRepository = new MemoryMemberRepository();
    private MemberRepository memberRepository;
    //      인터페이스에 의존하는 memberRepository(추상화된) = 구체화된 호출
    // 추상화 구체화 둘다 사용중이므로 좋은 코드가 아니다.
    // 변경 시 문제가 된다. DIP를 위반하고 있는 코드이다.

    public MemberServiceImpl(MemberRepository memberRepository) {
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
}
