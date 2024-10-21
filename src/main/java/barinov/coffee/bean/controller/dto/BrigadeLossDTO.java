package barinov.coffee.bean.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO для отображения потерь зерна бригады")
public class BrigadeLossDTO {

    @Schema(description = "UUID Бригады")
    private String brigadeUuid;

    @Schema(description = "Процент потери зерна")
    private double percentageOfLoss;

    public BrigadeLossDTO(String brigadeUuid, double percentageOfLoss) {
        this.brigadeUuid = brigadeUuid;
        this.percentageOfLoss = percentageOfLoss;
    }

    public BrigadeLossDTO() {
    }

    public String getBrigadeUuid() {
        return brigadeUuid;
    }

    public void setBrigadeUuid(String brigadeUuid) {
        this.brigadeUuid = brigadeUuid;
    }

    public double getPercentageOfLoss() {
        return percentageOfLoss;
    }

    public void setPercentageOfLoss(double percentageOfLoss) {
        this.percentageOfLoss = percentageOfLoss;
    }
}
