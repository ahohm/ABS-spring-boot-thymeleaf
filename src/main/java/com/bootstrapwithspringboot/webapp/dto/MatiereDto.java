package com.bootstrapwithspringboot.webapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatiereDto {
    private long id;

    private String libel;

    private float numberHours;

    private long permit;
}
