package de.htwberlin.webtech.service;

import de.htwberlin.webtech.persistence.Category;
import de.htwberlin.webtech.persistence.RecipeEntity;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.doReturn;

class RecipeTransformerTest implements WithAssertions {

    private final RecipeTransformer recipeTransformer = new RecipeTransformer();

    @Test
    @DisplayName("should transform RecipeEntity to Recipe")
    void testTransform() {
        // given
        var recipeEntity = Mockito.mock(RecipeEntity.class);
        doReturn(44L).when(recipeEntity).getId();
        doReturn("Noodles").when(recipeEntity).getRecipeName();
        doReturn(Category.MAIN_COURSE).when(recipeEntity).getCategory();
        doReturn("Noodles, Beef, Onion").when(recipeEntity).getIngredients();
        doReturn(4).when(recipeEntity).getPortion();
        doReturn(60).when(recipeEntity).getTotalTime();
        doReturn("Add beef and onion and noodles").when(recipeEntity).getInstruction();

        // when
        var result = recipeTransformer.transformEntity(recipeEntity);

        // then
        assertThat(result.getId()).isEqualTo(44);
        assertThat(result.getRecipeName()).isEqualTo("Noodles");
        assertThat(result.getCategory()).isEqualTo("MAIN_COURSE");
        assertThat(result.getIngredients()).isEqualTo("Noodles, Beef, Onion");
        assertThat(result.getPortion()).isEqualTo(4);
        assertThat(result.getTotalTime()).isEqualTo(60);
        assertThat(result.getInstruction()).isEqualTo("Add beef and onion and noodles");
    }
}

