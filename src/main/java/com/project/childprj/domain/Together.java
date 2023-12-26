package com.project.childprj.domain;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Together {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String CODENAME;  // 분류
    private String GUNAME;    // 자치구
    private String TITLE;     // 공연/행사명
    private String DATE;      // 날짜/시간
    private String PLACE;     // 장소
    private String ORG_NAME;  // 기관명
    private String USE_TRGT;  // 이용대상
    private String USE_FEE;   // 이용요금
    private String ORG_LINK;  // 홈페이지 주소
    private String MAIN_IMG;  // 대표이미지
    private String STRTDATE;  // 시작일
    private String END_DATE;  // 종료일
    private double LOT;       // 위도(X좌표)
    private double LAT;       // 경도(Y좌표)

    public static Together fromJson(JsonNode row) {
        Together together = new Together();

        together.setCODENAME(getTextValue(row, "CODENAME"));
        together.setGUNAME(getTextValue(row, "GUNAME"));
        together.setTITLE(getTextValue(row, "TITLE"));
        together.setDATE(getTextValue(row, "DATE"));
        together.setPLACE(getTextValue(row, "PLACE"));
        together.setORG_NAME(getTextValue(row, "ORG_NAME"));
        together.setUSE_TRGT(getTextValue(row, "USE_TRGT"));
        together.setUSE_FEE(getTextValue(row, "USE_FEE"));
        together.setORG_LINK(getTextValue(row, "ORG_LINK"));
        together.setMAIN_IMG(getTextValue(row, "MAIN_IMG"));
        together.setSTRTDATE(getTextValue(row, "STRTDATE"));
        together.setEND_DATE(getTextValue(row, "END_DATE"));
        together.setLOT(getDoubleValue(row, "LAT"));
        together.setLAT(getDoubleValue(row, "LOT"));

        return together;
    }

    private static String getTextValue(JsonNode row, String fieldName) {
        JsonNode node = row.get(fieldName);
        return (node != null && !node.isNull()) ? node.asText() : null;
    }

    private static double getDoubleValue(JsonNode row, String fieldName) {
        JsonNode node = row.get(fieldName);
        return (node != null && !node.isNull()) ? node.asDouble() : 0.0;
    }

//    @Override
//    public String toString() {
//        return "Together [id=" + id + ", CODENAME=" + CODENAME + ", GUNAME=" + GUNAME + ", TITLE="
//                + TITLE + ", DATE=" + DATE + ",  PLACE=" + PLACE + ", ORG_NAME=" + ORG_NAME
//                + ", USE_TRGT=" + USE_TRGT + ", ORG_LINK=" + ORG_LINK + ", MAIN_IMG=" + MAIN_IMG
//                + ", STRTDATE=" + STRTDATE + ", END_DATE=" + END_DATE
//                + ", LOT=" + LOT + ", LAT=" + LAT
//                + "]";
//    }

}
