package com.jujubaprojects.dslist.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jujubaprojects.dslist.DTO.GameListDTO;
import com.jujubaprojects.dslist.DTO.GameMinDTO;
import com.jujubaprojects.dslist.DTO.ReplacementDTO;
import com.jujubaprojects.dslist.Service.GameListService;
import com.jujubaprojects.dslist.Service.GameService;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
     
    @Autowired
	private GameListService gameListService;

    @Autowired
    private GameService gameService;

	
	@GetMapping
	public List<GameListDTO> findAll() {
		List<GameListDTO> result = gameListService.findAll();
		return result;
	}

     @GetMapping("/{listId}/games")
    public List<GameMinDTO>findAll(@PathVariable long listId){
      List<GameMinDTO> dtoList = gameService.findByList(listId);
      return dtoList;
 
        }

      @PostMapping(value = "/{listId}/replacement")
	    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body) {
		  gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
	}
}
