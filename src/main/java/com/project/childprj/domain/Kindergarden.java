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
public class Kindergarden {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String KINDERNAME;  // 유치원명
    private String ESTABLISH;   // 설립유형
    private String LDGRNAME;    // 원장명
    private String ADDR;        // 주소
    private String TELNO;       // 전화번호
    private String HPADDR;      // 홈페이지
    private String OPERTIME;    // 운영시간
    
	public String getKINDERNAME() {
		return KINDERNAME;
	}
	public void setKINDERNAME(String kindername) {
		KINDERNAME = kindername;
	}
	public String getESTABLISH() {
		return ESTABLISH;
	}
	public void setESTABLISH(String establish) {
		ESTABLISH = establish;
	}
	public String getLDGRNAME() {
		return LDGRNAME;
	}
	public void setLDGRNAME(String ldgrname) {
		LDGRNAME = ldgrname;
	}
	public String getADDR() {
		return ADDR;
	}
	public void setADDR(String addr) {
		ADDR = addr;
	}
	public String getTELNO() {
		return TELNO;
	}
	public void setTELNO(String telno) {
		TELNO = telno;
	}
	public String getHPADDR() {
		return HPADDR;
	}
	public void setHPADDR(String hpaddr) {
		HPADDR = hpaddr;
	}
	public String getOPERTIME() {
		return OPERTIME;
	}
	public void setOPERTIME(String opertime) {
		OPERTIME = opertime;
	}
    
	// api의 row에서 객체의 각각 필드에 설정
	public static Kindergarden fromJson(JsonNode row) {
		Kindergarden kindergarden = new Kindergarden();
		kindergarden.setKINDERNAME(row.get("KINDERNAME").asText());
		kindergarden.setESTABLISH(row.get("ESTABLISH").asText());
		kindergarden.setLDGRNAME(row.get("LDGRNAME").asText());
		kindergarden.setADDR(row.get("ADDR").asText());
		kindergarden.setTELNO(row.get("TELNO").asText());
		kindergarden.setHPADDR(row.get("HPADDR").asText());
		kindergarden.setOPERTIME(row.get("OPERTIME").asText());
		
		return kindergarden;
	}

	@Override
	public String toString() {
		return "Kindergarden [id=" + id + ", KINDERNAME=" + KINDERNAME + ", ESTABLISH=" + ESTABLISH + ", LDGRNAME="
				+ LDGRNAME + ", ADDR=" + ADDR + ", TELNO=" + TELNO + ", HPADDR=" + HPADDR + ", OPERTIME=" + OPERTIME
				+ "]";
	}
    
}
