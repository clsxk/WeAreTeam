package org.green.spring.record.domain;

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


public class RecordDto {
	
	String userId;
	String userName;
	int matchNum;
	int recordNum;
	int recordGole;
	int recordAssist;
	int recordLosePoint;
	

}
