package com.Facundo.CrudApi.Services;

import com.Facundo.CrudApi.Domain.Data;
import com.Facundo.CrudApi.Repository.CryptoDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class crudService {

    @Autowired
    private CryptoDataRepository repository;

    public List<Data> getAllCoins () {
        List<Data> coins = repository.findAll();

        return coins;
    }

    public Optional<Data> updatecryptoCoinValue (Long id, String value) {
        Optional<Data> coin = repository.findById(id);

        if (coin.isPresent()) {
            Data data = coin.get();
            data.setCoinValue(value);
            repository.save(data);

            return Optional.of(data);
        }
        return Optional.empty();
    }
}
