package com.choster.core.persistence.repository;

import java.util.List;

import com.choster.core.persistence.entity.Task;
import com.choster.core.persistence.entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface TaskRepository extends JpaRepository<Task,Long>{
	
	//Listar tareas por estado
	public List<Task> findAllByTaskStatus(TaskStatus status);
	
	//Actualizar tarea 
	@Modifying
	@Query(value = "UPDATE TASK	SET FINISHED=true WHERE ID=:id", nativeQuery = true)
	public void markTaskAsFinished(@Param("id") Long id);
	
}
