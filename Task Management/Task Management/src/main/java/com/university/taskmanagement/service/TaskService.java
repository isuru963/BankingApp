package com.university.taskmanagement.service;

import com.university.taskmanagement.model.Task;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {
    private List<Task> tasks = new ArrayList<>();
    private int nextId = 1;

    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks);
    }

    public Optional<Task> getTaskById(int id) {
        return tasks.stream().filter(t -> t.getId() == id).findFirst();
    }

    public Task createTask(Task task) {
        task.setId(nextId++);
        tasks.add(task);
        return task;
    }

    public Optional<Task> updateTask(int id, Task task) {
        Optional<Task> existingTask = getTaskById(id);
        existingTask.ifPresent(t -> {
            t.setTitle(task.getTitle());
            t.setDescription(task.getDescription());
            t.setStatus(task.getStatus());
            t.setPriority(task.getPriority());
        });
        return existingTask;
    }

    public Optional<Task> updateTaskStatus(int id, String status) {
        Optional<Task> existingTask = getTaskById(id);
        existingTask.ifPresent(t -> t.setStatus(status));
        return existingTask;
    }

    public boolean deleteTask(int id) {
        return tasks.removeIf(t -> t.getId() == id);
    }

    public List<Task> getTasksByPriority(int level) {
        return tasks.stream()
                .filter(t -> t.getPriority() == level)
                .collect(Collectors.toList());
    }
}