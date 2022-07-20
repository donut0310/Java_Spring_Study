package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member,Long>, MemberRepository {

    @Override
    Optional<Member> findByName(String name);
    // JPQL => select m from Member m where m.nane = ?
    // 인터페이스 이름을 가지고 JPQL 자동생성
    // 인터페이스를 통한 기본적인 CRUD
} // JpaRepository를 가지고 있으면, 해당 인터페이스가 구현체를 자동으로 만들어 스프링빈에 등록헤준다.
