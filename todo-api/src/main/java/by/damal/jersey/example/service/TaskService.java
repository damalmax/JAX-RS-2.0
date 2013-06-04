package by.damal.jersey.example.service;

import by.damal.jersey.example.domain.Task;

/**
 * TodoService.
 *
 * @author Maksim Dadzerkin
 */
public interface TaskService {
    /**
     * Returns {@link Task} by ID.
     *
     * @param id the task ID.
     */
    Task read(Integer id);

    /**
     * Save task.
     *
     * @param task the {@link Task} object.
     */
    void save(Task task);

    /**
     * Removes {@link Task} by ID.
     *
     * @param id the task ID.
     */
    void delete(Integer id);
}
