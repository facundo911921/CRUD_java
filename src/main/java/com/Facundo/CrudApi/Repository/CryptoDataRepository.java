package com.Facundo.CrudApi.Repository;

import com.Facundo.CrudApi.Domain.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CryptoDataRepository extends JpaRepository <Data, Long> {
}
