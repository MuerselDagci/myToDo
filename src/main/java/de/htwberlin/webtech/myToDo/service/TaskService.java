package de.htwberlin.webtech.myToDo.service;

import de.htwberlin.webtech.myToDo.presistance.TaskEntity;
import de.htwberlin.webtech.myToDo.presistance.TaskRepository;
import de.htwberlin.webtech.myToDo.web.api.Task;
import de.htwberlin.webtech.myToDo.web.api.TaskManipulationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task>findALl(){
        List<TaskEntity>tasks = taskRepository.findAll();
        return tasks.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Task findById(Long id){
    var taskEntity = taskRepository.findById(id);
        return taskEntity.map(this::transformEntity).orElse(null);
    }

   public Task create(TaskManipulationRequest request){
        var taskEntity = new TaskEntity(request.getTitel(),request.getStatus(),request.getDuedate());
        taskEntity = taskRepository.save(taskEntity);
        return transformEntity(taskEntity);
    }

    public Task update(Long id, TaskManipulationRequest request){
        var taskEntityOptional = taskRepository.findById(id);
        if (taskEntityOptional.isEmpty()){
            return null;
        }

        var taskEntity = taskEntityOptional.get();
        taskEntity.setTitel(request.getTitel());
        taskEntity.setStatus(request.getStatus());
        taskEntity.setDuedate(request.getDuedate());
        taskEntity= taskRepository.save(taskEntity);

        return transformEntity(taskEntity);
    }

        public boolean deletedById(Long id){
        if (!taskRepository.existsById(id)){
            return false;
        }
        taskRepository.deleteById(id);
        return true;
        }


    private Task transformEntity(TaskEntity taskEntity){
        return new Task(
                taskEntity.getId(),
                taskEntity.getTitel(),
                taskEntity.getStatus(),
                taskEntity.getDuedate()
        );
    }
}
