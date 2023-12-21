package Hello.HelloSpring;
//
//import Hello.HelloSpring.repository.MemberRepository;
//import Hello.HelloSpring.service.MemberService;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class SpringConfig {
//    private final MemberRepository memberRepository;
//    public SpringConfig(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }
//    @Bean
//    public MemberService memberService() {
//        return new MemberService(memberRepository);
//    }
//


import Hello.HelloSpring.repository.JpaMemberRepository;
import Hello.HelloSpring.repository.MemberRepository;
import Hello.HelloSpring.repository.MemoryMemberRepository;
import Hello.HelloSpring.service.MemberService;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;


@Configuration
public class SpringConfig {
    //@PersistenceContext
    private final EntityManager em;
    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        //return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource);
        //return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }

}





//private final DataSource dataSource;
//return new MemoryMemberRepository();
//return new JdbcMemberRepository(dataSource);
//return new JdbcTemplateMemberRepository(dataSource);
//package Hello.HelloSpring;
//
//import Hello.HelloSpring.repository.MemberRepository;
//import Hello.HelloSpring.repository.MemoryMemberRepository;
//import Hello.HelloSpring.service.MemberService;
//import org.springframework.context.annotation.Bean;
//
//public class SpringConfig {
//    @Bean
//    public MemberService memberService() {
//        return new MemberService(memberRepository());
//    }
//    @Bean
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }
//}
