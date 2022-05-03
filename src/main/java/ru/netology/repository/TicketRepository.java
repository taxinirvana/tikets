package ru.netology.repository;

import ru.netology.domain.Ticket;

public class TicketRepository {
    private Ticket[] items = new Ticket[0];

    public void save(Ticket item) {
        Ticket[] tmp = new Ticket[items.length + 1];
        System.arraycopy(items, 0, tmp, 0, items.length);
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public Ticket[] findAll() {
        return items;
    }

    public Ticket[] removeById(int id) {
        Ticket[] tmp = new Ticket[items.length - 1];
        int index = 0;
        for (Ticket item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
            items = tmp;
        }
        return items;
    }
}
