package barinov.coffee.bean.controller.service;

import barinov.coffee.bean.controller.model.Brigade;

public interface BrigadeService {
    Brigade saveBrigadeIfNotExist(String brigadeUuid);
}
