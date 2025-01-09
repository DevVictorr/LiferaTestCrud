package com.liferay.Liferay.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TaskDto {
    private Long id;
    private String name;
    private String description;
    private boolean done;
    private int priority;

}
