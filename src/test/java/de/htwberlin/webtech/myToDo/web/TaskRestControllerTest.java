package de.htwberlin.webtech.myToDo.web;
import de.htwberlin.webtech.myToDo.service.TaskService;
import de.htwberlin.webtech.myToDo.web.api.Task;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.mockito.ArgumentMatchers.any;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TaskRestControllerTest.class)
public class TaskRestControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private TaskService taskService;

    @Test
    @DisplayName("should return 201")
    void should_return_201() throws Exception {
        // given
        String TaskToCreateAsJson = "{\"status\": \"d\", \"titel\":\"w\", \"wiederholung\":\"WOCHENTLICH\", \"duedate\": \"8.1.2023\",\"beschreibung\": \"d\",\"mitarbeiter\":\"MA_1\"}";
        var task = new Task(122,null,null,null,null,null,null);
        doReturn(task).when(taskService).create(any());
        mockMvc.perform(
                        post("/api/v1/tasksss")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(TaskToCreateAsJson)
                )
                .andExpect(status().isCreated());
    }


    @Test
    @DisplayName("should validate create task request")
    void task_request() throws Exception {
        String taskToCreateAsJson = "{\"status\": \"d\", \"titel\":\"w\", \"wiederholung\":\"WOCHENTLICH\", \"duedate\": \"8.1.2023\",\"beschreibung\": \"d\",\"mitarbeiter\":\"MA_1\"}";

        mockMvc.perform(
                        post("/api/v1/tasksss")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(taskToCreateAsJson)
                )
                .andExpect(status().isBadRequest());
    }
}
