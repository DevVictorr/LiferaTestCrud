package com.liferay.Liferay.taskRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.liferay.Liferay.entity.TaskEntity;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {

}
