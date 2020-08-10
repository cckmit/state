package com.example.demolearnamqp.statemachine.action;

import com.example.demolearnamqp.statemachine.enumtype.WorkOrderState;
import com.example.demolearnamqp.statemachine.inter.WorkOrderActionAdapter;

/**
 * 已完结
 */
public class FinishedWorkOrderAction extends WorkOrderActionAdapter {
    private static final FinishedWorkOrderAction instance = new FinishedWorkOrderAction();
    private FinishedWorkOrderAction() {}
    public static FinishedWorkOrderAction getInstance() {
        return instance;
    }

    @Override
    public WorkOrderState getName() {
        return WorkOrderState.finished;
    }

}
