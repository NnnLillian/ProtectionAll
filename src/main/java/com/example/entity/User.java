package com.example.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "user_info")
public class User implements Serializable {
	private static final long serialVersionUID = -989635790212353396L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // 用户ID
	private String name; // 用户名称
	private String phone; // 电话号码
	private String birthday; // 生日
	private String createTime; // 创建时间
	private String updateTime; // 最后修改时间
}
