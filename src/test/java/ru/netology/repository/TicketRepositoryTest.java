package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;

import static org.junit.jupiter.api.Assertions.*;

class TicketRepositoryTest {
    private TicketRepository repository = new TicketRepository();
    Ticket one = new Ticket(1, 6500, "OMS", "VKO", 180);
    Ticket two = new Ticket(2, 8000, "VKO", "AYT", 180);
    Ticket three = new Ticket(3, 9500, "OMS", "IKT", 300);

    @Test
    public void shouldUseRemoveById() {
        repository.save(one);
        repository.save(two);
        repository.save(three);

        Ticket[] expected = new Ticket[]{one, three};
        Ticket[] actual = repository.removeById(2);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldUseRemoveByIdOneElement() {
        repository.save(one);

        Ticket[] expected = new Ticket[0];
        Ticket[] actual = repository.removeById(1);

        assertArrayEquals(expected, actual);
    }

}