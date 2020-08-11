package com.example.demolearnamqp.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wangjiankai
 * @date 2020/8/10 11:08 PM
 */
@Data
public class WorkOrder implements Serializable {

    private Long id;

    public WorkOrder(Long id) {
        this.id = id;
    }
}
