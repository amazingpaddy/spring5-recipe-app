package guru.springframework.services;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class RecipeServiceImplTest {
  RecipeServiceImpl recipeService;

  @Mock RecipeRepository recipeRepository;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
    recipeService = new RecipeServiceImpl(recipeRepository);
  }

  @Test
  void getRecipes() {
    Set<Recipe> recipeSet = Set.of(new Recipe());
    when(recipeRepository.findAll()).thenReturn(recipeSet);
    Set<Recipe> recipes = recipeService.getRecipes();
    assertEquals(1, recipes.size());
    verify(recipeRepository, times(1)).findAll();
  }
}
