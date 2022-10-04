package org.green.spring.board.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BoardDto {

  private int no;
  private String title; 
  private String content;
  private String teamName;
  private String writer; 
  private Date regDate; 
  private Date updateDate; 
  
}

