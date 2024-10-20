package barinov.coffee.bean.controller.dto;

public class BrigadeLossDTO {

    private String brigadeUuid;

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
