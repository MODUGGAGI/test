package myProject.num1.repository;

import myProject.num1.item.Perfume;

import java.util.List;
import java.util.Optional;

public interface PerfumeRepository {
    Perfume save(Perfume item);

    void update(Long itemId, UpdatePerfume updateParam);

    Optional<Perfume> findById(Long id);

    List<Perfume> findAll(PerfumeSearchCond cond);
}
