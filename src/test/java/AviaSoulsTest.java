import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class AviaSoulsTest {
    @Test
    public void shouldIfThePriceOfTheFirstIsGreaterThanThePriceOfTheSecond() {
        Ticket ticket1 = new Ticket("Москва", "Канкун", 250000, 8, 17);
        Ticket ticket2 = new Ticket("Москва", "Анталия", 100000, 9, 13);
        int expect = 1;
        int actual = ticket1.compareTo(ticket2);
        Assertions.assertEquals(expect, actual);
    }

    @Test
    public void shouldIfThePriceOfTheSecondIsLessThanThePriceOfTheFirst() {
        Ticket ticket1 = new Ticket("Москва", "Канкун", 250000, 8, 17);
        Ticket ticket2 = new Ticket("Москва", "Анталия", 100000, 9, 13);
        int expect = -1;
        int actual = ticket2.compareTo(ticket1);
        Assertions.assertEquals(expect, actual);
    }

    @Test
    public void shouldWhenSamePrice() {
        Ticket ticket1 = new Ticket("Москва", "Канкун", 100000, 8, 17);
        Ticket ticket2 = new Ticket("Москва", "Анталия", 100000, 9, 13);
        int expect = 0;
        int actual = ticket1.compareTo(ticket1);
        Assertions.assertEquals(expect, actual);
    }


    @Test
    public void shouldSortByPrice() {
        Ticket ticket1 = new Ticket("Москва", "Канкун", 250000, 8, 17);
        Ticket ticket2 = new Ticket("Москва", "Анталия", 100000, 9, 13);
        Ticket ticket3 = new Ticket("Москва", "Даболим", 140000, 10, 18);


        TicketTimeComparator timeComparator = new TicketTimeComparator();

        Ticket[] tickets = {ticket1, ticket2, ticket3};
        Arrays.sort(tickets, timeComparator);
        Ticket[] expect = {ticket2, ticket3, ticket1};

        Assertions.assertArrayEquals(expect, tickets);
    }

    @Test
    public void shouldAirportMatch() {
        Ticket ticket1 = new Ticket("Москва", "Канкун", 250000, 8, 17);
        Ticket ticket2 = new Ticket("Париж", "Анталия", 100000, 9, 13);
        Ticket ticket3 = new Ticket("Берлин", "Даболим", 140000, 10, 18);
        Ticket ticket4 = new Ticket("Москва", "Канкун", 250000, 9, 18);

        AviaSouls souls = new AviaSouls();
        TicketTimeComparator timeComparator = new TicketTimeComparator();
        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);

        Ticket[] expect = {ticket1, ticket4};
        Ticket[] actual = souls.searchAndSortBy("Москва", "Канкун", timeComparator);
        Assertions.assertArrayEquals(expect, actual);
    }

    @Test
    public void shouldMismatchBetweenAirports() {
        Ticket ticket1 = new Ticket("Москва", "Канкун", 250000, 8, 17);
        Ticket ticket2 = new Ticket("Париж", "Анталия", 100000, 9, 13);
        Ticket ticket3 = new Ticket("Берлин", "Даболим", 140000, 10, 18);
        Ticket ticket4 = new Ticket("Москва", "Канкун", 250000, 9, 18);

        AviaSouls souls = new AviaSouls();
        TicketTimeComparator timeComparator = new TicketTimeComparator();
        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);

        Ticket[] expect = {};
        Ticket[] actual = souls.searchAndSortBy("Москва", "Берлин", timeComparator);
        Assertions.assertArrayEquals(expect, actual);
    }

    @Test
    void shouldFindAll() {
        Ticket ticket1 = new Ticket("Москва", "Канкун", 250000, 8, 17);
        Ticket ticket2 = new Ticket("Москва", "Анталия", 100000, 9, 13);
        Ticket ticket3 = new Ticket("Москва", "Даболим", 140000, 10, 18);

        AviaSouls souls = new AviaSouls();
        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);

        Ticket[] expect = {ticket1, ticket2, ticket3};
        Ticket[] actual = souls.findAll();
        Assertions.assertArrayEquals(expect, actual);
    }
}

