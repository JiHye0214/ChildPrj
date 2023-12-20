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
public class Post {
    private Long id; // 글 아이디
    private String title;
    private String content;
    private Long viewCnt;
    private LocalDateTime createDate;
    private User user;
}
