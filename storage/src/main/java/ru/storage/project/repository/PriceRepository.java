package ru.storage.project.repository;

import ru.storage.project.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Price, Integer> {

    Price getByBookId(Integer bookId);
}
