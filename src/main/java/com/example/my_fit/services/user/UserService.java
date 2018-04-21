package com.example.my_fit.services.user;

import com.example.my_fit.model.entity.User;
import com.example.my_fit.model.view.UserRegisterRequestModel;

public interface UserService {

    User register(UserRegisterRequestModel model);

}
