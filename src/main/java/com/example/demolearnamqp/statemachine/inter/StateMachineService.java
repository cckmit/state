package com.example.demolearnamqp.statemachine.inter;

import com.example.demolearnamqp.statemachine.WorkOrderStateMachine;

public interface StateMachineService {

    /**
     * 初始化或加载状态机
     * @param id 工单id
     * @return 状态机实例
     */
    WorkOrderStateMachine initOrLoadStateMachine(Long id);

}
