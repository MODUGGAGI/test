package myProject.num1.repository;

import lombok.Data;
import myProject.num1.item.Perfume;

@Data
public class PerfumeSearchCond {
    private String perfumeName;
    private String brand;
    private String topNote;
    private String middleNote;
    private String baseNote;

    public PerfumeSearchCond() {
    }

    public PerfumeSearchCond(String perfumeName, String brand, String topNote, String middleNote, String baseNote) {
        this.perfumeName = perfumeName;
        this.brand = brand;
        this.topNote = topNote;
        this.middleNote = middleNote;
        this.baseNote = baseNote;
    }
}
