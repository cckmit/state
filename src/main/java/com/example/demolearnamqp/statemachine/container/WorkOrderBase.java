package com.example.demolearnamqp.statemachine.container;

import com.example.demolearnamqp.statemachine.action.*;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author wangjiankai
 * @date 2020/8/10 10:46 PM
 */
@Component
public class WorkOrderBase implements SmartInitializingSingleton, ApplicationContextAware {

    private static ApplicationContext context;

    public static AllocatedWorkOrderAction allocatedWorkOrderAction;
    public static CommentWorkOrderAction commentWorkOrderAction;
    public static FinishedWorkOrderAction finishedWorkOrderAction;
    public static OrderReceivedWorkOrderAction orderReceivedWorkOrderAction;
    public static SuspendedWorkOrderAction suspendedWorkOrderAction;
    public static ToBeAssignedWorkOrderAction toBeAssignedWorkOrderAction;
    public static ToBeConfirmedWorkOrderAction toBeConfirmedWorkOrderAction;
    public static ToBePaidWorkOrderAction toBePaidWorkOrderAction;

//    public static final AtomicReferenceFieldUpdater<WorkOrderStateMachine, Boolean> hangUpCheck
//            = AtomicReferenceFieldUpdater.newUpdater(WorkOrderStateMachine.class, Boolean.class, "hangUpFlag");


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
    }

    @SuppressWarnings("all")
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
}
