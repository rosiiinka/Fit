package com.example.my_fit.services.mode;

import com.example.my_fit.model.entity.Mode;
import com.example.my_fit.model.view.ModeCreateRequestModel;

import java.util.List;

public interface ModeService {

    Mode createMode(ModeCreateRequestModel model);

    List<ModeCreateRequestModel> getAllModes();
}
