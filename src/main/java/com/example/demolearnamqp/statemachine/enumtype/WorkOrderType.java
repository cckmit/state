package com.example.demolearnamqp.statemachine.enumtype;

/**
 * 工单类型
 */
public enum WorkOrderType {

    /**
     * 维修
     */
    repair(true, false),
    /**
     * 安防
     */
    security(false, true),
    /**
     * 消防
     */
    fireFighting(false, true),
    /**
     * 电梯
     */
    elevator(false, true),
    /**
     * 环境绿化
     */
    environmentalGreening(false, true),
    /**
     * 环境保洁
     */
    environmentalCleaning(false, true),
    /**
     * 其他类型
     */
    other(true, true);

    /**
     * 是否提供加急服务
     */
    private final boolean provideExpeditedService;
    /**
     * 是否支持公开
     */
    private final boolean providePublic;

    WorkOrderType(boolean provideExpeditedService, boolean providePublic) {
        this.provideExpeditedService = provideExpeditedService;
        this.providePublic = providePublic;
    }

    public boolean isProvideExpeditedService() {
        return provideExpeditedService;
    }

    public boolean isProvidePublic() {
        return providePublic;
    }
}
