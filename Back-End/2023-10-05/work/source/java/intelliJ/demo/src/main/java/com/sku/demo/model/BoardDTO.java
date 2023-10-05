package com.sku.demo.model;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
public class BoardDTO {
	private int id;
	private String content;
	private String title;
	private Date entryDate;
	private Date modifyDate;
	private int writerId;
	private String nickname;
}

