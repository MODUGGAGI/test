package myProject.num1;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import myProject.num1.item.Perfume;
import myProject.num1.repository.PerfumeRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@Slf4j
@RequiredArgsConstructor
public class TestDataInit {

    private final PerfumeRepository perfumeRepository;

    /**
     * 확인용 초기 데이터 추가
     */
    @EventListener(ApplicationReadyEvent.class)
    public void initData() {
        log.info("test data init");
        perfumeRepository.save(new Perfume("TOM FORD", "오드 우드", "우드", "우드", "우드"));
        perfumeRepository.save(new Perfume("TOM FORD", "쏠레이 블랑", "코코넛", "코코넛", "코코넛"));
        perfumeRepository.save(new Perfume("CHANEL", "안테우스", "가죽", "가죽", "가죽"));
    }
}
