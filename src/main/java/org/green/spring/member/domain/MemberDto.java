package org.green.spring.member.domain;

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

public class MemberDto {

	private String userId;
	private String userPw;
	private String userName;
	private String userLocation;
	private String userLevel;
	private String role; //사용자 등급
	
}
