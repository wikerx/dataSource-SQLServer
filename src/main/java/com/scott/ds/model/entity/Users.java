package com.scott.ds.model.entity;

import java.util.Date;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Users表
 * 
 * @author Mr.薛
 *
 */
@ApiModel(value = "Users表")
@Data
public class Users{

	private static final Long serialVersionUID = 1L;

	@ApiModelProperty(value = "用户常用登录省份")
	private String loginRegionName;
	
	@ApiModelProperty(value = "用户常用登录城市")
	private String loginCity;
	
	@ApiModelProperty(value = "最后一次修改时间")
	private Date lastPassModifyDate;
	
	@ApiModelProperty(value = "创建时间")
	private Date createDate;
	
	@ApiModelProperty(value = "")
	private String certThumbprint;
	
	@ApiModelProperty(value = "用户密码")
	private String userPass;
	
	@ApiModelProperty(value = "最后一次登录时间")
	private Date lastLoginDate;
	
	@ApiModelProperty(value = "权限ID")
	private String userRoleID;
	
	@ApiModelProperty(value = "")
	private Integer userModuleID;
	
	@ApiModelProperty(value = "")
	private Integer merID;
	
	@ApiModelProperty(value = "")
	private Integer identifyID;
	
	@ApiModelProperty(value = "用户详情ID")
	private Integer userDetailID;
	
	@ApiModelProperty(value = "")
	private Integer loginMode;
	
	@ApiModelProperty(value = "用户名")
	private String userName;
	
}
