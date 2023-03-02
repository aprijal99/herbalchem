package org.herbal.chem.authorization.controller;

import lombok.AllArgsConstructor;
import org.herbal.chem.authorization.entity.UserAccountDto;
import org.herbal.chem.authorization.entity.UserAccountEntity;
import org.herbal.chem.authorization.mapper.UserAccountMapper;
import org.herbal.chem.authorization.service.UserAccountService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@AllArgsConstructor
public class AuthorizationServerController {
    private final UserAccountService userAccountService;
    private final UserAccountMapper userAccountMapper;
    private final PasswordEncoder passwordEncoder;

    @GetMapping(path = "/")
    public String home(Authentication authentication, Model model, @RequestParam(name = "page", required = false) String page) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        UserAccountEntity userAccountEntity = userAccountService.findUserAccount(userDetails.getUsername());
        UserAccountDto user = userAccountMapper.entityToDto(userAccountEntity);
        model.addAttribute("user", user);

        if ("edit".equals(page)) {
            model.addAttribute("page", page);
        } else {
            model.addAttribute("page", "view");
        }

        return "index";
    }

    @GetMapping(path = "/signup")
    public String signup(Model model) {
        model.addAttribute("user", new UserAccountDto());

        return "signup-form";
    }

    @PostMapping(path = "/registration")
    public String registration(@ModelAttribute(name = "user") UserAccountDto user) {
        UserAccountEntity userAccountEntity = userAccountMapper.dtoToEntity(user);
        userAccountService.saveUserAccount(userAccountEntity);

        return "redirect:/login";
    }

    @GetMapping(path = "/login")
    public String login() {
        return "login-form";
    }

    @PostMapping(path = "/update")
    public String update(@ModelAttribute(name = "user") UserAccountDto user,
                         Authentication authentication,
                         RedirectAttributes redirectAttributes) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        UserAccountEntity userAccountEntity = userAccountService.findUserAccount(userDetails.getUsername());

        if (!user.getCurrentPassword().isEmpty()) {
            if (!passwordEncoder.matches(user.getCurrentPassword(), userAccountEntity.getPassword())) {
                redirectAttributes.addFlashAttribute("flashCurrPwdError", "You typed wrong current password");

                return "redirect:/?page=edit";
            }

            user.setPassword(passwordEncoder.encode(user.getPassword()));
        } else {
            user.setPassword(userAccountEntity.getPassword());
        }

        userAccountService.updateUserAccount(user, userDetails.getUsername());

        redirectAttributes.addFlashAttribute("flashCurrPwdSuccess", "You have succeed update your data");

        return "redirect:/";
    }
}
