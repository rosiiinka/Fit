package com.example.my_fit.mode.service;

import com.example.my_fit.mode.model.binding.ModeBindingModel;
import com.example.my_fit.mode.model.entity.Mode;
import com.example.my_fit.mode.model.service.ModeServiceModel;
import com.example.my_fit.mode.model.view.ModeViewModel;

import java.util.List;

public interface ModeService {

    Mode createMode(ModeViewModel model);

    List<ModeViewModel> getAllModes();

    ModeServiceModel getById(Long id);


//    void deleteMode(Long id);
//
//    void editMode(Long id, ModeBindingModel mode);
}
