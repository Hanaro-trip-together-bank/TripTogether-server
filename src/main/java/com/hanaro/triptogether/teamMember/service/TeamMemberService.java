package com.hanaro.triptogether.teamMember.service;

import com.hanaro.triptogether.teamMember.dto.request.AcceptTeamMemberReqDto;
import com.hanaro.triptogether.teamMember.dto.request.AcceptTeamMembersReqDto;
import com.hanaro.triptogether.teamMember.dto.request.ChangeOwnerReqDto;
import com.hanaro.triptogether.teamMember.dto.request.RejectTeamMembersReqDto;
import com.hanaro.triptogether.teamMember.dto.response.TeamMembersResDto;

import java.util.List;

public interface TeamMemberService {
    // 모임원 전체 출력
    List<TeamMembersResDto> teamMembers(Long teamIdx);

    // 총무 변경
    void changeOwner(ChangeOwnerReqDto changeOwnerReqDto);

    // 모임원 수락 (수락대기-> 모임원으로 상태 변경)
    void acceptTeamMember(AcceptTeamMemberReqDto acceptTeamMemberReqDto);

    // 모임원 전체 수락 (수락대기-> 모임원으로 상태 변경)
    void acceptTeamMembers(AcceptTeamMembersReqDto acceptTeamMembersReqDto);

    // 모임원 거절 (수락대기-> 모임원 삭제)
    // 모임원 내보내기 (모임원-> 모임원 삭제)
    void rejectTeamMember(AcceptTeamMemberReqDto acceptTeamMemberReqDto);

    // 모임원 전체 거절 (수락대기-> 모임원 삭제)
    void rejectTeamMembers(RejectTeamMembersReqDto rejectTeamMembersReqDto);

    // 모임원 전체 내보내기 (모임원-> 모임원 삭제)
    void exportTeamMembers(RejectTeamMembersReqDto rejectTeamMembersReqDto);
}