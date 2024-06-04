import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.*;

public class IngredientTypeTest {

    @Test
    public void testIngredientTypeValues(){
        IngredientType[] types = IngredientType.values();
        assertEquals(2, types.length);
    }

    @Test
    public void testIngredientTypeValueOf(){
        assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
        assertEquals(IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }
}
