package com.project.childprj.service;

import com.project.childprj.domain.Kindergarden;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Map;

public interface ChildCenterService {
    // 아동센터 api 결과 데이터
    List<Map<String, Object>> getChildCenter(Integer startIndex, Integer endIndex);

    // 아동센터 페이징 목록 조회
    Object childCenterList(Integer page, String type, Model model);
}
