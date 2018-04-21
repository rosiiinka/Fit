package com.example.my_fit.services.mode;

import com.example.my_fit.model.entity.Mode;
import com.example.my_fit.model.service.ModeServiceModel;
import com.example.my_fit.model.view.ModeViewModel;
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
    public Mode createMode(ModeViewModel model) {
        Mode mode = new Mode();
        mode.setId(model.getId());
        mode.setTitle(model.getTitle());
        mode.setDescription(model.getDescription());

        return this.modeRepository.save(mode);
    }

    @Override
    public List<ModeViewModel> getAllModes() {
        ModelMapper modelMapper = new ModelMapper();

        return this.modeRepository
                .findAll()
                .stream()
                .map(x -> modelMapper.map(x, ModeViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public ModeServiceModel getById(Long id) {
        ModelMapper modelMapper = new ModelMapper();

        return modelMapper.map(this.modeRepository.findById(id), ModeServiceModel.class);
    }

//    @Override
//    public void editMode(Long id, ModeBindingModel mode) {
//        ModelMapper modelMapper = new ModelMapper();
//
//        Mode modeEntity = this.modeRepository
//                .findById(id)
//                .orElse(null);
//
//        if(modeEntity == null) return;
//
//        modelMapper.map(mode, modeEntity);
//
//        modeEntity.setTitle(mode.getTitle());
//        modeEntity.setDescription(mode.getDescription());
//
//        this.modeRepository.save(modeEntity);
//    }
//
//    @Override
//    public void deleteMode(Long id) {
//        if(this.modeRepository.findById(id).orElse(null) != null) {
//            this.modeRepository.deleteById(id);
//        }
//    }

}
