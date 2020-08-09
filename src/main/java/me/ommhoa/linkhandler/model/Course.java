package me.ommhoa.linkhandler.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    // KURZUS(ID, TANAR_ID, NYELV_ID, TOTAL_ORASZAM, KEZDES, VEGE, ORABER, JARULEK, SZINT)
    @Id
    private String id;
    @ManyToOne
    private Teacher teacher;
    @ManyToOne
    private Language language;
    private int totalHours;
    private Date startDate;
    private Date endDate;
    private int hourlyWage;
    private int contribution;
    private LanguageLevel level;
}
