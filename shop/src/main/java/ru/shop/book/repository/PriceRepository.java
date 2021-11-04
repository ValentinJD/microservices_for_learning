package ru.shop.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.shop.book.model.Price;

public interface PriceRepository extends JpaRepository<Price, Integer> {
}
