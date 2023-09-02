package com.choster.core.persistence.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Setter
@Entity
@Table(name = "task")
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String description;
	private LocalDateTime createdDate;
	private LocalDateTime eta;
	private boolean finished;
	private TaskStatus taskStatus;
	
}
