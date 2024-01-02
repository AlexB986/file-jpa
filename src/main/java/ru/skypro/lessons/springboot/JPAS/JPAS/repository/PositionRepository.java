package ru.skypro.lessons.springboot.JPAS.JPAS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.skypro.lessons.springboot.JPAS.JPAS.model.Position;

public interface PositionRepository extends JpaRepository<Position,Integer> {
    @Query(value = "SELECT * FROM Position  WHERE role = :positionName",nativeQuery = true)
    Position findBYName(String positionName);
}
