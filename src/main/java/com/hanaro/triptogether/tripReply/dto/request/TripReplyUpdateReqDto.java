package com.hanaro.triptogether.tripReply.dto.request;

import lombok.Getter;

@Getter
public class TripReplyUpdateReqDto {
    private Long team_member_idx;
    private Long trip_reply_idx;
    private String trip_reply_content;
}