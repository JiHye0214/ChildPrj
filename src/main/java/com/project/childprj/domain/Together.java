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

    private String CODENAME;

    private String GUNAME;

    private String TITLE;

    private String DATE;

    private String PLACE;

    private String ORG_NAME;

    private String USE_TRGT;

    private String USE_FEE;

    private String ORG_LINK;

    private String MAIN_IMG;

    private String STRTDATE;

    private String END_DATE;

    private double LOT;

    private double LAT;

    public String getCODENAME() {
        return CODENAME;
    }

    public void setCODENAME(String CODENAME) {
        this.CODENAME = CODENAME;
    }

    public String getGUNAME() {
        return GUNAME;
    }

    public void setGUNAME(String GUNAME) {
        this.GUNAME = GUNAME;
    }

    public String getTITLE() {
        return TITLE;
    }

    public void setTITLE(String TITLE) {
        this.TITLE = TITLE;
    }

    public String getDATE() {
        return DATE;
    }

    public void setDATE(String DATE) {
        this.DATE = DATE;
    }

    public String getPLACE() {
        return PLACE;
    }

    public void setPLACE(String PLACE) {
        this.PLACE = PLACE;
    }

    public String getORG_NAME() {
        return ORG_NAME;
    }

    public void setORG_NAME(String ORG_NAME) {
        this.ORG_NAME = ORG_NAME;
    }

    public String getUSE_TRGT() {
        return USE_TRGT;
    }

    public void setUSE_TRGT(String USE_TRGT) {
        this.USE_TRGT = USE_TRGT;
    }

    public String getUSE_FEE() {
        return USE_FEE;
    }

    public void setUSE_FEE(String USE_FEE) {
        this.USE_FEE = USE_FEE;
    }

    public String getORG_LINK() {
        return ORG_LINK;
    }

    public void setORG_LINK(String ORG_LINK) {
        this.ORG_LINK = ORG_LINK;
    }

    public String getMAIN_IMG() {
        return MAIN_IMG;
    }

    public void setMAIN_IMG(String MAIN_IMG) {
        this.MAIN_IMG = MAIN_IMG;
    }

    public String getSTRTDATE() {
        return STRTDATE;
    }

    public void setSTRTDATE(String STRTDATE) {
        this.STRTDATE = STRTDATE;
    }

    public String getEND_DATE() {
        return END_DATE;
    }

    public void setEND_DATE(String END_DATE) {
        this.END_DATE = END_DATE;
    }

    public double getLOT() {
        return LOT;
    }

    public void setLOT(double LOT) {
        this.LOT = LOT;
    }

    public double getLAT() {
        return LAT;
    }

    public void setLAT(double LAT) {
        this.LAT = LAT;
    }

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
        together.setLOT(getDoubleValue(row, "LOT"));
        together.setLAT(getDoubleValue(row, "LAT"));

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

    @Override
    public String toString() {
        return "Together [id=" + id + ", CODENAME=" + CODENAME + ", GUNAME=" + GUNAME + ", TITLE="
                + TITLE + ", DATE=" + DATE + ",  PLACE=" + PLACE + ", ORG_NAME=" + ORG_NAME
                + ", USE_TRGT=" + USE_TRGT + ", ORG_LINK=" + ORG_LINK + ", MAIN_IMG=" + MAIN_IMG
                + ", STRTDATE=" + STRTDATE + ", END_DATE=" + END_DATE
                + ", LOT=" + LOT + ", LAT=" + LAT
                + "]";
    }


}