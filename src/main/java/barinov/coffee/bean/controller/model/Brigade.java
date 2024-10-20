package barinov.coffee.bean.controller.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "brigades")
public class Brigade {

    @Id
    private UUID uuid;

    public Brigade(UUID uuid) {
        this.uuid = uuid;
    }

    public Brigade() {

    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public void setStringUuid(String uuid) {
        this.uuid = UUID.fromString(uuid);
    }
}
