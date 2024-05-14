package com.example.brtapp;

import java.util.ArrayList;
import java.util.Collection;

public class TicketCollection {
        private Collection<Ticket> list;

    public TicketCollection(){
        list=new ArrayList<>();
    }

    public void insert(Ticket ticket){
        list.add(ticket);
    }

    public void remove(Ticket ticket){list.remove(ticket);}

}
