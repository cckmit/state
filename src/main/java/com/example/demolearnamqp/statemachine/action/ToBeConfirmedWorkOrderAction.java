package com.example.demolearnamqp.statemachine.action;

import com.example.demolearnamqp.statemachine.WorkOrderStateMachine;
import com.example.demolearnamqp.statemachine.container.WorkOrderBase;
import com.example.demolearnamqp.statemachine.enumtype.WorkOrderState;
import com.example.demolearnamqp.statemachine.inter.WorkOrderActionAdapter;
import org.springframework.stereotype.Component;

/**
 * 待确认
 */
@Component
public class ToBeConfirmedWorkOrderAction extends WorkOrderActionAdapter {

    @Override
    public WorkOrderState getName() {
        return WorkOrderState.toBeConfirmed;
    }

    @Override
    public void confirmWorkOrder(WorkOrderStateMachine stateMachine) {
        super.confirmWorkOrder(stateMachine);
        stateMachine.setCurrentState(WorkOrderBase.commentWorkOrderAction);
    }
}
