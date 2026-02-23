package controller;

import models.Conta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.ContaService;

import java.util.List;


@RestController
@RequestMapping("/conta")
public class ContaController {

    @Autowired
    private ContaService contaService;
}
