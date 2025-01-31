package guru.springframework.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class Ingredient {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  private String description;
  private BigDecimal amount;

  @ManyToOne private Recipe recipe;

  @OneToOne(fetch = FetchType.EAGER)
  private UnitOfMeasure unitOfMeasure;

  public Ingredient() {}

  public Ingredient(String description, BigDecimal amount, UnitOfMeasure unitOfMeasure) {
    this.description = description;
    this.amount = amount;
    this.unitOfMeasure = unitOfMeasure;
  }
}
