package com.example.my_fit.services.mode;

import com.example.my_fit.model.entity.Mode;
import com.example.my_fit.model.service.ModeServiceModel;
import com.example.my_fit.model.view.ModeViewModel;

import java.util.List;

public interface ModeService {

    Mode createMode(ModeViewModel model);

    List<ModeViewModel> getAllModes();

    ModeServiceModel getById(Long id);


//    void deleteMode(Long id);
//
//    void editMode(Long id, ModeBindingModel mode);
}
