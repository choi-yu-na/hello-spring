package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository{
    @Override
    Optional<Member> findByName(String name);
    /*
    * 위에처럼 써놓으면
    * JPQL이 자동으로 sql을 작성해준다 !! 규칙에 따라서 !!
    * select m form Member m where m.name=?
    *
    * 만약 findByNameAndId(String name, Long Id) 이런식으로 작성했으면
    * 이에 맞춰서 또 자동으로 sql을 작성해 주는것 * */
}
