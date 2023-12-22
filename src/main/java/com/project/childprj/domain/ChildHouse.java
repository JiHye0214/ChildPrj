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
    private String SIGUNNAME; //시군구명
    private String CRNAME;  // 어린이집명
    private String CRTYPENAME;   // 어린이집유형
    private String CRSTATUSNAME;    // 운영현황
    private String CRADDR;    // 상세주소
    private String CRTELNO;        // 전화번호
    private String CRHOME;      // 홈페이지
    private Integer NRTRROOMCNT;    // 보육실수
    private Integer PLGRDCO;    // 놀이터수


    private Integer CCTVINSTLCNT;   // cctv 수
    private Integer CHCRTESCNT; // 보육교직원수
    private Integer CRCAPAT;    // 정원
    private Integer CRCHCNT;    // 현원
    private Double LA;          // 위도
    private Double LO;          // 경도
    private String CRCARGBNAME; //통학버스운영여부

    public String getSIGUNNAME() {
        return SIGUNNAME;
    }

    public void setSIGUNNAME(String sigunname) {
        SIGUNNAME = sigunname;
    }


    public String getCRNAME() {
        return CRNAME;
    }


    public void setCRNAME(String crname) {
        CRNAME = crname;
    }


    public String getCRTYPENAME() {
        return CRTYPENAME;
    }
    public void setCRTYPENAME(String crtypename) { CRTYPENAME = crtypename;}

    public String getCRSTATUSNAME(){ return CRSTATUSNAME; }
    public void setCRSTATUSNAME(String crstatusname) { CRSTATUSNAME = crstatusname;}

    public String getCRADDR() {
        return CRADDR;
    }

    public void setCRADDR(String craddr) {
        CRADDR = craddr;
    }

    public String getCRTELNO() {
        return CRTELNO;
    }

    public void setCRTELNO(String crtelno) {
        CRTELNO = crtelno;
    }

    public String getCRHOME() {
        return CRHOME;
    }

    public void setCRHOME(String crhome) {
        CRHOME = crhome;
    }


    public Integer getNRTRROOMCNT() {
        return NRTRROOMCNT;
    }

    public void setNRTRROOMCNT(Integer nrtrroomcnt) {
        NRTRROOMCNT = nrtrroomcnt;
    }

    public Integer getPLGRDCO() { return PLGRDCO; }

    public void setPLGRDCO(Integer PLGRDCO) {
        this.PLGRDCO = PLGRDCO;
    }
    public Integer getCCTVINSTLCNT() {
        return CCTVINSTLCNT;
    }

    public void setCCTVINSTLCNT(Integer CCTVINSTLCNT) {
        this.CCTVINSTLCNT = CCTVINSTLCNT;
    }

    public Integer getCHCRTESCNT() {
        return CHCRTESCNT;
    }

    public void setCHCRTESCNT(Integer CHCRTESCNT) {
        this.CHCRTESCNT = CHCRTESCNT;
    }

    public Integer getCRCAPAT() {
        return CRCAPAT;
    }

    public void setCRCAPAT(Integer crcapat) {
        CRCAPAT = crcapat;
    }


    public Integer getCRCHCNT() {
        return CRCHCNT;
    }

    public void setCRCHCNT(Integer crchcnt) {
        CRCHCNT = crchcnt;
    }

    public Double getLA() {
        return LA;
    }

    public void setLA(Double la) {
        LA = la;
    }

    public Double getLO() {
        return LO;
    }

    public void setLO(Double lo) {
        LO = lo;
    }

    public String getCRCARGBNAME() {
        return CRCARGBNAME;
    }

    public void setCRCARGBNAME(String crcargbname) {
        CRCARGBNAME = crcargbname;
    }

    public static ChildHouse fromJson(JsonNode row){
        ChildHouse childHouse = new ChildHouse();
        childHouse.setSIGUNNAME(row.get("SIGUNNAME").asText());
        childHouse.setCRNAME(row.get("CRNAME").asText());
        childHouse.setCRTYPENAME(row.get("CRTYPENAME").asText());
        childHouse.setCRSTATUSNAME(row.get("CRSTATUSNAME").asText());
        childHouse.setCRADDR(row.get("CRADDR").asText());
        childHouse.setCRTELNO(row.get("CRTELNO").asText());
        childHouse.setCRHOME(row.get("CRHOME").asText());
        childHouse.setNRTRROOMCNT(row.get("NRTRROOMCNT").asInt());
        childHouse.setPLGRDCO(row.get("PLGRDCO").asInt());
        childHouse.setCCTVINSTLCNT(row.get("CCTVINSTLCNT").asInt());
        childHouse.setCHCRTESCNT(row.get("CHCRTESCNT").asInt());
        childHouse.setCRCAPAT(row.get("CRCAPAT").asInt());
        childHouse.setCRCHCNT(row.get("CRCHCNT").asInt());
        childHouse.setLA(row.get("LA").asDouble());
        childHouse.setLO(row.get("LO").asDouble());
        childHouse.setCRCARGBNAME(row.get("CRCARGBNAME").asText());

        return childHouse;
    }

}
