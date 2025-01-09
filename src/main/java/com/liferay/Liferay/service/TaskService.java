package com.liferay.Liferay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liferay.Liferay.dto.TaskDto;
import com.liferay.Liferay.entity.TaskEntity;
import com.liferay.Liferay.taskRepository.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskDto taskDto;

    public TaskDto createTask(TaskDto taskDto) {
        TaskEntity taskEntity = new TaskEntity(null, taskDto.getName(), taskDto.getDescription(), taskDto.isDone(),
                taskDto.getPriority());

        TaskEntity savedTask = taskRepository.save(taskEntity);

        return new TaskDto(
                savedTask.getId(),
                savedTask.getName(),
                savedTask.getDescription(),
                savedTask.isDone(),
                savedTask.getPriority());
    }

    public TaskDto getTaskById(Long id) {

        TaskEntity task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task Não encontrada"));

        return new TaskDto(task.getId(), task.getName(), task.getDescription(), task.isDone(), task.getPriority());

    }

    public TaskDto putTaskId(Long id, TaskDto taskDto) {

        TaskEntity taskEntity = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task nao encontrada"));

        taskEntity.setName(taskDto.getName());
        taskEntity.setDescription(taskDto.getDescription());
        taskEntity.setDone(taskDto.isDone());
        taskEntity.setPriority(taskDto.getPriority());

        TaskEntity updateEntity = taskRepository.save(taskEntity);

        return new TaskDto(null, updateEntity.getName(), updateEntity.getDescription(), updateEntity.isDone(),
                updateEntity.getPriority());

    }

    public void deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new RuntimeException("Task não encontrada para deletar");
        }
        taskRepository.deleteById(id);

    }

}
