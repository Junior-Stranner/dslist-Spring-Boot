package com.jujubaprojects.dslist.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jujubaprojects.dslist.DTO.GameDTO;
import com.jujubaprojects.dslist.DTO.GameMinDTO;
import com.jujubaprojects.dslist.Projections.GameMinProjection;
import com.jujubaprojects.dslist.Repository.GameRepository;
import com.jujubaprojects.dslist.entities.Game;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

        @Transactional(readOnly = true)
       public List<GameMinDTO> findAll(){
       List<Game> result = gameRepository.findAll();
       return result.stream().map(x -> new GameMinDTO(x)).toList();
       
 /*    for (Game game : result) {
        GameMinDTO dto = new GameMinDTO(game); // Novamente, ajuste conforme sua implementação
        dtoList.add(dto);

        return dtoList;
    }*/

       }

       @Transactional(readOnly = true)
       public GameDTO findById(long id){
       Game result = gameRepository.findById(id).get();
       return new GameDTO(result);
    
   }
   @Transactional(readOnly = true)
       public List<GameMinDTO> findByList(long listId){
       List<GameMinProjection> result = gameRepository.searchByList(listId);
       return result.stream().map(x -> new GameMinDTO(x)).toList();
     }
}