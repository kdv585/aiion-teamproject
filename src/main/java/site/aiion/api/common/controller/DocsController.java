package site.aiion.api.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class DocsController {

    @GetMapping("/docs")
    public RedirectView redirectToSwagger() {
        return new RedirectView("/swagger-ui.html");
    }
}
