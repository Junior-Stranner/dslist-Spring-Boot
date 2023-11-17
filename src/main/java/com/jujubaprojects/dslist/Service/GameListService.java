package com.jujubaprojects.dslist.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jujubaprojects.dslist.DTO.GameListDTO;
import com.jujubaprojects.dslist.Projections.GameMinProjection;
import com.jujubaprojects.dslist.Repository.GameListRepository;
import com.jujubaprojects.dslist.Repository.GameRepository;
import com.jujubaprojects.dslist.entities.GameList;

import org.springframework.transaction.annotation.Transactional;

@Service
public class GameListService {
    
    @Autowired
    GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    public List<GameListDTO> findAll(){
        List<GameList> resultList = gameListRepository.findAll();
         return resultList.stream().map(x -> new GameListDTO(x)).toList();
         
    }

    @Transactional
    public void move(Long listId , int sourceIndex, int destinationIndex){
    
        List<GameMinProjection> list = gameRepository.searchByList(listId);

        GameMinProjection obj = list.remove(sourceIndex);

        list.add(destinationIndex,obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for(int i = min ; i <= max ; i ++){
            gameListRepository.updateBelongingPosition(listId,list.get(i).getId() ,i);
        }
    }
}
