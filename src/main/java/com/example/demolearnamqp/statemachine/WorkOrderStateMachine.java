package com.example.demolearnamqp.statemachine;

import com.example.demolearnamqp.entity.WorkOrder;
import com.example.demolearnamqp.statemachine.container.WorkOrderBase;
import com.example.demolearnamqp.statemachine.enumtype.WorkOrderState;
import com.example.demolearnamqp.statemachine.inter.IWorkOrderAction;

import java.io.Serializable;

public class WorkOrderStateMachine implements Serializable {

    private WorkOrder workOrder;

    private IWorkOrderAction previousState;
    private IWorkOrderAction currentState;

    private volatile Boolean hangUpFlag = false;

    public WorkOrderStateMachine(WorkOrder workOrder) {
        this.workOrder = workOrder;
        this.previousState = WorkOrderBase.toBeAssignedWorkOrderAction;
        this.currentState = WorkOrderBase.toBeAssignedWorkOrderAction;
    }
    public WorkOrderState getName() {
        return currentState.getType();
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


    public WorkOrder getWorkOrder() {
        return workOrder;
    }

    public void setWorkOrder(WorkOrder workOrder) {
        this.workOrder = workOrder;
    }

    public IWorkOrderAction getPreviousState() {
        return previousState;
    }

    public void setPreviousState(IWorkOrderAction previousState) {
        this.previousState = previousState;
    }

    public IWorkOrderAction getCurrentState() {
        return currentState;
    }

    public void setCurrentState(IWorkOrderAction currentState) {
        this.currentState = currentState;
    }

    public Boolean getHangUpFlag() {
        return hangUpFlag;
    }

    public void setHangUpFlag(Boolean hangUpFlag) {
        this.hangUpFlag = hangUpFlag;
    }

    @Override
    public String toString() {
        return "WorkOrderStateMachine{" +
                "workOrder=" + workOrder +
                ", previousState=" + previousState +
                ", currentState=" + currentState +
                ", hangUpFlag=" + hangUpFlag +
                '}';
    }
}