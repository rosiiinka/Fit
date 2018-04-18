package com.example.my_fit.services.mode;

import com.example.my_fit.model.entity.Mode;
import com.example.my_fit.model.view.ModeCreateRequestModel;
import com.example.my_fit.repositories.ModeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ModeServiceImpl implements ModeService {

    private final ModeRepository modeRepository;

    public ModeServiceImpl(ModeRepository modeRepository) {
        this.modeRepository = modeRepository;
    }

    @Override
    public Mode createMode(ModeCreateRequestModel model) {
        Mode mode = new Mode();
        mode.setTitle(model.getTitle());
        mode.setDescription(model.getDescription());

        return this.modeRepository.save(mode);
    }

    @Override
    public List<ModeCreateRequestModel> getAllModes() {
        ModelMapper modelMapper = new ModelMapper();

        return this.modeRepository
                .findAll()
                .stream()
                .map(x -> modelMapper.map(x, ModeCreateRequestModel.class))
                .collect(Collectors.toList());
    }

}
