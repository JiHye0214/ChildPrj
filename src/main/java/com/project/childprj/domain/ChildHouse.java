package com.project.childprj.domain;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

//어린이집
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChildHouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String CRNAME;        // 어린이집명
    private String CRTYPENAME;    // 어린이집유형
    private String CRADDR;        // 상세주소
    private String CRTELNO;       // 전화번호
    private String CRHOME;        // 홈페이지
    private Integer NRTRROOMCNT;  // 보육실수
    private Integer CRCAPAT;      // 정원
    private Integer CRCHCNT;      // 현원
    private Double LA;            // 위도
    private Double LO;            // 경도
    private String CRCARGBNAME;   // 통학버스운영여부

    public static ChildHouse fromJson(JsonNode row){
        ChildHouse childHouse = new ChildHouse();
        childHouse.setCRNAME(row.get("CRNAME").asText());
        childHouse.setCRTYPENAME(row.get("CRTYPENAME").asText());
        childHouse.setCRADDR(row.get("CRADDR").asText());
        childHouse.setCRTELNO(row.get("CRTELNO").asText());
        childHouse.setCRHOME(row.get("CRHOME").asText());
        childHouse.setNRTRROOMCNT(row.get("NRTRROOMCNT").asInt());
        childHouse.setCRCAPAT(row.get("CRCAPAT").asInt());
        childHouse.setCRCHCNT(row.get("CRCHCNT").asInt());
        childHouse.setLA(row.get("LA").asDouble());
        childHouse.setLO(row.get("LO").asDouble());
        childHouse.setCRCARGBNAME(row.get("CRCARGBNAME").asText());

        return childHouse;
    }

}
