package com.hanaro.triptogether.exchangeRate.dto.request;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FcmSendDto {
    private String token;
    private String title;
    private String body;

    @Builder(toBuilder = true)
    public FcmSendDto(String token,String title,String body) {
        this.token = token;
        this.title = title;
        this.body = body;
    }
}
