package org.green.spring.match.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

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
public class MatchDto {
	
	private int matchNo;
	private String teamName;
	private String matchDate;
	private String matchStadium;
	private String matchTeam;
	private String matchResult;
	private int matchGole;
	private int matchLostPoint;
	

}
