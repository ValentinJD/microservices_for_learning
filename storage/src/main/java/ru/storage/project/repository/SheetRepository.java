package ru.storage.project.repository;

import ru.storage.project.model.Sheet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SheetRepository extends JpaRepository<Sheet, Integer> {

}
