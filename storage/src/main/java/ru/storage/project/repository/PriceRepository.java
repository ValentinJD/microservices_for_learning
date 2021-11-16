package ru.storage.project.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import ru.storage.project.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Price, Integer>, JpaSpecificationExecutor<Price>,
        QuerydslPredicateExecutor<Price> {
    Price getByBookId(Integer bookId);
}
