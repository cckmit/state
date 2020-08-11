package com.example.demolearnamqp.statemachine.inter;

import com.example.demolearnamqp.statemachine.WorkOrderStateMachine;
import com.example.demolearnamqp.statemachine.enumtype.WorkOrderState;

public interface IWorkOrderAction {

    WorkOrderState getType();

    /**
     * 工单分配
     * @param stateMachine
     */
    void workOrderAllocation(WorkOrderStateMachine stateMachine);

    /**
     * 工单分配并且默认接单
     * @param stateMachine
     */
    void workOrderAllocationDefaultOrder(WorkOrderStateMachine stateMachine);

    /**
     * 管理员挂起操作
     * @param stateMachine
     */
    void administratorSuspendOperation(WorkOrderStateMachine stateMachine);

    /**
     * 判定为无法处理
     * @param stateMachine
     */
    void judgedAsUnprocessable(WorkOrderStateMachine stateMachine);

    /**
     * 接受工单
     * @param stateMachine
     */
    void receiveWorkOrder(WorkOrderStateMachine stateMachine);

    /**
     * 管理员解挂操作
     * @param stateMachine
     */
    void administratorUnhook(WorkOrderStateMachine stateMachine);

    /**
     * 提交处理结果没有费用
     * @param stateMachine
     */
    void noFeeForSubmittingProcessingResults(WorkOrderStateMachine stateMachine);

    /**
     * 提交处理结果有费用
     * @param stateMachine
     */
    void thereIsAFeeForSubmittingTheProcessingResult(WorkOrderStateMachine stateMachine);

    /**
     * 判定为误报
     * @param stateMachine
     */
    void judgedAsFalsePositive(WorkOrderStateMachine stateMachine);

    /**
     * 支付完成
     * @param stateMachine
     */
    void paymentCompleted(WorkOrderStateMachine stateMachine);

    /**
     * 确认工单
     * @param stateMachine
     */
    void confirmWorkOrder(WorkOrderStateMachine stateMachine);

    /**
     * 评价工单
     * @param stateMachine
     */
    void evaluationWorkOrder(WorkOrderStateMachine stateMachine);
}