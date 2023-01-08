package de.htwberlin.webtech.myToDo.service;
import de.htwberlin.webtech.myToDo.presistance.Mitarbeiter;
import de.htwberlin.webtech.myToDo.presistance.TaskEntity;
import de.htwberlin.webtech.myToDo.presistance.TaskRepository;
import de.htwberlin.webtech.myToDo.presistance.Wiederholung;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.mockito.Mockito.doReturn;


@ExtendWith(MockitoExtension.class)
public class TaskServiceTest implements WithAssertions {
    @Mock
    private TaskRepository repository;

    @InjectMocks
    private TaskService underTest;

    @Test
    @DisplayName("should return was successful")
    void should_return_was_successful() {

        Long id = 150L;
        doReturn(true).when(repository).existsById(id);

        boolean result = underTest.deletedById(id);

        verify(repository).deleteById(id);
        assertThat(result).isTrue();
    }

    @Test
    public void testTransformEntity() {

        // Create object
        var taskEntity = Mockito.mock(TaskEntity.class);
        doReturn(150L).when(taskEntity).getId();
        doReturn("Test").when(taskEntity).getTitel();
        doReturn("Test").when(taskEntity).getBeschreibung();
        doReturn("Test").when(taskEntity).getDuedate();
        doReturn("Test").when(taskEntity).getStatus();
        doReturn(Wiederholung.WOCHENTLICH).when(taskEntity).getWiederholung();
        doReturn(Mitarbeiter.MA_1).when(taskEntity).getMitarbeiter();


        // Transform the TaskEntity object using the transformEntity() method
        var result = underTest.transformEntity(taskEntity);

        // Verify that the fields of the Task object match the corresponding fields of the TaskEntity object
        assertThat(result.getId()).isEqualTo(150L);
        assertThat(result.getTitel()).isEqualTo("Test");
        assertThat(result.getBeschreibung()).isEqualTo("Test");
        assertThat(result.getWiederholung()).isEqualTo("WOCHENTLICH");
        assertThat(result.getStatus()).isEqualTo("Test");
       assertThat(result.getDuedate()).isEqualTo("Test");
        assertThat(result.getMitarbeiter()).isEqualTo("MA_1");
    }

}
