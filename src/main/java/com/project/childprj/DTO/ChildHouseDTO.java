package com.project.childprj.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChildHouseDTO {
    @JsonProperty("SIGUNNAME")
    private String sigunName;     // 시군구명

    @JsonProperty("CRNAME")
    private String crName;        // 어린이집명

    @JsonProperty("CRTYPENAME")
    private String crTypeName;    // 어린이집유형
    @JsonProperty("CRSTATUSNAME")
    private String crStatusName;    // 운영현황

    @JsonProperty("CRADDR")
    private String crAddr;        // 상세주소

    @JsonProperty("CRTELNO")
    private String crTelNo;       // 전화번호

    @JsonProperty("CRHOME")
    private String crHome;        // 홈페이지

    @JsonProperty("NRTRROOMCNT")
    private Integer nrtrRoomCnt;   // 보육실수

    @JsonProperty("PLGRDCO")
    private Integer plgrdCo;

    @JsonProperty("CCTVINSTLCNT")
    private Integer cctvInstlCnt;


    @JsonProperty("CHCRTESCNT")
    private Integer chcrtesCnt;

    @JsonProperty("CRCAPAT")
    private Integer crCapat;      // 정원

    @JsonProperty("CRCHCNT")
    private Integer crChCnt;      // 현원

    @JsonProperty("LA")
    private Double latitude;      // 위도

    @JsonProperty("LO")
    private Double longitude;     // 경도

    @JsonProperty("CRCARGBNAME")
    private String crCargbName;   // 통학버스운영여부

    public String getSigunName() {
        return sigunName;
    }

    public String getCrName() {
        return crName;
    }

    public String getCrTypeName() {
        return crTypeName;
    }

    public String getCrStatusName(){ return crStatusName; }

    public String getCrAddr() { return crAddr; }

    public String getCrTelNo() {
        return crTelNo;
    }

    public String getCrHome() {
        return crHome;
    }

    public Integer getNrtrRoomCnt() { return nrtrRoomCnt; }

    public Integer getPlgrdCo() {  return plgrdCo; }

    public Integer getCctvInstlCnt() { return cctvInstlCnt; }

    public Integer getChcrtesCnt() { return chcrtesCnt; }
    public Integer getCrCapat() { return crCapat; }

    public Integer getCrChCnt() { return crChCnt; }

    public Double getLatitude() { return latitude; }

    public Double getLongitude() { return longitude; }

    public String getCrCargbName() { return crCargbName; }

    // Setter 메서드들
    public void setSigunName(String sigunName) {
        this.sigunName = sigunName;
    }

    public void setCrName(String crName) {
        this.crName = crName;
    }

    public void setCrTypeName(String crTypeName) {
        this.crTypeName = crTypeName;
    }

    public void setCrStatusName(String crStatusName){ this.crStatusName = crStatusName; }

    public void setCrAddr(String crAddr) {
        this.crAddr = crAddr;
    }

    public void setCrTelNo(String crTelNo) {
        this.crTelNo = crTelNo;
    }

    public void setCrHome(String crHome) {
        this.crHome = crHome;
    }

    public void setNrtrRoomCnt(Integer nrtrRoomCnt) {
        this.nrtrRoomCnt = nrtrRoomCnt;
    }

    public void setPlgrdCo(Integer plgrdCo) { this.plgrdCo = plgrdCo; }

    public void setCctvInstlCnt(Integer cctvInstlCnt) { this.cctvInstlCnt = cctvInstlCnt; }

    public void setChcrtesCnt(Integer chcrtesCnt) { this.chcrtesCnt = chcrtesCnt; }

    public void setCrCapat(Integer crCapat) {
        this.crCapat = crCapat;
    }

    public void setCrChCnt(Integer crChCnt) {
        this.crChCnt = crChCnt;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public void setCrCargbName(String crCargbName) {
        this.crCargbName = crCargbName;
    }

    public static List<ChildHouseDTO> fromJson(String jsonData) throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(jsonData);

        ArrayNode rows = (ArrayNode) rootNode.get("ChildCareInfo").get("row");
        List<ChildHouseDTO> result = new ArrayList<>();
        for(JsonNode row : rows){
            ChildHouseDTO childHouseDTO = new ChildHouseDTO();
            childHouseDTO.setSigunName(row.get("SIGUNNAME").asText());
            childHouseDTO.setCrName(row.get("CRNAME").asText());
            childHouseDTO.setCrTypeName(row.get("CRTYPENAME").asText());
            childHouseDTO.setCrStatusName(row.get("CRSTATUSNAME").asText());
            childHouseDTO.setCrAddr(row.get("CRADDR").asText());
            childHouseDTO.setCrTelNo(row.get("CRTELNO").asText());
            childHouseDTO.setCrHome(row.get("CRHOME").asText());
            childHouseDTO.setNrtrRoomCnt(row.get("NRTRROOMCNT").asInt());
            childHouseDTO.setPlgrdCo(row.get("PLGRDCO").asInt());
            childHouseDTO.setCctvInstlCnt(row.get("CCTVINSTLCNT").asInt());
            childHouseDTO.setChcrtesCnt(row.get("CHCRTESCNT").asInt());
            childHouseDTO.setCrCapat(row.get("CRCAPAT").asInt());
            childHouseDTO.setCrChCnt(row.get("CRCHCNT").asInt());
            childHouseDTO.setLatitude(row.get("LA").asDouble());
            childHouseDTO.setLongitude(row.get("LO").asDouble());
            childHouseDTO.setCrCargbName(row.get("CRCARGBNAME").asText());

        }
        return result;
    }

    public static ChildHouseDTO fromJson(JsonNode row){
        ChildHouseDTO childHouseDTO = new ChildHouseDTO();
        childHouseDTO.setSigunName(row.get("SIGUNNAME").asText());
        childHouseDTO.setCrName(row.get("CRNAME").asText());
        childHouseDTO.setCrTypeName(row.get("CRTYPENAME").asText());
        childHouseDTO.setCrAddr(row.get("CRADDR").asText());
        childHouseDTO.setCrTelNo(row.get("CRTELNO").asText());
        childHouseDTO.setCrHome(row.get("CRHOME").asText());
        childHouseDTO.setNrtrRoomCnt(row.get("NRTRROOMCNT").asInt());
        childHouseDTO.setPlgrdCo(row.get("PLGRDCO").asInt());
        childHouseDTO.setCctvInstlCnt(row.get("CCTVINSTLCNT").asInt());
        childHouseDTO.setChcrtesCnt(row.get("CHCRTESCNT").asInt());
        childHouseDTO.setCrCapat(row.get("CRCAPAT").asInt());
        childHouseDTO.setCrChCnt(row.get("CRCHCNT").asInt());
        childHouseDTO.setLatitude(row.get("LA").asDouble());
        childHouseDTO.setLongitude(row.get("LO").asDouble());
        childHouseDTO.setCrCargbName(row.get("CRCARGBNAME").asText());

        return childHouseDTO;
    }

}
