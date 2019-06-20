package com.example.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "safety_info")
public class Safety {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ID
    private Long uid; // 用户ID
    private String username; // 用户名
    private String mobile; // 手机号
    private String password; // 密码
    private String createTime; // 创建时间
    private String updateTime; // 最后修改时间
}
