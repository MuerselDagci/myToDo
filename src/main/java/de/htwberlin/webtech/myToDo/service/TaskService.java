package de.htwberlin.webtech.myToDo.service;

import de.htwberlin.webtech.myToDo.presistance.Mitarbeiter;
import de.htwberlin.webtech.myToDo.presistance.TaskEntity;
import de.htwberlin.webtech.myToDo.presistance.TaskRepository;
import de.htwberlin.webtech.myToDo.presistance.Wiederholung;
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
       var wiederholung = Wiederholung.valueOf(request.getWiederholung());
       var mitarbeiter = Mitarbeiter.valueOf(request.getMitarbeiter());
        var taskEntity = new TaskEntity(request.getTitel(),request.getStatus(),request.getDuedate(),wiederholung,request.getBeschreibung(),mitarbeiter);
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
        taskEntity.setWiederholung(Wiederholung.valueOf(request.getWiederholung()));
        taskEntity.setMitarbeiter(Mitarbeiter.valueOf(request.getMitarbeiter()));
        taskEntity.setBeschreibung(request.getBeschreibung());
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


    public Task transformEntity(TaskEntity taskEntity){
        var wiederholung = taskEntity.getWiederholung() != null ? taskEntity.getWiederholung().name(): Wiederholung.UNKNOWN.name();
        var mitarbeiter = taskEntity.getMitarbeiter() != null? taskEntity.getMitarbeiter().name(): Mitarbeiter.UNKNOWN.name();
        return new Task(
                taskEntity.getId(),
                taskEntity.getTitel(),
                taskEntity.getStatus(),
                wiederholung,
                taskEntity.getDuedate(),
                taskEntity.getBeschreibung(),
                mitarbeiter
        );
    }
}
