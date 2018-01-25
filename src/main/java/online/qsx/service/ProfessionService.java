package online.qsx.service;

import online.qsx.model.ProfessionModel;

public interface ProfessionService extends Service<ProfessionModel>{
    ProfessionModel queryById(ProfessionModel professionModel);
}
