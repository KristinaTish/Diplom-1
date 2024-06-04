import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType type;
    private final String name;
    private final float price;


    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;

    }

    @Parameterized.Parameters
    public static  Object[][] getBurgerIngredient(){
        return new Object[][]{
                {FILLING, "Листовой салат", 20.5f},
                {SAUCE, "Чили", 5.0f},
                {FILLING, "Камамбер", 200.15f},
                {SAUCE, "Брусничный", 10.0f},
                {FILLING, "К", 0.5f},
                {SAUCE, "", 15.5f},
                {FILLING, "Дыня", 0.0f},
        };
    }

    @Test
    public void getIngredientPriceTest(){
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(price, ingredient.getPrice(), 0.01) ;
    }

    @Test
    public void getIngredientNameTest(){
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void  getIngredientType(){
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(type, ingredient.getType());
    }

    @Test
    public void constructorIngredientTest(){
        Ingredient constructor = new Ingredient(type, name, price);
        assertEquals(type, constructor.getType());
        assertEquals(name, constructor.getName());
        assertEquals(price, constructor.getPrice(),0.01);
    }
}
