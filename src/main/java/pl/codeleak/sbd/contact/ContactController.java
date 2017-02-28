package pl.codeleak.sbd.contact;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/contact")
public class ContactController {

    @GetMapping
    public String contactForm(Model model) {
        model.addAttribute(new ContactDetails());
        return "contact/contact-form";
    }

    @PostMapping
    public String contact(@Valid @ModelAttribute ContactDetails contactDetails, Errors errors, RedirectAttributes ra) {
        if (errors.hasErrors()) {
            return "contact/contact-form";
        }
        ra.addFlashAttribute("contact.success-message", "contact.messages.success");
        return "redirect:/contact";
    }

}
