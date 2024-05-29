package com.hanaro.triptogether.dues.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class DuesAlarmRequestDto {

    private Long teamIdx;
    private BigDecimal duesAmount;
    private List<RequestMemberInfo> memberInfos;

    @Getter
    public static class RequestMemberInfo {
        private Long memberIdx;
        private String fcmToken;
    }
}