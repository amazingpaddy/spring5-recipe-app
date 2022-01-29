package guru.springframework.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CategoryTest {

  static Category category;

  @BeforeAll
  static void setup() {
    category = new Category();
  }

  @Test
  void getId() {
    category.setId(4L);
    assertEquals(4L, category.getId());
  }

  @Test
  void getDescription() {
    category.setDescription("Testing");
    assertEquals("Testing", category.getDescription());
  }
}
