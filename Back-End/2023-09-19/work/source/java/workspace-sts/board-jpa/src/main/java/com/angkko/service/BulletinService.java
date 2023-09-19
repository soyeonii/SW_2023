package com.angkko.service;

import com.angkko.model.entity.Bulletin;
import com.angkko.repository.BulletinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BulletinService {
    private final BulletinRepository bulletinRepository;

    public Page<Bulletin> listArticle(Pageable pageable) throws DataAccessException {
        return bulletinRepository.findAll(pageable);
    }

    public void addArticle(Bulletin bulletin) throws DataAccessException {
        bulletinRepository.save(bulletin);
    }

    public Bulletin viewArticle(int articleNo) throws DataAccessException {
        Optional<Bulletin> optionalBulletin = bulletinRepository.findById(articleNo);
        Bulletin bulletin = null;
        if (optionalBulletin.isPresent()) {
            bulletin = optionalBulletin.get();
        }
        return bulletin;
    }

    public void editArticle(Bulletin inBoard) throws DataAccessException {
        Optional<Bulletin> optionalBoard = bulletinRepository.findById(inBoard.getId());
        Bulletin board = null;
        if (optionalBoard.isPresent()) {
            board = optionalBoard.get();
            board.setTitle(inBoard.getTitle());
            board.setContent(inBoard.getContent());
            bulletinRepository.save(board);
        }
    }

    public void removeArticle(int articleNo) throws DataAccessException {
        bulletinRepository.deleteById(articleNo);
    }
}