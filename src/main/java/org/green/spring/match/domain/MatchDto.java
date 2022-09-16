package org.green.spring.match.domain;

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
public class MatchDto {
	
	private int matchNo;
	private Date matchDate;
	private String matchStadium;
	private String matchTeam;
	private String matchResult;
	

}
