package com.choster.core.service.dto;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class TaskInDTO {
	
	private String title;
	private String description;
	private LocalDateTime eta;
}
