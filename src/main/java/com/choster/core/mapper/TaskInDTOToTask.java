package com.choster.core.mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.choster.core.persistence.entity.Task;
import com.choster.core.persistence.entity.TaskStatus;
import com.choster.core.service.dto.TaskInDTO;


@Component
public class TaskInDTOToTask implements IMapper<TaskInDTO, Task>{
	
	@Override
	public Task map(TaskInDTO in) {
		Task task = new Task();
		task.setTitle(in.getTitle());
		task.setDescription(in.getDescription());
		task.setEta(in.getEta());
		task.setCreatedDate(LocalDateTime.now());
		task.setFinished(false);
		task.setTaskStatus(TaskStatus.ON_TIME);
		return task;
	}
}
