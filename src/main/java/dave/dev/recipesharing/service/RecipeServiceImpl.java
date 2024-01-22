package dave.dev.recipesharing.service;

import dave.dev.recipesharing.exception.RecipeNotFoundException;
import dave.dev.recipesharing.model.Recipe;
import dave.dev.recipesharing.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    @Override
    public Recipe getRecipeById(Long id) {
        return recipeRepository.findById(id)
                .orElseThrow(() -> new RecipeNotFoundException(id));
    }

    @Override
    public Recipe createRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public Recipe updateRecipe(Long id, Recipe updatedRecipe) {
        Recipe existingRecipe = getRecipeById(id);
        existingRecipe.setName(updatedRecipe.getName());
        existingRecipe.setDescription(updatedRecipe.getDescription());

        return recipeRepository.save(existingRecipe);
    }

    @Override
    public void deleteRecipe(Long id) {
        Recipe existingRecipe = getRecipeById(id);
        recipeRepository.delete(existingRecipe);
    }
}
