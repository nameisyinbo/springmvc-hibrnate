package online.qsx.dao;

import online.qsx.model.HobbyModel;

public interface HobbyDao extends Dao<HobbyModel>{
    HobbyModel queryById(HobbyModel hobbyModel);

}
