package com.example.demolearnamqp.statemachine.container;

import com.example.demolearnamqp.statemachine.action.*;
import com.example.demolearnamqp.statemachine.enumtype.WorkOrderState;
import com.example.demolearnamqp.statemachine.inter.IWorkOrderAction;
import com.google.common.collect.Maps;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author wangjiankai
 * @date 2020/8/10 10:46 PM
 */
@Component
public class WorkOrderBase implements SmartInitializingSingleton, ApplicationContextAware {

    private static ApplicationContext context;
    private static Map<String, IWorkOrderAction> workOrderActionXref = Maps.newHashMap();

    public static AllocatedWorkOrderAction allocatedWorkOrderAction;
    public static CommentWorkOrderAction commentWorkOrderAction;
    public static FinishedWorkOrderAction finishedWorkOrderAction;
    public static OrderReceivedWorkOrderAction orderReceivedWorkOrderAction;
    public static SuspendedWorkOrderAction suspendedWorkOrderAction;
    public static ToBeAssignedWorkOrderAction toBeAssignedWorkOrderAction;
    public static ToBeConfirmedWorkOrderAction toBeConfirmedWorkOrderAction;
    public static ToBePaidWorkOrderAction toBePaidWorkOrderAction;

    @Override
    public void afterSingletonsInstantiated() {
        allocatedWorkOrderAction = context.getBean(AllocatedWorkOrderAction.class);
        commentWorkOrderAction = context.getBean(CommentWorkOrderAction.class);
        finishedWorkOrderAction = context.getBean(FinishedWorkOrderAction.class);
        orderReceivedWorkOrderAction = context.getBean(OrderReceivedWorkOrderAction.class);
        suspendedWorkOrderAction = context.getBean(SuspendedWorkOrderAction.class);
        toBeAssignedWorkOrderAction = context.getBean(ToBeAssignedWorkOrderAction.class);
        toBeConfirmedWorkOrderAction = context.getBean(ToBeConfirmedWorkOrderAction.class);
        toBePaidWorkOrderAction = context.getBean(ToBePaidWorkOrderAction.class);

        workOrderActionXref.put(WorkOrderState.allocated.name(), allocatedWorkOrderAction);
        workOrderActionXref.put(WorkOrderState.comment.name(), commentWorkOrderAction);
        workOrderActionXref.put(WorkOrderState.finished.name(), finishedWorkOrderAction);
        workOrderActionXref.put(WorkOrderState.orderReceived.name(), orderReceivedWorkOrderAction);
        workOrderActionXref.put(WorkOrderState.suspended.name(), suspendedWorkOrderAction);
        workOrderActionXref.put(WorkOrderState.toBeAssigned.name(), toBeAssignedWorkOrderAction);
        workOrderActionXref.put(WorkOrderState.toBeConfirmed.name(), toBeConfirmedWorkOrderAction);
        workOrderActionXref.put(WorkOrderState.toBePaid.name(), toBePaidWorkOrderAction);
    }

    @SuppressWarnings("all")
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public static IWorkOrderAction getByType(String name) {
        return workOrderActionXref.getOrDefault(name, null);
    }
}
