package com.adik.springboot.stadium.repository;

import com.adik.springboot.stadium.model.Ticket;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TicketRepository extends CrudRepository<Ticket,Long> {

}
