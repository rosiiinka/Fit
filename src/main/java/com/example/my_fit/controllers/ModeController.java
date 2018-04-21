package com.example.my_fit.controllers;

import com.example.my_fit.model.view.ModeViewModel;
import com.example.my_fit.services.mode.ModeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ModeController {

    private final ModeService modeService;

    public ModeController(ModeService modeService) {
        this.modeService = modeService;
    }

    @GetMapping("/modes")
//    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ModelAndView modes( ModelAndView modelAndView) {
        modelAndView.setViewName("modes/modes");

        modelAndView.addObject("modes", this.modeService.getAllModes());

        return modelAndView;
    }

    @GetMapping("/modes/mode/{id}")
//    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ModelAndView mode( ModelAndView modelAndView, @PathVariable Long id) {
        modelAndView.setViewName("modes/mode");

        modelAndView.addObject("modes", this.modeService.getAllModes());
        modelAndView.addObject("mode", this.modeService.getById(id));

        return modelAndView;
    }

    @GetMapping("/modes/create_mode")
//    @PreAuthorize("hasRole('ADMIN')")
    public ModelAndView createMode() {
        return new ModelAndView("modes/createMode.html");
    }

    @PostMapping("/modes/create_mode")
//    @PreAuthorize("hasRole('ADMIN')")
    public ModelAndView createMode(ModeViewModel model) {
        this.modeService.createMode(model);

        return new ModelAndView("redirect:/modes");
    }

//    @GetMapping("/edit/{id}")
//    //    @PreAuthorize("hasRole('ADMIN')")
//    public ModelAndView editMode(@PathVariable Long id, ModelAndView modelAndView, Model model, ModelMapper modelMapper) {
//        ModeServiceModel modeById = this.modeService.getById(id);
//
//        modelAndView.setViewName("createMode");
//
//        if(!model.containsAttribute("modeInput")) {
//            ModeBindingModel bindingModel = modelMapper.map(modeById, ModeBindingModel.class);
//
//            model.addAttribute("modeInput", bindingModel);
//        }
//
//        ModeViewModel viewModel = new ModeViewModel();
//
//        viewModel.setId(modeById.getId());
//
//        modelAndView.addObject("modeViewModel", viewModel);
//
//        return modelAndView;
//    }
//
//    @PostMapping("/edit/{id}")
//    //    @PreAuthorize("hasRole('ADMIN')")
//    public ModelAndView editModeConfirm(@PathVariable Long id, @Valid @ModelAttribute(name = "modeInput") ModeBindingModel modeBindingModel, BindingResult bindingResult, ModelAndView modelAndView, RedirectAttributes redirectAttributes) {
//        if(bindingResult.hasErrors()) {
//            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.modeInput", bindingResult);
//            redirectAttributes.addFlashAttribute("modeInput", modeBindingModel);
//
//            modelAndView.setViewName("redirect:createMode");
//        } else {
//            this.modeService.editMode(id, modeBindingModel);
//            modelAndView.setViewName("redirect:/modes");
//        }
//
//        return modelAndView;
//    }
//
//    @GetMapping("/delete/{id}")
//    //    @PreAuthorize("hasRole('ADMIN')")
//    public ModelAndView deleteMode(@PathVariable Long id, ModelAndView modelAndView, Model model, ModelMapper modelMapper) {
//        ModeServiceModel modeById = this.modeService.getById(id);
//
//        modelAndView.setViewName("createMode");
//
//        model.addAttribute("modeInput", modelMapper.map(modeById, ModeBindingModel.class));
//
//        ModeViewModel viewModel = new ModeViewModel();
//        viewModel.setId(modeById.getId());
//
//        modelAndView.addObject("modeViewModel", viewModel);
//
//        return modelAndView;
//    }
//
//    @PostMapping("/delete/{id}")
//    //    @PreAuthorize("hasRole('ADMIN')")
//    public ModelAndView deleteConfirm(@PathVariable Long id, ModelAndView modelAndView) {
//        this.modeService.deleteMode(id);
//
//        modelAndView.setViewName("redirect:/modes");
//
//        return modelAndView;
//    }
}
