package de.aittr.currency.controllers;

import de.aittr.currency.model.Conversion;
import de.aittr.currency.service.ConverterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ConverterController {
    private final ConverterService service;


    // myHost.de:8081/convertor?from=usd&to=jpy&amount=1000
    @GetMapping("/convertor")
    public Conversion convert(
            @RequestParam(defaultValue = "usd") String from,
            @RequestParam (defaultValue = "rub") String to,
            @RequestParam (required = true) double amount
    ){
        return service.convert(from,to,amount);
    }


}
