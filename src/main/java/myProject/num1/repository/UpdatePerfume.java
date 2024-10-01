package myProject.num1.repository;

import lombok.Data;

@Data
public class UpdatePerfume {
    private String brand;
    private String perfumeName;
    private String topNote;
    private String middleNote;
    private String baseNote;

    public UpdatePerfume() {
    }

    public UpdatePerfume(String brand, String perfumeName, String topNote, String middleNote, String baseNote) {
        this.brand = brand;
        this.perfumeName = perfumeName;
        this.topNote = topNote;
        this.middleNote = middleNote;
        this.baseNote = baseNote;
    }
}
