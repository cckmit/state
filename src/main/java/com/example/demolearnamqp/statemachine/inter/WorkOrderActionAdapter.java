package com.example.demolearnamqp.statemachine.inter;

import com.example.demolearnamqp.statemachine.WorkOrderStateMachine;
import com.example.demolearnamqp.statemachine.enumtype.WorkOrderState;

public class WorkOrderActionAdapter implements IWorkOrderAction {


    @Override
    public WorkOrderState getName() {
        return null;
    }


    @Override
    public void workOrderAllocation(WorkOrderStateMachine stateMachine) { preOperateOnStateMachine(stateMachine); }
    @Override
    public void workOrderAllocationDefaultOrder(WorkOrderStateMachine stateMachine) { preOperateOnStateMachine(stateMachine);}
    @Override
    public void administratorSuspendOperation(WorkOrderStateMachine stateMachine) { preOperateOnStateMachine(stateMachine); }
    @Override
    public void judgedAsUnprocessable(WorkOrderStateMachine stateMachine) { preOperateOnStateMachine(stateMachine); }
    @Override
    public void receiveWorkOrder(WorkOrderStateMachine stateMachine) { preOperateOnStateMachine(stateMachine); }
    @Override
    public void administratorUnhook(WorkOrderStateMachine stateMachine) { preOperateOnStateMachine(stateMachine); }
    @Override
    public void noFeeForSubmittingProcessingResults(WorkOrderStateMachine stateMachine) { preOperateOnStateMachine(stateMachine); }
    @Override
    public void thereIsAFeeForSubmittingTheProcessingResult(WorkOrderStateMachine stateMachine) { preOperateOnStateMachine(stateMachine); }
    @Override
    public void judgedAsFalsePositive(WorkOrderStateMachine stateMachine) { preOperateOnStateMachine(stateMachine); }
    @Override
    public void paymentCompleted(WorkOrderStateMachine stateMachine) { preOperateOnStateMachine(stateMachine); }
    @Override
    public void confirmWorkOrder(WorkOrderStateMachine stateMachine) { preOperateOnStateMachine(stateMachine); }
    @Override
    public void evaluationWorkOrder(WorkOrderStateMachine stateMachine) { preOperateOnStateMachine(stateMachine); }

    private void preOperateOnStateMachine(WorkOrderStateMachine stateMachine) {
        stateMachine.resetPreviousState();
    }

}