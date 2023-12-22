package com.project.childprj.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TogetherDTO {

   @JsonProperty("CODENAME")
   private String codename;
   @JsonProperty("GUNAME")
   private String guname;
   @JsonProperty("TITLE")
   private String title;
   @JsonProperty("DATE")
   private String date;
   @JsonProperty("PLACE")
   private String place;
   @JsonProperty("ORG_NAME")
   private String org_name;
   @JsonProperty("USE_TRGT")
   private String use_trgt;
   @JsonProperty("USE_FEE")
   private String use_fee;

   @JsonProperty("ORG_LINK")
   private String org_link;
   @JsonProperty("MAIN_IMG")
   private String main_img;
   @JsonProperty("STRTDATE")
   private String strtdate;
   @JsonProperty("END_DATE")
   private String end_date;
   @JsonProperty("LOT")
   private double lot;
   @JsonProperty("LAT")
   private double lat;

   public String getCodename() {
      return codename;
   }

   public void setCodename(String codename) {
      this.codename = codename;
   }

   public String getGuname() {
      return guname;
   }

   public void setGuname(String guname) {
      this.guname = guname;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public String getDate() {
      return date;
   }

   public void setDate(String date) {
      this.date = date;
   }

   public String getPlace() {
      return place;
   }

   public void setPlace(String place) {
      this.place = place;
   }

   public String getOrg_name() {
      return org_name;
   }

   public void setOrg_name(String org_name) {
      this.org_name = org_name;
   }

   public String getUse_trgt() {
      return use_trgt;
   }

   public void setUse_trgt(String use_trgt) {
      this.use_trgt = use_trgt;
   }

   public String getUse_fee() {
      return use_fee;
   }

   public void setUse_fee(String use_fee) {
      this.use_fee = use_fee;
   }

   public String getOrg_link() {
      return org_link;
   }

   public void setOrg_link(String org_link) {
      this.org_link = org_link;
   }

   public String getMain_img() {
      return main_img;
   }

   public void setMain_img(String main_ing) {
      this.main_img = main_img;
   }

   public String getStrtdate() {
      return strtdate;
   }

   public void setStrtdate(String strtdate) {
      this.strtdate = strtdate;
   }

   public String getEnd_date() {
      return end_date;
   }

   public void setEnd_date(String end_date) {
      this.end_date = end_date;
   }

   public double getLot() {
      return lot;
   }

   public void setLot(double lot) {
      this.lot = lot;
   }

   public double getLat() {
      return lat;
   }

   public void setLat(double lat) {
      this.lat = lat;
   }

   public static List<TogetherDTO> fromJson(String jsonData) throws IOException {
      ObjectMapper objectMapper = new ObjectMapper();
      JsonNode rootNode = objectMapper.readTree(jsonData);

      ArrayNode rows = (ArrayNode) rootNode.get("culturalEventInfo").get("row");
      List<TogetherDTO> result = new ArrayList<>();
      for (JsonNode row : rows) {
         TogetherDTO togetherDTO = new TogetherDTO();
         togetherDTO.setCodename(row.get("CODENAME").asText());
         togetherDTO.setGuname(row.get("GUNAME").asText());
         togetherDTO.setTitle(row.get("TITLE").asText());
         togetherDTO.setDate(row.get("DATE").asText());
         togetherDTO.setPlace(row.get("PLACE").asText());
         togetherDTO.setOrg_name(row.get("ORG_NAME").asText());
         togetherDTO.setUse_trgt(row.get("USE_TRGT").asText());
         togetherDTO.setUse_fee(row.get("USE_FEE").asText());
         togetherDTO.setOrg_link(row.get("ORG_LINK").asText());
         togetherDTO.setMain_img(row.get("MAIN_IMG").asText());
         togetherDTO.setStrtdate(row.get("STRTDATE").asText());
         togetherDTO.setEnd_date(row.get("END_DATE").asText());
         togetherDTO.setLot(row.get("LOT").asDouble());
         togetherDTO.setLat(row.get("LAT").asDouble());

      }

      return result;
   }
   // api의 rows에서 객체의 각각 필드에 설정
   public static TogetherDTO fromJson(JsonNode row) {
      TogetherDTO togetherDTO = new TogetherDTO();

      togetherDTO.setCodename(row.get("CODENAME").asText());
      togetherDTO.setGuname(row.get("GUNAME").asText());
      togetherDTO.setTitle(row.get("TITLE").asText());
      togetherDTO.setDate(row.get("DATE").asText());
      togetherDTO.setPlace(row.get("PLACE").asText());
      togetherDTO.setOrg_name(row.get("ORG_NAME").asText());
      togetherDTO.setUse_trgt(row.get("USE_TRGT").asText());
      togetherDTO.setUse_fee(row.get("USE_FEE").asText());
      togetherDTO.setOrg_link(row.get("ORG_LINK").asText());
      togetherDTO.setMain_img(row.get("MAIN_IMG").asText());
      togetherDTO.setStrtdate(row.get("STRTDATE").asText());
      togetherDTO.setEnd_date(row.get("END_DATE").asText());
      togetherDTO.setLot(row.get("LOT").asDouble());
      togetherDTO.setLat(row.get("LAT").asDouble());

      return togetherDTO;
   }
}
