package com.example.demolearnamqp.statemachine.action;

import com.example.demolearnamqp.statemachine.WorkOrderStateMachine;
import com.example.demolearnamqp.statemachine.container.WorkOrderBase;
import com.example.demolearnamqp.statemachine.enumtype.WorkOrderState;
import com.example.demolearnamqp.statemachine.inter.WorkOrderActionAdapter;
import org.springframework.stereotype.Component;

/**
 * 已接单
 */
@Component
public class OrderReceivedWorkOrderAction extends WorkOrderActionAdapter {

    @Override
    public WorkOrderState getName() {
        return WorkOrderState.orderReceived;
    }

    @Override
    public void administratorSuspendOperation(WorkOrderStateMachine stateMachine) {
        super.administratorSuspendOperation(stateMachine);
        stateMachine.setCurrentState(WorkOrderBase.suspendedWorkOrderAction);
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
