package org.sid.reactifspring.web;

import org.sid.reactifspring.dao.SocieteRepository;
import org.sid.reactifspring.dao.TransactionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebMVCController {
    private SocieteRepository societeRepository;
    private TransactionRepository transactionRepository;

    public WebMVCController(SocieteRepository societeRepository, TransactionRepository transactionRepository) {
        this.societeRepository = societeRepository;
        this.transactionRepository = transactionRepository;
    }
    @GetMapping("/index")
    public String index(Model model){

        model.addAttribute("societes",societeRepository.findAll());
        return "index";
    }
}