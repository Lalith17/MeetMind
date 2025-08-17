package com.mango.meeting.dto;

import lombok.Data;

@Data
public class SummarizeRequest {
    String transcript;
    String prompt;
}
