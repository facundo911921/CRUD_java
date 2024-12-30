package com.Facundo.CrudApi.Controller;

import com.Facundo.CrudApi.Domain.Data;
import com.Facundo.CrudApi.Repository.CryptoDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.Facundo.CrudApi.Services.crudService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class Controller {

    // Importações
    @Autowired
    private crudService crudService;

    @Autowired
    private CryptoDataRepository repository;

    // Métodos HTTP
    @GetMapping("/")
    public List<Data> listCryptoCoins () {
        return crudService.getAllCoins();
    }

    @PostMapping("/create-crypto-coin")
    public String createCrytoCoin (@RequestBody Data body) {
        repository.save(body);
        return "Cryto coin" + " " + body.getCoinName() + " " + "created at value " + body.getCoinValue();
    }

    @PutMapping("/update-cryto-coin/{id}")
    public Optional<Data> updateCrytoCoin (@PathVariable("id") Long id, @RequestBody Data body) {
        Optional<Data> coin = crudService.updatecryptoCoinValue(id, body.getCoinValue());
        /*return "Cryto coin " + body.getCoinName() + " value update to " + body.getCoinValue();*/
        return coin;
    }

    @DeleteMapping("/delete-cryto-coin/{id}")
    public String deleteCryptoCoin (@PathVariable("id") Long id, @RequestBody Data body) {
        repository.deleteById(id);

        return "Crypto coin deleted";
    }
}
