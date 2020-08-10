package com.example.demolearnamqp.statemachine.container;

import com.example.demolearnamqp.statemachine.WorkOrderStateMachine;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * @author wangjiankai
 * @date 2020/8/10 10:46 PM
 */
public class WorkOrderBase {

    public static final AtomicReferenceFieldUpdater<WorkOrderStateMachine, Boolean> hangUpCheck
            = AtomicReferenceFieldUpdater.newUpdater(WorkOrderStateMachine.class, Boolean.class, "hangUpFlag");

}
