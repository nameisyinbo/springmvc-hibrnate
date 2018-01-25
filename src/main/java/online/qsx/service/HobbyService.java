package online.qsx.service;

import online.qsx.model.HobbyModel;

public interface HobbyService extends Service<HobbyModel>{
    HobbyModel queryById(HobbyModel hobbyModel);
}
