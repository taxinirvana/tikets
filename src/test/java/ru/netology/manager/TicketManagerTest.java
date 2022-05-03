package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {

    private TicketRepository repository = new TicketRepository();
    private TicketManager manager = new TicketManager(repository);

    Ticket one = new Ticket(1, 6500, "OMS", "VKO", 180);
    Ticket two = new Ticket(2, 8000, "VKO", "AYT", 180);
    Ticket three = new Ticket(3, 9500, "OMS", "IKT", 300);
    Ticket four = new Ticket(4, 5000, "OMS", "VKO", 180);
    Ticket five = new Ticket(5, 6500, "VKO", "KJA", 240);

    @Test
    public void shouldUseSearchBy() {
        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.searchBy("OMS", "IKT");

        Ticket[] expected = new Ticket[]{three};
        Ticket[] actual = manager.searchBy("OMS", "IKT");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldUseSearchByOneElement() {
        manager.add(five);
        manager.searchBy("VKO", "KJA");

        Ticket[] expected = new Ticket[]{five};
        Ticket[] actual = manager.searchBy("VKO", "KJA");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldUseSearchByTwoElement() {
        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);
        manager.add(five);
        manager.searchBy("OMS", "VKO");

        Ticket[] expected = new Ticket[]{four, one};
        Ticket[] actual = manager.searchBy("OMS", "VKO");
        Arrays.sort(actual);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldUseSearchByNoTicket() {
        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.searchBy("VKO", "KJA");

        Ticket[] expected = new Ticket[0];
        Ticket[] actual = manager.searchBy("VKO", "KJA");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldUseSearchByNoElement() {
        manager.searchBy("OMS", "IKT");

        Ticket[] expected = new Ticket[0];
        Ticket[] actual = manager.searchBy("OMS", "IKT");

        assertArrayEquals(expected, actual);
    }


}