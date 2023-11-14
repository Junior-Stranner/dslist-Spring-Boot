package com.jujubaprojects.dslist.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jujubaprojects.dslist.DTO.GameMinDTO;
import com.jujubaprojects.dslist.Repository.GameRepository;
import com.jujubaprojects.dslist.entities.Game;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

       public List<GameMinDTO> findAll(){
       List<Game> result = gameRepository.findAll();
       List<GameMinDTO> dtoList = result.stream().map(x -> new GameMinDTO(x)).toList();
       
 /*    for (Game game : result) {
        GameMinDTO dto = new GameMinDTO(game); // Novamente, ajuste conforme sua implementação
        dtoList.add(dto);
    }*/

        return dtoList;

       }
}
