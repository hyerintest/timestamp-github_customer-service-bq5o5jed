package com.tlc.msa.dto;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class SampleDto {
    String id;
    String content;
    String post;
}
