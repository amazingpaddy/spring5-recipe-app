package guru.springframework.bootstrap;

import guru.springframework.domain.*;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {
  private final RecipeRepository recipeRepository;
  private final CategoryRepository categoryRepository;
  private final UnitOfMeasureRepository unitOfMeasureRepository;

  public DataLoader(
      RecipeRepository recipeRepository,
      CategoryRepository categoryRepository,
      UnitOfMeasureRepository unitOfMeasureRepository) {
    this.recipeRepository = recipeRepository;
    this.categoryRepository = categoryRepository;
    this.unitOfMeasureRepository = unitOfMeasureRepository;
  }

  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {
    recipeRepository.saveAll(getRecipies());
  }

  private List<Recipe> getRecipies() {
    List<Recipe> recipes = new LinkedList<>();
    UnitOfMeasure unitOfMeasureEach =
            unitOfMeasureRepository
                    .findUnitOfMeasureByDescription("Each")
                    .orElseThrow(() -> new RuntimeException("Expected UOM not found"));
    UnitOfMeasure unitOfMeasureTablespoon =
            unitOfMeasureRepository
                    .findUnitOfMeasureByDescription("Tablespoon")
                    .orElseThrow(() -> new RuntimeException("Expected UOM not found"));
    UnitOfMeasure unitOfMeasureTeaspoon =
            unitOfMeasureRepository
                    .findUnitOfMeasureByDescription("Teaspoon")
                    .orElseThrow(() -> new RuntimeException("Expected UOM not found"));
    UnitOfMeasure unitOfMeasureDash =
            unitOfMeasureRepository
                    .findUnitOfMeasureByDescription("Dash")
                    .orElseThrow(() -> new RuntimeException("Expected UOM not found"));
    UnitOfMeasure unitOfMeasurePint =
            unitOfMeasureRepository
                    .findUnitOfMeasureByDescription("Pint")
                    .orElseThrow(() -> new RuntimeException("Expected UOM not found"));
    UnitOfMeasure unitOfMeasureCup =
            unitOfMeasureRepository
                    .findUnitOfMeasureByDescription("Cup")
                    .orElseThrow(() -> new RuntimeException("Expected UOM not found"));
    Category indianCategory =
            categoryRepository
                    .findCategoryByDescription("Indian")
                    .orElseThrow(() -> new RuntimeException("Expected Category not found"));
    Category persianCategory =
            categoryRepository
                    .findCategoryByDescription("Persian")
                    .orElseThrow(() -> new RuntimeException("Expected Category not found"));
    Category thaiCategory =
            categoryRepository
                    .findCategoryByDescription("Thai")
                    .orElseThrow(() -> new RuntimeException("Expected Category not found"));

    Recipe briyani = new Recipe();
    briyani.setDescription("Vegetable briyani");
    briyani.setCookTime(30);
    briyani.setPrepTime(30);
    briyani.setServings(4);
    briyani.setDifficulty(Difficulty.MEDIUM);
    briyani.setDirections("""
            Soak the rice in 3 cups (24 oz) water for 30 minutes.
            
            After the rice has soaked, drain the water using a colander.
            
            1- Heat a pot full of water, add 3 green cardamom, 2 cloves and 3/4 teaspoon salt to it. Let it come to a boil.
            
            2- Add rice, stir with a spoon.
            
            3- Let it cook uncovered (don’t lower the heat) until it’s almost cooked (around 70-75% cooked but not fully cooked). There should be a bite to it. This takes around 6 to 7 minutes.
            
            4- Remove pan from heat and drain rice in a colander. You may add a teaspoon of ghee to the rice. Set aside.
            
            Caramelize onion & cashews and pan fry the veggies
            
            5- Heat 1.5 tablespoons ghee in a pan on medium heat. Once hot, add 1 sliced onion to it and cook until they turn golden brown and caramelize.
            
            This takes around 8 to 9 minutes. Remove on a plate.
            
            6- To the same pan, now add cashews and cook until golden brown, around 1 to 2 minutes. Remove on plate and set aside.
            
            7- To same pan add potato, cook for 2 minutes until light brown. Remove on a plate.
            
            8- To the same pan, now add cauliflower, beans and carrots. Saute for 2 to 3 minutes until veggies appear light brown. Remove on a plate.
            
            PS: This pan-frying veggies is an additional step and you can skip it and directly cook the veggies later on. I like doing the extra step as it gives the veggies a nice texture.
            
            9- Heat 2 tablespoons milk in a pan. Once warm, add saffron strands (crush it before adding).
            
            Let it sit for 10 minutes for that beautiful yellow color. Saffron milk is ready, set it aside.
            
            10- Crush ginger, garlic and chili using a mortar and pestle. Set aside.
            
            11- Heat 1.5 tablespoons oil in a pan/pot on medium heat. Add cumin seeds, cinnamon stick, bay leaf, peppercorns, remaining 3 cardamom and remaining 2 cloves.
            
            Stir and let the spices sizzle for few seconds. Add the sliced onions also add 1/4 teaspoon salt.
            
            12- Cook for 3 to 4 minutes until onions turn light brown. Then add the crushed ginger-garlic and green chilies paste.
            
            Cook for 2 minutes until the raw smell goes away.
            
            13- Remove pan from heat and whisk in the yogurt, whisking continuously until it’s all absorbed.
            
            Put the pan back on heat. Add all the veggies and toss to combine.
            
            14- Add the biryani masala and kashmiri red chili powder.
            
            15- Add 1/4 cup water. Let it cook for around 6 to 7 minutes until veggies are almost cooked but not overcooked. They should be firm to bite.
            
            You may also cover the pan, I usually cook uncovered. There shouldn’t be much water left, it should be kind of thick mixture.
            
            Remove from heat.
            
            17- Now take a heavy bottom pan. I first grease the bottom of the pan with ghee.
            
            18- Then add a layer of rice (half of the rice).
            
            19- Top with half of fried onion, half of fried cashews and half of cilantro and mint. Add 1/2 teaspoon of rose water.
            
            20- Now place the veggies on top (all of it).
            
            21- Then add the remaining rice on top of the veggies. Then top it with remaining with fried onion, cashews, cilantro and mint.
            
            Add the prepared saffron milk on top.
            
            22- Add the remaining 1 teaspoon rose water on top.
            
            23- And finally drizzle 1 teaspoon ghee on top. Sprinkle some biryani masala.
            
            24- I did 2 layers of rice and 1 layer of veggies. If your pan in small you may do more layers, but the end layer should always be of rice.
            
            Cover the pan tightly with aluminium foil. Then cover with a fitted lid.
            
            Heat a flat pan on medium heat. Once hot, reduce the flame to lowest. Place your biryani pot on top of the pan and let it cook for 25 to 30 minutes on lowest heat (dum).
            
            Scoop out the biryani from the bottom of the pan so that each serving has both the veggies and the rice.
            
            Serve vegetable biryani with a side of raita.
            """);
    Notes briyaniNotes = new Notes();
    briyaniNotes.setRecipeNotes("""
            Biryani is a rice dish made with layers of rice, spices and traditionally meat (but it our case veggies!).
            
            Here are the key components of biryani:
            
            Rice: of course rice is the base and key ingredient of this dish. Long grain basmati rice is what is traditionally used.
            
            I highly recommend using extra-long grain aged basmati rice for biryani. I use the Zebra Sella Basmati Rice and it works so well.
            
            Veggies: so traditionally meat is used in biryani but since we are making veg biryani, we are using assorted vegetables here.
            
            I have used potato, cauliflower, beans and carrots.
            
            You can use green peas, mushrooms or even paneer would be a good addition.
            
            Spices: aromatic and exotic spices  (both whole and ground) are a must for a good biryani. Most commonly used are cardamom, peppercorns, cumin, saffron, garam masala.
            
            Also rose water or kewra water is often used to flavor the biryani.
            
            Fresh herbs & nuts: herbs like mint, cilantro and nuts like cashews are often added as garnishing and to add more texture and flavors to the biryani.
            
            Caramelized onions also make a great addition.
            
            The veggies and rice are layered and the biryani is then cooked on low heat with some heavy object placed on top of the pot of biryani.
            
            This process is called “dum” and hence it’s also known as Vegetable Dum Biryani.
            """);
    briyani.setNotes(briyaniNotes);
    briyani.addIngredient(new Ingredient("Basmati Rice", new BigDecimal(1), unitOfMeasureCup));
    briyani.addIngredient(new Ingredient("Ghee", new BigDecimal(2), unitOfMeasureTablespoon));
    briyani.addIngredient(new Ingredient("Ginger Garlic paste", new BigDecimal(2), unitOfMeasureTeaspoon));
    briyani.addIngredient(new Ingredient("Vegetables", new BigDecimal(2), unitOfMeasureEach));
    briyani.addIngredient(new Ingredient("Salt", new BigDecimal(2), unitOfMeasureTeaspoon));
    briyani.addIngredient(new Ingredient("Water", new BigDecimal(2), unitOfMeasurePint));
    briyani.addIngredient(new Ingredient("Cinnamon", new BigDecimal(2), unitOfMeasureDash));
    
    briyani.addCategories(indianCategory, persianCategory);
    recipes.add(briyani);

    Recipe tomYumSoup = new Recipe();
    tomYumSoup.setDescription("Vegetable Tom Yum Soup");
    tomYumSoup.setCookTime(15);
    tomYumSoup.setPrepTime(15);
    tomYumSoup.setServings(4);
    tomYumSoup.setDifficulty(Difficulty.EASY);
    tomYumSoup.setDirections("""
            Heat a large pot or Dutch oven over medium heat. Once hot, add oil or water.
            Add lemongrass (optional) and onion and sauté for 5 minutes, stirring occasionally. The onions should become translucent and soft and slightly browned.
            Add fresh ginger, chili peppers, shiitake mushrooms, garlic, and curry paste (which is added to substitute for fresh makrut lime leaf and lemongrass) and stir. Sauté for 4-5 minutes, stirring occasionally.
            Add vegetable broth, coconut milk, a few slices of lime peel, diced (drained) tomatoes, coconut aminos, and coconut sugar and stir to combine. Bring back to a boil, then reduce heat to a simmer, cover, and cook for 10-15 minutes.
            Add the lime juice and stir. Simmer for a few more minutes. Then taste and adjust flavor as needed, adding more lime for acidity, coconut sugar for sweetness, coconut aminos (or salt) for saltiness / depth of flavor, or coconut milk for creaminess.
            Optional: Remove lemongrass and lime peel before serving using a slotted spoon or fork (or just eat around it).
             Serve as is, or over zucchini noodles, kelp noodles, or cooked rice noodles. You could also serve it over white rice or brown rice. Garnish with fresh cilantro for a pop of color (optional).
            Store leftovers covered in the refrigerator up to 4-5 days, or in the freezer up to 1 month. Reheat on the stovetop, covered, until warmed through.
            """);
    Notes tomYumNotes = new Notes();
    tomYumNotes.setRecipeNotes("""
            I was swooning over the recipe but didn’t have a number of the ingredients, so I started making swaps and it turned out lovely.
            
            In place of traditional ingredients like makrut lime leaves, lemongrass, galangal, fresh tomato, Thai chilies, and tamari I subbed lime peel, green curry paste, ginger, canned tomatoes, serrano pepper, and coconut aminos.
            
            Chances are most of you don’t have the more traditional items on hand either. So I thought I’d share my “lazy girl” version in the event you want soup but don’t want to make a trip to the grocery store.
            """);
    tomYumSoup.setNotes(tomYumNotes);
    tomYumSoup.addIngredient(new Ingredient("Sliced shiitake mushrooms", new BigDecimal(1), unitOfMeasureCup));
    tomYumSoup.addIngredient(new Ingredient("Vegetable Broth", new BigDecimal(2), unitOfMeasureCup));
    tomYumSoup.addIngredient(new Ingredient("coconut oil", new BigDecimal(2), unitOfMeasureTablespoon));
    tomYumSoup.addIngredient(new Ingredient("Fresh minced ginger", new BigDecimal(2), unitOfMeasureTeaspoon));
    tomYumSoup.addIngredient(new Ingredient("Vegetables", new BigDecimal(2), unitOfMeasureEach));
    tomYumSoup.addIngredient(new Ingredient("Salt", new BigDecimal(2), unitOfMeasureTeaspoon));
    tomYumSoup.addIngredient(new Ingredient("Lemon", new BigDecimal(2), unitOfMeasurePint));
    tomYumSoup.addIngredient(new Ingredient("Red chili peppers", new BigDecimal(2), unitOfMeasureDash));
    
    tomYumSoup.addCategories(thaiCategory, indianCategory);
    recipes.add(tomYumSoup);
    return recipes;
  }
}
