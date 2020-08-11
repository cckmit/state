package com.example.demolearnamqp.bean;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "workorder_statemachine")
public class StateMachineBase {
    @Id
    private long id;
    @Column(length = 32)
    private String previousState;
    @Column(length = 32)
    private String currentState;
    private boolean hangUpFlag;
}
