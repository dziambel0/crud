package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TaskMapperTest {

    @Autowired
    private TaskMapper taskMapper;

    @Test
    void mapToTask() {
        //Given
        TaskDto taskDto = new TaskDto(1L, "title test", "content test");

        //When
        Task task = taskMapper.mapToTask(taskDto);
        //Then
        assertEquals(1L, task.getId());
        assertEquals("title test", task.getTitle());
        assertEquals("content test", task.getContent());
    }

    @Test
    void mapToTaskDto() {
        //Given
        Task task = new Task(1L, "title test", "content test");

        //When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);
        //Then
        assertEquals(1L, taskDto.getId());
        assertEquals("title test", taskDto.getTitle());
        assertEquals("content test", taskDto.getContent());
    }

    @Test
    void mapToTaskDtoList() {
        //Given
        Task task1 = new Task(1L, "title test1", "content test1");
        Task task2 = new Task(2L, "title test2", "content test2");
        List<Task> taskList = new ArrayList<>();
        taskList.add(task1);
        taskList.add(task2);

        //When
        List<TaskDto> taskDtoList = taskMapper.mapToTaskDtoList(taskList);

        //Then
        assertEquals(2, taskDtoList.size());
        assertEquals("title test1", taskDtoList.get(0).getTitle());
    }
}