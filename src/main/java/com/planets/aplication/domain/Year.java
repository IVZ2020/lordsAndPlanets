package com.planets.aplication.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Year {

    private LocalDate localDate = LocalDate.of(
            3141,
            LocalDate.now().getMonthValue(),
            LocalDate.now().getDayOfMonth());
    private int UniverseYear = localDate.getYear();
}
