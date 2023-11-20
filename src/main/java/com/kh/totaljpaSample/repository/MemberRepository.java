package com.kh.totaljpaSample.repository;

import com.kh.totaljpaSample.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// 네이밍 규칙에 의해서 API를 작성하면 그에 맞는 쿼리문을 하이버네이트가 구현
public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByEmail(String email);
    Member findByPassword(String pwd);
    Member findByEmailAndPassword(String email, String pwd);
}
