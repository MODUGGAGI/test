package myProject.num1.item;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Perfume {
    private Long id;
    private String brand;
    private String perfumeName;
    private String topNote;
    private String middleNote;
    private String baseNote;

    public Perfume() {
    }

    public Perfume(String brand, String perfumeName, String topNote, String middleNote, String baseNote) {
        this.brand = brand;
        this.perfumeName = perfumeName;
        this.topNote = topNote;
        this.middleNote = middleNote;
        this.baseNote = baseNote;
    }
}
