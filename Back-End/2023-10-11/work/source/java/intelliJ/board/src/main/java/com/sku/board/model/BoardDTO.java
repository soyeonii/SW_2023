package com.sku.board.model;

import lombok.Data;

import java.util.Date;

@Data
public class BoardDTO {
    private int id;
    private int writerId;
    private String title;
    private String content;
    private Date entryDate;
    private Date modifyDate;
}
