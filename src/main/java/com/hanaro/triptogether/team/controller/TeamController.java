package com.hanaro.triptogether.team.controller;

import com.hanaro.triptogether.team.dto.request.AddTeamReqDto;
import com.hanaro.triptogether.team.dto.response.DetailTeamResDto;
import com.hanaro.triptogether.team.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class TeamController {
    private final TeamService teamService;

    // 모임서비스 가입
    @PostMapping("/account/add")
    public void addTeam(@RequestBody AddTeamReqDto addTeamReqDto) {
        teamService.addTeam(addTeamReqDto);
    }

    // 모임서비스 상세
    @PostMapping("/account/detail")
    public DetailTeamResDto detailTeam(@RequestBody Map<String, Long> accIdxMap) {
        Long accIdx = accIdxMap.get("accIdx");
        DetailTeamResDto detailTeamResDto = teamService.detailTeam(accIdx);

        return detailTeamResDto;
    }
}