package de.htwberlin.webtech.myToDo.presistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity,Long> {
    List<TaskEntity> findAllByStatus(String status);
}
