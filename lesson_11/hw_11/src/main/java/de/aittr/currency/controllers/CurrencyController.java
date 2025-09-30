package de.aittr.currency.controllers;

import de.aittr.currency.dto.CurrencyRequestDto;
import de.aittr.currency.dto.CurrencyResponseDto;
import de.aittr.currency.mapper.CurrencyMapper;
import de.aittr.currency.model.Currency;
import de.aittr.currency.repository.CurrencyRepository;
import de.aittr.currency.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@CrossOrigin
@RestController
public class CurrencyController {

    private final CurrencyMapper mapper;
    private final CurrencyService service;
    private final CurrencyRepository repository;


    @GetMapping("/rates")
    public ResponseEntity<List<CurrencyResponseDto>> getRates() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAllCurrencies());
    }


    @GetMapping("/rates/{code}")
    public ResponseEntity<?> getCurrency(@PathVariable(name = "code") String currencyCode) {
        CurrencyResponseDto currency = service.getCurrencyByCode(currencyCode);

        if (currency != null)
            return ResponseEntity.status(HttpStatus.OK).body(currency);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Код " + currencyCode + " не найден");
    }

    @PostMapping("/rates")
    public ResponseEntity<?> addCurrency(@RequestBody CurrencyRequestDto currency) {
        if (currency.getCode().isEmpty() || currency.getName().isEmpty() || currency.getCountry().isEmpty() || currency.getRate()==0)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Некорректно введенные поля");
        else
            return ResponseEntity.status(HttpStatus.CREATED).body(service.addCurrency(currency));
    }


    // myHost.de:8081/convertor?from=usd&to=jpy&amount=1000
    @GetMapping("/convertor")
    public ResponseEntity<?> convert(
            @RequestParam(defaultValue = "usd") String from,
            @RequestParam (defaultValue = "rub") String to,
            @RequestParam (required = true) double amount
    ){

        double result = service.convert(from,to,amount);
        if(result>0) {
            double rateFrom = service.getCurrencyByCode(from).getRate();
            double rateTo = service.getCurrencyByCode(to).getRate();


            return ResponseEntity.status(HttpStatus.OK).body("rateFrom=" + rateFrom + "\nrateTo=" + rateTo + "\namount=" + amount + "\nresult=" + result);
        }else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Некорректный запрос!");
            }
    }






}
