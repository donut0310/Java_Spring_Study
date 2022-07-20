package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.JdbcTemplateMemberRepository;
import hello.hellospring.repository.JpaMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

/**
 * 직접 자바 코드로 스프링 빈 등록하기
 */
@Configuration
public class SpringConfig {
    @Autowired // 스프링데이터 JPA
    private final MemberRepository memberRepository;
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

//    @Autowired // JPA
//    private EntityManager em;
//    public SpringConfig(EntityManager em) {
//
//        this.em = em;
//    }

    //    private DataSource dataSource; // JdbcTemplate
    //    @Autowired
    //    public SpringConfig(DataSource dataSource) {
    //        this.dataSource = dataSource;
    //    }
    @Bean
    public MemberService memberService(){

//        return new MemberService(memberRepository());
        return new MemberService(memberRepository); // 스프링데이터 JPA
    }
//    @Bean
//    public MemberRepository memberRepository(){

//        return new JdbcTemplateMemberRepository(dataSource); //JdbcTemplate
//        return new JpaMemberRepository(em); // JPA
//    }
}
