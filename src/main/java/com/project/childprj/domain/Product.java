package com.project.childprj.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    private Long id; // 글 아이디(int)
    private String productName;
    private String region;
    private Long price;
    private String content;
    private Long viewCnt;
    private LocalDateTime createDate;
    private User user;
    private ProductImg productImg;
}
