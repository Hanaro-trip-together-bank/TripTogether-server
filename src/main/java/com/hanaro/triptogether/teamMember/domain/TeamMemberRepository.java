package com.hanaro.triptogether.teamMember.domain;

import com.hanaro.triptogether.team.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamMemberRepository extends JpaRepository<TeamMember, Long> {
    List<TeamMember> findTeamMembersByTeam(Team team);
}
