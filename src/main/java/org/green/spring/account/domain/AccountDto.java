package org.green.spring.account.domain;

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
public class AccountDto {
	
	private String teamName;
	private int accNum;
	private String accDivision;
	private String accContent;
	private int accMoney;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date accDate;
	private String accNote;
}
