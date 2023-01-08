package de.htwberlin.webtech.myToDo;
import de.htwberlin.webtech.myToDo.presistance.TaskRepository;
import de.htwberlin.webtech.myToDo.service.TaskService;

import de.htwberlin.webtech.myToDo.web.api.TaskManipulationRequest;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;


import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;


@SpringBootTest
class MyToDoAppApplicationTests implements WithAssertions {

	@Test
	void contextLoads() {
	}
	@Mock
	private TaskRepository repository;

	@InjectMocks
	private TaskService underTest;

	@Test
	@DisplayName("should return true if delete was successful")
	void should_return_true_if_delete_was_successful() {
		// given
		Long givenId = 111L;
		doReturn(true).when(repository).existsById(givenId);

		// when
		boolean result = underTest.deletedById(givenId);

		// then
		verify(repository).deleteById(givenId);
		assertThat(result).isTrue();
	}
}
