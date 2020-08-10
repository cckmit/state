package com.example.demolearnamqp.statemachine.action;

import com.example.demolearnamqp.statemachine.WorkOrderStateMachine;
import com.example.demolearnamqp.statemachine.enumtype.WorkOrderState;
import com.example.demolearnamqp.statemachine.inter.WorkOrderActionAdapter;

/**
 * 待评价
 */
public class CommentWorkOrderAction extends WorkOrderActionAdapter {
    private static final CommentWorkOrderAction instance = new CommentWorkOrderAction();
    private CommentWorkOrderAction() {}
    public static CommentWorkOrderAction getInstance() {
        return instance;
    }

    @Override
    public WorkOrderState getName() {
        return WorkOrderState.comment;
    }

    @Override
    public void evaluationWorkOrder(WorkOrderStateMachine stateMachine) {
        super.evaluationWorkOrder(stateMachine);
        stateMachine.setCurrentState(FinishedWorkOrderAction.getInstance());
    }
}
