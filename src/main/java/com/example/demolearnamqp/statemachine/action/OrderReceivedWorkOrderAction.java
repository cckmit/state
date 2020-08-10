package com.example.demolearnamqp.statemachine.action;

import com.example.demolearnamqp.statemachine.WorkOrderStateMachine;
import com.example.demolearnamqp.statemachine.enumtype.WorkOrderState;
import com.example.demolearnamqp.statemachine.inter.WorkOrderActionAdapter;

/**
 * 已接单
 */
public class OrderReceivedWorkOrderAction extends WorkOrderActionAdapter {
    private static final OrderReceivedWorkOrderAction instance = new OrderReceivedWorkOrderAction();
    private OrderReceivedWorkOrderAction() {}
    public static OrderReceivedWorkOrderAction getInstance() {
        return instance;
    }

    @Override
    public WorkOrderState getName() {
        return WorkOrderState.orderReceived;
    }

    @Override
    public void administratorSuspendOperation(WorkOrderStateMachine stateMachine) {
        super.administratorSuspendOperation(stateMachine);
        stateMachine.setCurrentState(SuspendedWorkOrderAction.getInstance());
    }

    @Override
    public void noFeeForSubmittingProcessingResults(WorkOrderStateMachine stateMachine) {
        super.noFeeForSubmittingProcessingResults(stateMachine);
        stateMachine.setCurrentState(ToBeConfirmedWorkOrderAction.getInstance());
    }

    @Override
    public void thereIsAFeeForSubmittingTheProcessingResult(WorkOrderStateMachine stateMachine) {
        super.thereIsAFeeForSubmittingTheProcessingResult(stateMachine);
        stateMachine.setCurrentState(ToBePaidWorkOrderAction.getInstance());
    }

    @Override
    public void judgedAsFalsePositive(WorkOrderStateMachine stateMachine) {
        super.judgedAsFalsePositive(stateMachine);
        stateMachine.setCurrentState(FinishedWorkOrderAction.getInstance());
    }

    @Override
    public void judgedAsUnprocessable(WorkOrderStateMachine stateMachine) {
        super.judgedAsUnprocessable(stateMachine);
        stateMachine.setCurrentState(FinishedWorkOrderAction.getInstance());
    }
}
