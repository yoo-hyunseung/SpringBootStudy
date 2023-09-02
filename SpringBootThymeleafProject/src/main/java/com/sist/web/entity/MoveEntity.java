package com.sist.web.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
/*
 * 	MNO,"decimal(38,0)"
	TITLE,tinytext
	INTRODUCE,longtext
	ADDRESS,varchar(500)
	POSTER,varchar(1000)
	CARRER,tinytext
	EMPLO,tinytext
	CONTANTTIME,varchar(500)
	SERVICE,longtext
	SCORE,"decimal(2,1)"
	CATEGORY,tinytext
	POSTER2,longtext
	RESERVE_DAY,tinytext
	SUGGEST,"decimal(38,0)"
 */
@Table(name = "MOVE_DETAIL")
@Getter
@Setter
public class MoveEntity {
	@Id
	private int mno;
	private String title,introduce,address,poster,carrer,emplo,contanttime,service;
	private double score;
	private String category,poster2,reserve_day;
	private int suggest;
}
