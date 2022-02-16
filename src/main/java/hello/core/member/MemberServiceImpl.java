package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    // Ctrl + Shift + Enter : 세미콜론까지 완성
    // private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;
    //      인터페이스에 의존하는 memberRepository(추상화된) = 구체화된 호출
    // 추상화 구체화 둘다 사용중이므로 좋은 코드가 아니다.
    // 변경 시 문제가 된다. DIP를 위반하고 있는 코드이다.
    // 지금은 추상화에만 의존하고 있다
    // AppConfig에서 구체화 코드를 의존하게 했기 때문에 OCP와 DIP를 만족하는 코드이다.

                // 마치 ac.getBean(MemberRepository.class)를 넣어주듯이
    @Autowired  // 이걸 생성자에 붙여주면 MemberRepository 타입에 맞는 빈을 알아서 의존성을 주입해준다.
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

    // 테스트 용도
   public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
