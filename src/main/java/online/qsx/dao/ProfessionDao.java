package online.qsx.dao;

import online.qsx.model.ProfessionModel;

public interface ProfessionDao extends Dao<ProfessionModel>{
    ProfessionModel queryById(ProfessionModel professionModel);
}
