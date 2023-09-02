package com.choster.core.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.choster.core.exceptions.ToDoExceptions;
import com.choster.core.mapper.TaskInDTOToTask;
import com.choster.core.persistence.entity.Task;
import com.choster.core.persistence.entity.TaskStatus;
import com.choster.core.persistence.repository.TaskRepository;
import com.choster.core.service.dto.TaskInDTO;

@Service
public class TaskService {
	
	private final TaskRepository repository;
	private final TaskInDTOToTask mapper;
	
	public TaskService(TaskRepository repository,TaskInDTOToTask mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}
	
	public Task createTask(TaskInDTO taskInDTO) {
		Task task = mapper.map(taskInDTO);
		return this.repository.save(task); 
	}
	public List<Task> finAll(){
		return this.repository.findAll();
	}
	public List<Task> findAllByTaskStatus(TaskStatus status){
		return this.repository.findAllByTaskStatus(status);
	}
	@Transactional
	public void updateTaskAsFinished(Long id) {
		 Optional<Task> optionalTask = this.repository.findById(id);
		 if (optionalTask.isEmpty()) {
			throw new ToDoExceptions("NO ENCONTRADO", HttpStatus.NOT_FOUND);
		 }
		 this.repository.markTaskAsFinished(id);
	}
	
	public void deleteTaskById(Long id) {
		 Optional<Task> optionalTask = this.repository.findById(id);
		 if (optionalTask.isEmpty()) {
			throw new ToDoExceptions("NO ENCONTRADO", HttpStatus.NOT_FOUND);
		 }
		 this.repository.deleteById(id);
	}	
}
