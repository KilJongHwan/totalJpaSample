package com.kh.totaljpaSample.controller;

import com.kh.totaljpaSample.dto.MemberDTO;
import com.kh.totaljpaSample.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.kh.totaljpaSample.utils.Common.CORS_ORIGIN;

@Slf4j  // Log f4
@CrossOrigin(origins = CORS_ORIGIN)
@RequestMapping("/users")
@RequiredArgsConstructor
@RestController
public class MemberController {
    private  final MemberService memberService;
    // 회원 등록
    @PostMapping("/new")
    public ResponseEntity<Boolean> memberRegister(@RequestBody MemberDTO memberDTO){
        boolean isTrue = memberService.saveMember(memberDTO);
        return ResponseEntity.ok(isTrue);
    }
    // 회원 전체 조회
    @GetMapping("/list")
    public ResponseEntity<List<MemberDTO>> memberList(){
        List<MemberDTO> list = memberService.getMemberList();
        return ResponseEntity.ok(list);
    }
    // 회원 상세 조회
    @GetMapping("/detail/{email}")
    public ResponseEntity<MemberDTO> memberDetail(@PathVariable String email){
        MemberDTO memberDTO = memberService.getMemberDetail(email);
        return ResponseEntity.ok(memberDTO);
    }
    // 페이지 네이션 조회
    @GetMapping("/list/page")
    public ResponseEntity<List<MemberDTO>> memberList(@RequestParam(defaultValue = "0") int page,
                                                      @RequestParam(defaultValue = "10") int size){
        List<MemberDTO> list = memberService.getMemberList(page, size);
        return ResponseEntity.ok(list);
    }

    // 총 페이지 수 조회
    @GetMapping("/list/page-cnt")
    public ResponseEntity<Integer> memberPageCount(@RequestParam(defaultValue = "0") int page,
                                                   @RequestParam(defaultValue = "5") int size){
        int pageCnt = memberService.getMemberPage(page, size);
        return  ResponseEntity.ok(pageCnt);
    }
}
