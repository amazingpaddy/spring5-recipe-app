package guru.springframework.domain;

import javax.persistence.*;

@Entity
public class Notes {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private long id;

  @OneToOne private Recipe recipe;

  @Lob private String recipeNotes;

  public Notes() {}

  public Notes(Recipe recipe) {
    this.recipe = recipe;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Recipe getRecipe() {
    return recipe;
  }

  public void setRecipe(Recipe recipe) {
    this.recipe = recipe;
  }

  public String getRecipeNotes() {
    return recipeNotes;
  }

  public void setRecipeNotes(String recipeNotes) {
    this.recipeNotes = recipeNotes;
  }
}
