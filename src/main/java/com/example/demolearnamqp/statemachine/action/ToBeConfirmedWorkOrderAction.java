package com.example.demolearnamqp.statemachine.action;

import com.example.demolearnamqp.statemachine.WorkOrderStateMachine;
import com.example.demolearnamqp.statemachine.container.WorkOrderBase;
import com.example.demolearnamqp.statemachine.enumtype.WorkOrderState;
import com.example.demolearnamqp.statemachine.inter.WorkOrderActionAdapter;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 待确认
 */
@Data
@Component
public class ToBeConfirmedWorkOrderAction extends WorkOrderActionAdapter implements Serializable {

    private final String name = WorkOrderState.toBeConfirmed.name();

    @Override
    public WorkOrderState getType() {
        return WorkOrderState.toBeConfirmed;
    }

    @Override
    public void confirmWorkOrder(WorkOrderStateMachine stateMachine) {
        super.confirmWorkOrder(stateMachine);
        stateMachine.setCurrentState(WorkOrderBase.commentWorkOrderAction);
    }
}
