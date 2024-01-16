package bot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminPanelController {
    @GetMapping("/admin/settings")
    public String showSettingsPage(Model model) {
        return "admin/settings";
    }
}
