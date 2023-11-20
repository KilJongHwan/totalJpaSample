package com.kh.totaljpaSample.controller;

import com.kh.totaljpaSample.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.kh.totaljpaSample.utils.Common.CORS_ORIGIN;

@Slf4j  // Log f4
@CrossOrigin(origins = CORS_ORIGIN)
@RequestMapping("/users")
@RequiredArgsConstructor
@RestController
public class MemberController {
    private  final MemberService memberService;
}
