package com.project.childprj.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostComment {
    private Long id;
    private Long postId;
    private User user; // 작성자
    private UserImg userImg; // 작성자 이미지
    private String content;
    private LocalDateTime createDate;
}
