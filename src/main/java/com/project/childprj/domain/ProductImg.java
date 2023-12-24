package com.project.childprj.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductImg {
    private Long id;
    private String fileName; // 지정
    private String sourceName; // 원본
    private Long productId;
}
