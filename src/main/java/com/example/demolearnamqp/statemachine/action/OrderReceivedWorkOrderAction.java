package com.example.demolearnamqp.statemachine.action;

import com.example.demolearnamqp.statemachine.WorkOrderStateMachine;
import com.example.demolearnamqp.statemachine.container.WorkOrderBase;
import com.example.demolearnamqp.statemachine.enumtype.WorkOrderState;
import com.example.demolearnamqp.statemachine.inter.WorkOrderActionAdapter;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 已接单
 */
@Data
@Component
public class OrderReceivedWorkOrderAction extends WorkOrderActionAdapter implements Serializable {

    private final String name = WorkOrderState.orderReceived.name();

    @Override
    public WorkOrderState getType() {
        return WorkOrderState.orderReceived;
    }

    @Override
    public void administratorSuspendOperation(WorkOrderStateMachine stateMachine) {
        super.administratorSuspendOperation(stateMachine);
        if (WorkOrderStateMachine.hangUpCheck.compareAndSet(stateMachine, Boolean.FALSE, Boolean.TRUE)) {
            stateMachine.setCurrentState(WorkOrderBase.suspendedWorkOrderAction);
        }
    }

    @Override
    public void noFeeForSubmittingProcessingResults(WorkOrderStateMachine stateMachine) {
        super.noFeeForSubmittingProcessingResults(stateMachine);
        stateMachine.setCurrentState(WorkOrderBase.toBeConfirmedWorkOrderAction);
    }

    @Override
    public void thereIsAFeeForSubmittingTheProcessingResult(WorkOrderStateMachine stateMachine) {
        super.thereIsAFeeForSubmittingTheProcessingResult(stateMachine);
        stateMachine.setCurrentState(WorkOrderBase.toBePaidWorkOrderAction);
    }

    @Override
    public void judgedAsFalsePositive(WorkOrderStateMachine stateMachine) {
        super.judgedAsFalsePositive(stateMachine);
        stateMachine.setCurrentState(WorkOrderBase.finishedWorkOrderAction);
    }

    @Override
    public void judgedAsUnprocessable(WorkOrderStateMachine stateMachine) {
        super.judgedAsUnprocessable(stateMachine);
        stateMachine.setCurrentState(WorkOrderBase.finishedWorkOrderAction);
    }
}
