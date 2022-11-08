package de.htwberlin.webtech.myToDo.web.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TaskRestController {

    private List<Task>tasks;

    public TaskRestController(){
        tasks = new ArrayList<>();
        tasks.add(new Task("wichtig","Büro putzen","22.10.2022"));
        tasks.add(new Task("unwichtig","X GmbH um Termin bitten","23.10.2022"));
    }

    @GetMapping(path= "/api/v1/tasks")
    public ResponseEntity<List<Task>> fetchTasks(){
        return ResponseEntity.ok(tasks);
    }

}
