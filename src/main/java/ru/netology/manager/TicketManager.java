package ru.netology.manager;

import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

public class TicketManager {
    private TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public void add(Ticket item) {
        repository.save(item);
    }

    public Ticket[] searchBy(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket item : repository.findAll()) {
            if (matches(item, from)) {
                if (matches(item, to)) {
                    Ticket[] tmp = new Ticket[result.length + 1];
                    System.arraycopy(result, 0, tmp, 0, result.length);
                    tmp[tmp.length - 1] = item;
                    result = tmp;
                }
            }
        }
        return result;
    }

    public boolean matches(Ticket item, String search) {
        if (item.getDepartureAirport().contains(search)) {
            return true;
        }
        if (item.getArrivalAirport().contains(search)) {
            return true;
        } else {
            return false;
        }
    }

}


