package com.departmentService.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {
    private Long Id;
    private String departmentName;
    private String departmentDescription;
    private String departmentCode;
}
