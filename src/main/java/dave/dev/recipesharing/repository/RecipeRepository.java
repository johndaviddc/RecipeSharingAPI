package dave.dev.recipesharing.repository;

import dave.dev.recipesharing.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
