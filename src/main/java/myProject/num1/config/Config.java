package myProject.num1.config;

import myProject.num1.repository.PerfumeRepository;
import myProject.num1.repository.memory.MemoryPerfumeRepository;
import myProject.num1.service.PerfumeService;
import myProject.num1.service.PerfumeServiceV1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    //변경사항 github에 push 해보기
    @Bean
    public PerfumeService perfumeService() {
        return new PerfumeServiceV1(perfumeRepository());
    }

    @Bean
    public PerfumeRepository perfumeRepository() {
        return new MemoryPerfumeRepository();
    }
}
