package self.java.validation;

import org.junit.jupiter.api.Test;
import self.java.validation.data.Level;

public class EnumTest {
    @Test
    void testEnum() {
        String name = "Fadhil Firmansyah";
        Level level = Level.PREMIUM;

        System.out.println(name + "~" + level);
        System.out.println(level.getDesc());
    }

    @Test
    void testConversion() {
        String vip = Level.PREMIUM.name();
        System.out.println(vip);

        String inputLevel = "VIP";
        try{
            Level standard = Level.valueOf(inputLevel);
            System.out.println(standard);
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Theres is no Level such a \"" + inputLevel + "\"");
        }
    }

    @Test
    void testValues() {
        Level[] levels = Level.values();

        System.out.println("There is " + levels.length + " values Level");

        int i = 1;

        for (Level level : levels) {
            System.out.println(i + ". " +level);
            i++;
        }
    }
}
