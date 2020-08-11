package com.example.demolearnamqp.statemachine.action;

import com.example.demolearnamqp.statemachine.WorkOrderStateMachine;
import com.example.demolearnamqp.statemachine.container.WorkOrderBase;
import com.example.demolearnamqp.statemachine.enumtype.WorkOrderState;
import com.example.demolearnamqp.statemachine.inter.WorkOrderActionAdapter;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 待评价
 */
@Data
@Component
public class CommentWorkOrderAction extends WorkOrderActionAdapter implements Serializable {

    private final String name = WorkOrderState.comment.name();

    @Override
    public WorkOrderState getType() {
        return WorkOrderState.comment;
    }

    @Override
    public void evaluationWorkOrder(WorkOrderStateMachine stateMachine) {
        super.evaluationWorkOrder(stateMachine);
        stateMachine.setCurrentState(WorkOrderBase.finishedWorkOrderAction);
    }
}
