package de.htwberlin.webtech.service;

import de.htwberlin.webtech.persistence.RecipeRepository;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RecipeServiceTest implements WithAssertions {
    @Mock
    private RecipeRepository repository;

    @InjectMocks
    private RecipeService service;

    @Test
    @DisplayName("should return true if delete was successful")
    void testDelete() {
        // given
        Long givenId = 123L;
        doReturn(true).when(repository).existsById(givenId);

        // when
        boolean result = service.deleteById(givenId);

        // then
        verify(repository).deleteById(givenId);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("should return false if recipe to delete does not exist")
    void testDeleteInvalidId() {
        // given
        Long givenId = 111L;
        doReturn(false).when(repository).existsById(givenId);

        // when
        boolean result = service.deleteById(givenId);

        // then
        verifyNoMoreInteractions(repository);
        assertThat(result).isFalse();
    }



}
