package com.example.demolearnamqp.bean;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "work_order_action_log")
public class WorkOrderActionLog {
    @Id
    private ObjectId id;
    private String previousState;
    private String currentState;
    private Boolean hangUpFlag;
    private Long workOrderId;
    private LocalDateTime changeStateDate;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getPreviousState() {
        return previousState;
    }

    public void setPreviousState(String previousState) {
        this.previousState = previousState;
    }

    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }

    public Boolean getHangUpFlag() {
        return hangUpFlag;
    }

    public void setHangUpFlag(Boolean hangUpFlag) {
        this.hangUpFlag = hangUpFlag;
    }

    public Long getWorkOrderId() {
        return workOrderId;
    }

    public void setWorkOrderId(Long workOrderId) {
        this.workOrderId = workOrderId;
    }

    public LocalDateTime getChangeStateDate() {
        return changeStateDate;
    }

    public void setChangeStateDate(LocalDateTime changeStateDate) {
        this.changeStateDate = changeStateDate;
    }

    @Override
    public String toString() {
        return "WorkOrderActionLog{" +
                "id=" + id +
                ", previousState='" + previousState + '\'' +
                ", currentState='" + currentState + '\'' +
                ", hangUpFlag=" + hangUpFlag +
                ", workOrderId=" + workOrderId +
                ", changeStateDate=" + changeStateDate +
                '}';
    }
}