package com.example.backend.service.mysql;

import com.example.backend.pojo.mysql.ThemeAccessoryJoin;
import com.example.backend.repository.ThemeAccessoryJoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThemeAccessoryJoinService {

    @Autowired
    private ThemeAccessoryJoinRepository themeAccessoryJoinRepository;

    public List<ThemeAccessoryJoin> findAllTA() {return themeAccessoryJoinRepository.findAllThemeAccessory();}

    public ThemeAccessoryJoin findOneByBothId(int themeId, int accessoryId) {return themeAccessoryJoinRepository.findOneByBothId(themeId, accessoryId);}
}
