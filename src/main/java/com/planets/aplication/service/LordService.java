package com.planets.aplication.service;

import com.planets.aplication.domain.Lord;
import com.planets.aplication.domain.Role;
import com.planets.aplication.repository.LordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component
@Service
public class LordService {

    @Autowired
    LordRepository lordRepository;

    public void addUser (Lord lord) {
        lordRepository.save(lord);
    }

    public void deleteUser (long lordId) {
        lordRepository.deleteById(lordId);
    }

    public long getLordIdByName(String lordName) {
        return lordRepository.findByLordName(lordName).getId();
    }

    public Lord getLordByName (String lordName) {
        return lordRepository.findByLordName(lordName);
    }

    public List<Lord> findTenYoungestLords () {
        List<Lord> lordsSorteredByAge = lordRepository.findAll(Sort.by("lordAge").ascending());
        List<Lord> youngestTenLords = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            youngestTenLords.add(lordsSorteredByAge.get(i));
        }
        return youngestTenLords;
    }

    public void deleteLordById(long id) {
        lordRepository.deleteById(id);
    }

    public List<Lord> getAllLords () {
        return lordRepository.findAll();
    }

    public Lord getLordById (long id) {
        if (lordRepository.findById(id).isPresent()) {
            return lordRepository.findById(id).get();
        }
        return null;
    }
}
