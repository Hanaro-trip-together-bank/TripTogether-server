package com.hanaro.triptogether.member.service.impl;

import com.hanaro.triptogether.member.domain.Member;
import com.hanaro.triptogether.member.domain.MemberRepository;
import com.hanaro.triptogether.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    // 간편 로그인
    @Transactional
    @Override
    public String login(Long memberIdx, String memberLoginPw) {
        Member member = memberRepository.findMemberByMemberIdxAndMemberLoginPw(memberIdx, memberLoginPw);

        if (!memberLoginPw.equals(member.getMemberLoginPw())) {
            return "비밀번호가 맞지 않습니다.";
        } else {
            return "로그인이 완료되었습니다!";
        }
    }

}
