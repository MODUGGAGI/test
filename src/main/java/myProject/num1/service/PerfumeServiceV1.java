package myProject.num1.service;

import lombok.RequiredArgsConstructor;
import myProject.num1.item.Perfume;
import myProject.num1.repository.PerfumeRepository;
import myProject.num1.repository.PerfumeSearchCond;
import myProject.num1.repository.UpdatePerfume;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PerfumeServiceV1 implements PerfumeService{

    private final PerfumeRepository perfumeRepository;
    @Override
    public Perfume save(Perfume item) {
        return perfumeRepository.save(item);
    }

    @Override
    public void update(Long perfumeId, UpdatePerfume updateParam) {
        perfumeRepository.update(perfumeId, updateParam);
    }

    @Override
    public Optional<Perfume> findById(Long id) {
        return perfumeRepository.findById(id);
    }

    @Override
    public List<Perfume> findItems(PerfumeSearchCond Cond) {
        return perfumeRepository.findAll(Cond);
    }
}
