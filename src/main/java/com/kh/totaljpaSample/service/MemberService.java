package com.kh.totaljpaSample.service;

import com.kh.totaljpaSample.dto.MemberDTO;
import com.kh.totaljpaSample.entity.Member;
import com.kh.totaljpaSample.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service    // 해당 객체를 빈으로 등록
@RequiredArgsConstructor // 매개변수가 전부 포함된 생성자를 자동으로 생성
public class MemberService {
    private final MemberRepository memberRepository;
    // 회원 등록
    public boolean saveMember(MemberDTO memberDTO){
        // 이미 등록된 회원인지 확인하는 쿼리
        boolean isReg = memberRepository.existsByEmail(memberDTO.getEmail());
        if (isReg) return false;

        Member member = new Member();
        member.setEmail(memberDTO.getEmail());
        member.setPassword(memberDTO.getPassword());
        member.setName(memberDTO.getName());
        memberRepository.save(member);
        return true;
    }
    // 회원 전체 조회
    public List<MemberDTO> getMemberList(){
        List<MemberDTO> memberDTOS = new ArrayList<>();
        List<Member> members = memberRepository.findAll();
        for (Member member : members) {
            memberDTOS.add(convertEntityToDTO(member));
        }
        return memberDTOS;
    }
    // 회원 상세 조회
    public MemberDTO getMemberDetail(String email) {
        Member member = memberRepository.findByEmail(email)
                .orElseThrow(()-> new RuntimeException("해당 회원이 존재하지않습니다."));
        return convertEntityToDTO(member);
    }
    // 회원 entity를 DTO로 변환하는 메소드
    private MemberDTO convertEntityToDTO(Member member){
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setEmail(member.getEmail());
        memberDTO.setPassword(member.getPassword());
        memberDTO.setName(member.getName());
        memberDTO.setRegDate(member.getRegDate());
        return memberDTO;
    }
}
