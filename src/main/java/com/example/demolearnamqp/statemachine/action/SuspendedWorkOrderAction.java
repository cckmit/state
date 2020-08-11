package com.example.demolearnamqp.statemachine.action;

import com.example.demolearnamqp.statemachine.WorkOrderStateMachine;
import com.example.demolearnamqp.statemachine.enumtype.WorkOrderState;
import com.example.demolearnamqp.statemachine.inter.IWorkOrderAction;
import com.example.demolearnamqp.statemachine.inter.WorkOrderActionAdapter;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 已挂起
 */
@Data
@Component
public class SuspendedWorkOrderAction extends WorkOrderActionAdapter implements Serializable {

    private final String name = WorkOrderState.suspended.name();

    @Override
    public WorkOrderState getType() {
        return WorkOrderState.suspended;
    }

    @Override
    public void administratorUnhook(WorkOrderStateMachine stateMachine) {
        IWorkOrderAction previousState = stateMachine.getPreviousState();
        super.administratorUnhook(stateMachine);
        stateMachine.setCurrentState(previousState);
    }
}
