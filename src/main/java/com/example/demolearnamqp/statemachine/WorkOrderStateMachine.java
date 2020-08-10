package com.example.demolearnamqp.statemachine;

import com.example.demolearnamqp.entity.WorkOrder;
import com.example.demolearnamqp.statemachine.action.ToBeAssignedWorkOrderAction;
import com.example.demolearnamqp.statemachine.enumtype.WorkOrderState;
import com.example.demolearnamqp.statemachine.inter.IWorkOrderAction;
import lombok.Data;

@Data
public class WorkOrderStateMachine {

    private WorkOrder workOrder;

    private IWorkOrderAction previousState;
    private IWorkOrderAction currentState;

    private volatile Boolean hangUpFlag = false;

    public WorkOrderStateMachine(WorkOrder workOrder) {
        this.workOrder = workOrder;
        this.previousState = ToBeAssignedWorkOrderAction.getInstance();
        this.currentState = ToBeAssignedWorkOrderAction.getInstance();
    }
    public WorkOrderState getName() {
        return currentState.getName();
    }

    public void workOrderAllocation() {
        this.currentState.workOrderAllocation(this);
    }
    public void workOrderAllocationDefaultOrder() {
        this.currentState.workOrderAllocationDefaultOrder(this);
    }
    public void administratorSuspendOperation() {
        this.currentState.administratorSuspendOperation(this);
    }
    public void judgedAsUnprocessable() {
        this.currentState.judgedAsUnprocessable(this);
    }
    public void receiveWorkOrder() {
        this.currentState.receiveWorkOrder(this);
    }
    public void administratorUnhook() {
        this.currentState.administratorUnhook(this);
    }
    public void noFeeForSubmittingProcessingResults() {
        this.currentState.noFeeForSubmittingProcessingResults(this);
    }
    public void thereIsAFeeForSubmittingTheProcessingResult() {
        this.currentState.thereIsAFeeForSubmittingTheProcessingResult(this);
    }
    public void judgedAsFalsePositive() {
        this.currentState.judgedAsFalsePositive(this);
    }
    public void paymentCompleted() {
        this.currentState.paymentCompleted(this);
    }
    public void confirmWorkOrder() {
        this.currentState.confirmWorkOrder(this);
    }
    public void evaluationWorkOrder() {
        this.currentState.evaluationWorkOrder(this);
    }

    public void resetPreviousState() {
        previousState = currentState;
    }
}