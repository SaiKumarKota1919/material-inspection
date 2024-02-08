package com.zm.mi.serachcriteria;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LotSearchCriteria {
	
	private Integer lotId;
	private LocalDate fromDate;
	private LocalDate toDate;
	private String materialId;
	private String plantId;
	private String status;
	

}
