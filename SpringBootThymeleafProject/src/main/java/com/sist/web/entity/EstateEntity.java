package com.sist.web.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/*
 * 	NO,int
	ETYPE,"decimal(10,0)"
	DPRICE,tinytext
	NAME,tinytext
	IMG,text
	TYPE,tinytext
	ADDR,varchar(300)
	AREA,tinytext
	TRAFIC,tinytext
	STATE,tinytext
	MANAGER,tinytext
	COMPANY,tinytext
	COMADDR,tinytext
	PARKING,tinytext
	MOVEDAY,tinytext

 */
@Entity
@Table(name = "ESTATE_DETAIL")
@Setter
@Getter
public class EstateEntity {
	@Id
	private int no;
	private int etype;
	private String dprice,name,img,type,addr,area,trafic,state,manager,company,comaddr,
					parking,moveday;
	
}
