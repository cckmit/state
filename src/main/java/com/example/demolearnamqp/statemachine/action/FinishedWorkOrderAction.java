package com.example.demolearnamqp.statemachine.action;

import com.example.demolearnamqp.statemachine.enumtype.WorkOrderState;
import com.example.demolearnamqp.statemachine.inter.WorkOrderActionAdapter;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 已完结
 */
@Data
@Component
public class FinishedWorkOrderAction extends WorkOrderActionAdapter implements Serializable {

    private final String name = WorkOrderState.finished.name();

    @Override
    public WorkOrderState getType() {
        return WorkOrderState.finished;
    }

}
