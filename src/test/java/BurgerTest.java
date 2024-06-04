import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger;
    float priceTag;
    float priceTag2;
    float priceTag3;
    String name;

    @Mock
    private Bun mockBun;

    @Mock
    private Ingredient mockIngredient1;

    @Mock
    private Ingredient mockIngredient2;

    @Before
    public void setUp() {
        burger = new Burger();
        name = "Булка";
        priceTag = 24.5f;
        priceTag2 = 15.04f;
        priceTag3 = 5.08f;
        Mockito.when(mockBun.getName()).thenReturn(name);
        Mockito.when(mockBun.getPrice()).thenReturn(priceTag);
        Mockito.when(mockIngredient1.getName()).thenReturn("Помидорки");
        Mockito.when(mockIngredient1.getType()).thenReturn(FILLING);
        Mockito.when(mockIngredient1.getPrice()).thenReturn(priceTag2);
        Mockito.when(mockIngredient2.getName()).thenReturn("Тар-тар");
        Mockito.when(mockIngredient2.getType()).thenReturn(SAUCE);
        Mockito.when(mockIngredient2.getPrice()).thenReturn(priceTag3);
    }


    @Test
    public void setBunsTest() {
        burger.setBuns(mockBun);
        assertEquals(mockBun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        assertEquals(2, burger.ingredients.size());
        assertEquals(mockIngredient1, burger.ingredients.get(0));
        assertEquals(mockIngredient2, burger.ingredients.get(1));
    }

    @Test
    public void removeIngredientsTest() {
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        burger.removeIngredient(0);
        assertEquals(1, burger.ingredients.size());
        assertEquals(mockIngredient2, burger.ingredients.get(0));
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        burger.moveIngredient(0, 1);
        assertEquals(mockIngredient2, burger.ingredients.get(0));
        assertEquals(mockIngredient1, burger.ingredients.get(1));
    }

    @Test
    public void getPriceTest() {
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        float expected = (priceTag * 2) + priceTag2;
        assertEquals(expected, burger.getPrice(), 0.01);
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        String expected = String.format(
                "(==== Булка ====)%n" +
                        "= filling Помидорки =%n" +
                        "= sauce Тар-тар =%n" +
                        "(==== Булка ====)%n" +
                        "%nPrice: 69,120003%n"
        );
        assertEquals(expected, burger.getReceipt());

    }
}
