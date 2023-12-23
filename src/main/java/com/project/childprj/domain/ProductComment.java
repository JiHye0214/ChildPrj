package com.project.childprj.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductComment {
    private Long productId; // 어느 글의 댓글
    private Long id; // 댓글 id
    private User user; // 댓글 작성자
    private UserImg userImg; // 작성자 이미지
    private String content;
    private LocalDateTime createDate;
}
