package myProject.num1.service;

import myProject.num1.item.Perfume;
import myProject.num1.repository.PerfumeSearchCond;
import myProject.num1.repository.UpdatePerfume;

import java.util.List;
import java.util.Optional;

public interface PerfumeService {

    Perfume save(Perfume item);

    void update(Long perfumeId, UpdatePerfume updateParam);

    Optional<Perfume> findById(Long id);

    List<Perfume> findItems(PerfumeSearchCond Cond);
}
