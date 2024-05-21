package com.hanaro.triptogether.teamMember.controller;

import com.hanaro.triptogether.teamMember.dto.request.AcceptTeamMemberReqDto;
import com.hanaro.triptogether.teamMember.dto.request.ChangeOwnerReqDto;
import com.hanaro.triptogether.teamMember.dto.response.TeamMembersResDto;
import com.hanaro.triptogether.teamMember.service.TeamMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class TeamMemberContoller {
    private final TeamMemberService teamMemberService;

    // 모임원 전체 출력
    @PostMapping("/team")
    public List<TeamMembersResDto> teamMembers(@RequestBody Map<String, Long> teamIdxMap) {
        Long teamIdx = teamIdxMap.get("teamIdx");
        List<TeamMembersResDto> teamMembersResDtos = teamMemberService.teamMembers(teamIdx);

        return teamMembersResDtos;
    }

    // 총무 변경
    @PutMapping("/team/change-owner")
    public void changeOwner(@RequestBody ChangeOwnerReqDto changeOwnerReqDto) {
        teamMemberService.changeOwner(changeOwnerReqDto);
    }

    // 모임원 수락 (수락대기-> 모임원으로 상태 변경)
    @PutMapping("/team/accept-one")
    public void acceptTeamMember(@RequestBody AcceptTeamMemberReqDto acceptTeamMemberReqDto) {
        teamMemberService.acceptTeamMember(acceptTeamMemberReqDto);
    }

    // 모임원 전체 수락 (수락대기-> 모임원으로 상태 변경)
    @PutMapping("/team/accept-all")
    public void acceptTeamMembers(@RequestBody Map<String, Long> teamIdxMap) {
        Long teamIdx = teamIdxMap.get("teamIdx");
        teamMemberService.acceptTeamMembers(teamIdx);
    }

    // 모임원 거절 (수락대기-> 모임원 삭제)
    @PostMapping("/team/reject-one")
    public void rejectTeamMember(@RequestBody AcceptTeamMemberReqDto acceptTeamMemberReqDto) {
        teamMemberService.rejectTeamMember(acceptTeamMemberReqDto);
    }

    // 모임원 전체 거절 (수락대기-> 모임원 삭제)
    @PostMapping("/team/reject-all")
    public void rejectTeamMembers(@RequestBody Map<String, Long> teamIdxMap) {
        Long teamIdx = teamIdxMap.get("teamIdx");
        teamMemberService.rejectTeamMembers(teamIdx);
    }

    // 모임원 내보내기 (모임원-> 모임원 삭제)
    @PostMapping("/team/export-member")
    public void exportTeamMember(@RequestBody AcceptTeamMemberReqDto acceptTeamMemberReqDto) {
        teamMemberService.rejectTeamMember(acceptTeamMemberReqDto);
    }

    // 모임원 전체 내보내기 (모임원-> 모임원 삭제)
    @PostMapping("/team/export-members")
    public void exportTeamMembers(@RequestBody Map<String, Long> teamIdxMap) {
        Long teamIdx = teamIdxMap.get("teamIdx");
        teamMemberService.exportTeamMembers(teamIdx);
    }
}
