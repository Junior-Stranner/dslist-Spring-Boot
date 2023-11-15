package com.jujubaprojects.dslist.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jujubaprojects.dslist.DTO.GameDTO;
import com.jujubaprojects.dslist.DTO.GameMinDTO;
import com.jujubaprojects.dslist.Service.GameService;

@RestController
@RequestMapping(value = "/games")
public class GameController {
    
    @Autowired
    GameService gameService;

    @GetMapping("/findAll")
    public List<GameMinDTO>findAll(){
      List<GameMinDTO> dtoList = gameService.findAll();
      return dtoList;
 
        }
     
        @GetMapping(value = "/{id}")
        public GameDTO findById(@PathVariable long id){
          GameDTO result = gameService.findById(id);
          return result;

        }
}


