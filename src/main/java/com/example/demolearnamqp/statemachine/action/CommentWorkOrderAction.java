package com.example.demolearnamqp.statemachine.action;

import com.example.demolearnamqp.statemachine.WorkOrderStateMachine;
import com.example.demolearnamqp.statemachine.container.WorkOrderBase;
import com.example.demolearnamqp.statemachine.enumtype.WorkOrderState;
import com.example.demolearnamqp.statemachine.inter.WorkOrderActionAdapter;
import org.springframework.stereotype.Component;

/**
 * 待评价
 */
@Component
public class CommentWorkOrderAction extends WorkOrderActionAdapter {

    @Override
    public WorkOrderState getName() {
        return WorkOrderState.comment;
    }

    @Override
    public void evaluationWorkOrder(WorkOrderStateMachine stateMachine) {
        super.evaluationWorkOrder(stateMachine);
        stateMachine.setCurrentState(WorkOrderBase.finishedWorkOrderAction);
    }
}
