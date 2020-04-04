import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void shouldCalculateForRegisteredAndMinBonus() {
        BonusService service = new BonusService();

        //подготавливаем данные:
        long amount = 3400 ;
        boolean registered = true;
        long expected = 1;

        //вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredAndEqualLimit() {
        BonusService service = new BonusService();

        //подготавливаем данные:
        long amount = 1_666_667 ;
        boolean registered = true;
        long expected = 500;

        //вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredAndBonusZero() {
        BonusService service = new BonusService();

        //подготавливаем данные:
        long amount = 3000 ;
        boolean registered = true;
        long expected = 0;

        //вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        //подготавливаем данные:
        long amount = 1000_60;
        boolean registered = true;
        long expected = 30;

        //вызываем целевой метод:
        long actual = service.calculate(amount,registered);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        //подготавливаем данные:
        long amount = 1_000_000_60;
        boolean registered = true;
        long expected = 500;

        //вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForUnregisteredAndEqualLimit() {
        BonusService service = new BonusService();

        //подготавливаем данные:
        long amount = 5_000_000;
        boolean registered = false;
        long expected = 500;

        //вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForUnregisteredAndUnderLimit() {
        BonusService service = new BonusService();

        //подготавливаем данные:
        long amount = 1000000;
        boolean registered = false;
        long expected = 100;

        //вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForUnregisteredAndOverLimit() {
        BonusService service = new BonusService();

        //подготавливаем данные:
        long amount = 6_000_000;
        boolean registered = false;
        long expected = 500;

        //вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForUnregisteredAndMinBonusLimit() {
        BonusService service = new BonusService();

        //подготавливаем данные:
        long amount = 10_000;
        boolean registered = false;
        long expected = 1;

        //вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForUnregisteredAndBonusZero() {
        BonusService service = new BonusService();

        //подготавливаем данные:
        long amount = 1_000;
        boolean registered = false;
        long expected = 0;

        //вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }
}