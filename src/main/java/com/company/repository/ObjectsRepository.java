package com.company.repository;

import com.company.model.Objects;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObjectsRepository extends JpaRepository<Objects, Integer> {
}
