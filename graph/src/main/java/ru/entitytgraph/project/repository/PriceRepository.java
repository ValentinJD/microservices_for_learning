package ru.entitytgraph.project.repository;

import ru.entitytgraph.project.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Price, Integer> {

    Price getByBookId(Integer bookId);
}
