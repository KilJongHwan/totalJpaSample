package com.kh.totaljpaSample.service;

import com.kh.totaljpaSample.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service    // 해당 객체를 빈으로 등록
@RequiredArgsConstructor // 매개변수가 전부 포함된 생성자를 자동으로 생성
public class MemberService {
    private final MemberRepository memberRepository;
}
