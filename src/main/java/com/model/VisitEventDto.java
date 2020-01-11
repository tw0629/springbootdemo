package com.model;

/**
 * @author David Tian
 * @desc
 * @since 2019-09-24 16:35
 */

public class VisitEventDto {

    private VisitEventBasicInfoDto visitEventBasicInfoDto = new VisitEventBasicInfoDto();

    private String vin;

    public VisitEventBasicInfoDto getVisitEventBasicInfoDto() {
        return visitEventBasicInfoDto;
    }

    public void setVisitEventBasicInfoDto(VisitEventBasicInfoDto visitEventBasicInfoDto) {
        this.visitEventBasicInfoDto = visitEventBasicInfoDto;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    @Override
    public String toString() {
        return "VisitEventDto{" +
                "visitEventBasicInfoDto=" + visitEventBasicInfoDto +
                ", vin='" + vin + '\'' +
                '}';
    }
}
