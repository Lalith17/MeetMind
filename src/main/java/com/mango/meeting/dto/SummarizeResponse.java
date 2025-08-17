package com.mango.meeting.dto;

import lombok.Data;

@Data
public class SummarizeResponse {
    private String summary;

    public SummarizeResponse(String summary) {
        this.summary = summary;
    }
}
