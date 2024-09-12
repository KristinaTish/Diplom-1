
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private final String bunType;
    private final float priceTag;

    public BunTest(String bunType, float priceTag) {
        this.bunType = bunType;
        this.priceTag = priceTag;
    }

    @Parameterized.Parameters
    public static Object[][] getBunParameters() {
        return new Object[][]{
                {"Флюоресцентная булка", 988.5f},
                {"Шу", 8.5f},
                {"", 999999999.5f},
                {"Флюоресцентная булка", 0},
                {"Флюоресцентная булка", -56},

        };
    }

    @Test
    public void getBunName() {
        Bun bun = new Bun(bunType, priceTag);
        assertEquals("Имя булки не совпадает с заданным в конструкторе", bunType, bun.getName());
    }

    @Test
    public void getBunPrice() {
        Bun bun = new Bun(bunType, priceTag);
        assertEquals("Цена не совпадает", priceTag, bun.getPrice(), 0.001);
    }

    @Test
    public void constructorTest() {
        Bun testBun = new Bun(bunType, priceTag);
        assertEquals(bunType, testBun.getName());
        assertEquals(priceTag, testBun.getPrice(), 0.001);
    }

}
