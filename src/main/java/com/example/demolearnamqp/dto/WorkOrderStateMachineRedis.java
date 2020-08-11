package com.example.demolearnamqp.dto;

import lombok.Data;

@Data
public class WorkOrderStateMachineRedis {
    private long id;
    private String previousState;
    private String currentState;
    private boolean hangUpFlag;
}
