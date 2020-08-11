package com.example.demolearnamqp.bean;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author wangjiankai
 * @date 2020/8/10 11:08 PM
 */
@Data
@Entity
@Table(name = "workorder")
public class WorkOrder implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 32)
    private String title;
    @Column(length = 32)
    private String content;

}
