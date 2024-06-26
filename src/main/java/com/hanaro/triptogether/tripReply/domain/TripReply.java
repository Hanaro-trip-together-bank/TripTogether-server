package com.hanaro.triptogether.tripReply.domain;

import com.hanaro.triptogether.teamMember.domain.TeamMember;
import com.hanaro.triptogether.tripPlace.domain.TripPlace;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "trip_reply")
@Getter
@NoArgsConstructor
public class TripReply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tripReplyIdx;

    @ManyToOne
    @JoinColumn(name = "trip_place_idx", nullable = false)
    private TripPlace tripPlace;

    @ManyToOne
    @JoinColumn(name = "team_member_idx", nullable = false)
    private TeamMember teamMember;

    @Column(nullable = false, length = 255)
    private String tripReplyContent;

    @Column(nullable = false)
    private LocalDateTime createdAt;
    private LocalDateTime lastModifiedAt;

    @Builder
    public TripReply(TripPlace tripPlace, TeamMember teamMember, String tripReplyContent) {
        this.tripPlace = tripPlace;
        this.teamMember = teamMember;
        this.tripReplyContent = tripReplyContent;
        this.createdAt = LocalDateTime.now();
    }

    public void update(String tripReplyContent) {
        this.tripReplyContent = tripReplyContent;
        this.lastModifiedAt = LocalDateTime.now();
    }
}
