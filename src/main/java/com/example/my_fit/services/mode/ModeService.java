package com.example.my_fit.services.mode;

import com.example.my_fit.model.entity.Mode;
import com.example.my_fit.model.view.ModeCreateRequestModel;

public interface ModeService {

    Mode createMode(ModeCreateRequestModel model);
}
