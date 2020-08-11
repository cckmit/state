package com.example.demolearnamqp.statemachine.inter;

import com.example.demolearnamqp.statemachine.WorkOrderStateMachine;
import com.example.demolearnamqp.statemachine.enumtype.WorkOrderState;

public class WorkOrderActionAdapter implements IWorkOrderAction {

    @Override
    public WorkOrderState getType() {
        return null;
    }

    @Override
    public void workOrderAllocation(WorkOrderStateMachine stateMachine) {  }
    @Override
    public void workOrderAllocationDefaultOrder(WorkOrderStateMachine stateMachine) { }
    @Override
    public void administratorSuspendOperation(WorkOrderStateMachine stateMachine) {  }
    @Override
    public void judgedAsUnprocessable(WorkOrderStateMachine stateMachine) {  }
    @Override
    public void receiveWorkOrder(WorkOrderStateMachine stateMachine) {  }
    @Override
    public void administratorUnhook(WorkOrderStateMachine stateMachine) {  }
    @Override
    public void noFeeForSubmittingProcessingResults(WorkOrderStateMachine stateMachine) {  }
    @Override
    public void thereIsAFeeForSubmittingTheProcessingResult(WorkOrderStateMachine stateMachine) {  }
    @Override
    public void judgedAsFalsePositive(WorkOrderStateMachine stateMachine) {  }
    @Override
    public void paymentCompleted(WorkOrderStateMachine stateMachine) {  }
    @Override
    public void confirmWorkOrder(WorkOrderStateMachine stateMachine) {  }
    @Override
    public void evaluationWorkOrder(WorkOrderStateMachine stateMachine) {  }
}