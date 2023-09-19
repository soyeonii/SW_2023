package com.angkko.service;

import com.angkko.model.entity.Ramen;
import com.angkko.repository.RamenRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RamenService {
    private final RamenRespository ramenRespository;

    public Ramen getContent(int no) throws DataAccessException {
        return ramenRespository.findById(no).orElse(null);
    }
}
