package de.htwberlin.webtech.web;

import de.htwberlin.webtech.service.RecipeService;
import de.htwberlin.webtech.web.api.Recipe;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RecipeRestController.class)
public class RecipeRestControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RecipeService recipeService;

    static final String BASE_PATH = "/api/v1/recipes";

    @Test
    @DisplayName("should return found recipes from recipe service")
    void testGetAll() throws Exception {
        // given
        var recipes = List.of(
                new Recipe(1, "Noodles", "MAIN_COURSE", "Beef, Noodles, Onion", 4, 60, "Add abc"),
                new Recipe(2, "Cookies", "DESSERT", "Sugar, Butter, Powder", 10, 30, "Add xyz")
        );
        doReturn(recipes).when(recipeService).findAll();

        // when
        mockMvc.perform(get(BASE_PATH))
                // then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].recipeName").value("Noodles"))
                .andExpect(jsonPath("$[0].category").value("MAIN_COURSE"))
                .andExpect(jsonPath("$[0].ingredients").value("Beef, Noodles, Onion"))
                .andExpect(jsonPath("$[0].portion").value(4))
                .andExpect(jsonPath("$[0].totalTime").value(60))
                .andExpect(jsonPath("$[0].instruction").value("Add abc"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].recipeName").value("Cookies"))
                .andExpect(jsonPath("$[1].category").value("DESSERT"))
                .andExpect(jsonPath("$[1].ingredients").value("Sugar, Butter, Powder"))
                .andExpect(jsonPath("$[1].portion").value(10))
                .andExpect(jsonPath("$[1].totalTime").value(30))
                .andExpect(jsonPath("$[1].instruction").value("Add xyz"));
    }

    @Test
    @DisplayName("should return found recipe from recipe service")
    void testGet() throws Exception {
        // given
        var recipe =
                new Recipe(1, "Noodles", "MAIN_COURSE", "Beef, Noodles, Onion", 4, 60, "Add abc");
        doReturn(recipe).when(recipeService).findById(recipe.getId());

        // when
        mockMvc.perform(get(BASE_PATH+ "/" + recipe.getId()))
                // then
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(1))
                .andExpect(jsonPath("recipeName").value("Noodles"))
                .andExpect(jsonPath("category").value("MAIN_COURSE"))
                .andExpect(jsonPath("ingredients").value("Beef, Noodles, Onion"))
                .andExpect(jsonPath("portion").value(4))
                .andExpect(jsonPath("totalTime").value(60))
                .andExpect(jsonPath("instruction").value("Add abc"));
    }

    @Test
    @DisplayName("should return 404 if recipe is not found")
    void testNotFound() throws Exception {
        // given
        doReturn(null).when(recipeService).findById(anyLong());

        // when
        mockMvc.perform(get(BASE_PATH+ "/123"))
                // then
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("should return 201 when create a recipe successful")
    void testCreate() throws Exception {
        // given
        String recipeToCreateAsJson = "{\"recipeName\": \"Noodles\", \"category\":\"MAIN_COURSE\", \"ingredients\": \"Noodles, Beef, Onion\", \"portion\": 4, \"totalTime\": 60, \"instruction\": \"Add abc\"}";
        var recipe = new Recipe(123, null, null, null, 0, 0, null);
        doReturn(recipe).when(recipeService).create(any());

        // when
        mockMvc.perform(
                        post(BASE_PATH)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(recipeToCreateAsJson)
                )
                // then
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"))
                .andExpect(header().string("Location", Matchers.equalTo(("api/v1/recipes/" +recipe.getId()))));
    }

    @Test
    @DisplayName("should validate create recipe request")
    void testValidation() throws Exception {
        // given
        String recipeToCreateAsJson = "{\"recipeName\": \"Noodles\", \"category\":\"MAIN\", \"ingredients\": \"Noodles, Beef, Onion\", \"portion\": 4, \"totalTime\": 60, \"instruction\": \"Add abc\"}";

        // when
        mockMvc.perform(
                        post(BASE_PATH)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(recipeToCreateAsJson)
                )
                // then
                .andExpect(status().isBadRequest());
    }
}
