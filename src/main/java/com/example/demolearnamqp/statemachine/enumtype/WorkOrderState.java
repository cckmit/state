package com.example.demolearnamqp.statemachine.enumtype;

/**
 * @author wangjiankai
 * @date 2020/8/6 10:56 PM
 */

public enum WorkOrderState {
    /**
     * 待分配
     */
    toBeAssigned(0),
    /**
     * 已分配
     */
    allocated(1),
    /**
     * 已挂起
     */
    suspended(2),
    /**
     * 待支付
     */
    toBePaid(3),
    /**
     * 已接单
     */
    orderReceived(4),
    /**
     * 待确认
     */
    toBeConfirmed(5),
    /**
     * 待评价
     */
    comment(6),
    /**
     * 已完结
     */
    finished(7);

    private final int value;

    WorkOrderState(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}