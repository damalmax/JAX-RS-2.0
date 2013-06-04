package by.damal.jersey.example.service;

import by.damal.jersey.example.domain.Task;
import java.util.HashMap;

/**
 * Implementation for {@link TaskService}.
 *
 * @author Maksim Dadzerkin
 */
public class TaskServiceImpl implements TaskService {

    private HashMap<Integer, Task> tasks = new HashMap<Integer, Task>();

    /**
     * {@inheritDoc}
     */
    @Override
    public Task read(Integer id) {
        return tasks.get(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(Task task) {
        if(task.getId() == null) {
            int id = tasks.size();
            task.setId(++id);
            tasks.put(id, task);
        } else {
            tasks.put(task.getId(), task);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(Integer id) {
        tasks.remove(id);
    }
}
