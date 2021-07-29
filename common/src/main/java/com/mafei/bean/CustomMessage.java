package com.mafei.bean;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomMessage implements Serializable {
    // payload
    private String msg;
    // when the producer started
    private String startTime;

    private Integer offset;
}