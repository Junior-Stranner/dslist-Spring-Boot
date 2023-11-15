package com.jujubaprojects.dslist.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jujubaprojects.dslist.DTO.GameListDTO;
import com.jujubaprojects.dslist.Repository.GameListRepository;
import com.jujubaprojects.dslist.entities.GameList;

@Service
public class GameListService {
    
    @Autowired
    GameListRepository gameListRepository;

    public List<GameListDTO> findAll(){
        List<GameList> resultList = gameListRepository.findAll();
         return resultList.stream().map(x -> new GameListDTO(x)).toList();
         
        
    }
}
