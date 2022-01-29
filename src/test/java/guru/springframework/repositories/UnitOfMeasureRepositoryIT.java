package guru.springframework.repositories;

import guru.springframework.domain.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
class UnitOfMeasureRepositoryIT {

  @Autowired UnitOfMeasureRepository unitOfMeasureRepository;

  @BeforeEach
  void setUp() {}

  @Test
  void findUnitOfMeasureByDescription() {
    Optional<UnitOfMeasure> teaspoonOptional =
        unitOfMeasureRepository.findUnitOfMeasureByDescription("Teaspoon");
    assertEquals("Teaspoon", teaspoonOptional.get().getDescription());
  }

  @Test
  void findUnitOfMeasureByDescriptionCup() {
    Optional<UnitOfMeasure> teaspoonOptional =
        unitOfMeasureRepository.findUnitOfMeasureByDescription("Cup");
    assertEquals("Cup", teaspoonOptional.get().getDescription());
  }
}
