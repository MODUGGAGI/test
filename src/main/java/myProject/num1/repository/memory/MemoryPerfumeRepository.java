package myProject.num1.repository.memory;

import myProject.num1.item.Perfume;
import myProject.num1.repository.PerfumeRepository;
import myProject.num1.repository.PerfumeSearchCond;
import myProject.num1.repository.UpdatePerfume;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class MemoryPerfumeRepository implements PerfumeRepository {
    private static final Map<Long, Perfume> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Perfume save(Perfume Perfume) {
        Perfume.setId(++sequence);
        store.put(Perfume.getId(), Perfume);
        return Perfume;
    }

    @Override
    public Optional<Perfume> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Perfume> findAll(PerfumeSearchCond cond) {
        String perfumeName = cond.getPerfumeName();
        String brand = cond.getBrand();
        String topNote = cond.getTopNote();
        String middleNote = cond.getMiddleNote();
        String baseNote = cond.getBaseNote();

        return store.values().stream()
                .filter(perfume -> {
                    // perfumeName 필터링 (비어있으면 패스)
                    if (ObjectUtils.isEmpty(perfumeName)) {
                        return true;
                    }
                    return perfume.getPerfumeName().contains(perfumeName);
                })
                .filter(perfume -> {
                    // brand 필터링 (비어있으면 패스)
                    if (ObjectUtils.isEmpty(brand)) {
                        return true;
                    }
                    return perfume.getBrand().toLowerCase().contains(brand.toLowerCase());
                })
                .filter(perfume -> {
                    // topNote 필터링 (비어있으면 패스)
                    if (ObjectUtils.isEmpty(topNote)) {
                        return true;
                    }
                    return perfume.getTopNote().contains(topNote);
                })
                .filter(perfume -> {
                    // middleNote 필터링 (비어있으면 패스)
                    if (ObjectUtils.isEmpty(middleNote)) {
                        return true;
                    }
                    return perfume.getMiddleNote().contains(middleNote);
                })
                .filter(perfume -> {
                    // baseNote 필터링 (비어있으면 패스)
                    if (ObjectUtils.isEmpty(baseNote)) {
                        return true;
                    }
                    return perfume.getBaseNote().contains(baseNote);
                })
                .collect(Collectors.toList());
    }

    @Override
    public void update(Long PerfumeId, UpdatePerfume updateParam) {
        Perfume findPerfume = findById(PerfumeId).orElseThrow();
        findPerfume.setBrand(updateParam.getBrand());
        findPerfume.setPerfumeName(updateParam.getPerfumeName());
        findPerfume.setTopNote(updateParam.getTopNote());
        findPerfume.setMiddleNote(updateParam.getMiddleNote());
        findPerfume.setBaseNote(updateParam.getBaseNote());
    }

    public void clearStore() {
        store.clear();
    }
}
