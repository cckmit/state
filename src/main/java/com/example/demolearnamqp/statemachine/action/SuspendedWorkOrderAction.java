package com.example.demolearnamqp.statemachine.action;

import com.example.demolearnamqp.statemachine.WorkOrderStateMachine;
import com.example.demolearnamqp.statemachine.enumtype.WorkOrderState;
import com.example.demolearnamqp.statemachine.inter.IWorkOrderAction;
import com.example.demolearnamqp.statemachine.inter.WorkOrderActionAdapter;
import org.springframework.stereotype.Component;

/**
 * 已挂起
 */
@Component
public class SuspendedWorkOrderAction extends WorkOrderActionAdapter {

    @Override
    public WorkOrderState getName() {
        return WorkOrderState.suspended;
    }

    @Override
    public void administratorUnhook(WorkOrderStateMachine stateMachine) {
        IWorkOrderAction previousState = stateMachine.getPreviousState();
        super.administratorUnhook(stateMachine);
        stateMachine.setCurrentState(previousState);
    }
}
