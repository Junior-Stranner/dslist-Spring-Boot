package com.jujubaprojects.dslist.DTO;

import com.jujubaprojects.dslist.entities.GameList;

public class GameListDTO {
    
    private long id;
    private String nome;

    public GameListDTO(){

    }

    public GameListDTO(GameList entity) {
        this.id = entity.getId();
        this.nome = entity.getName();
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }


    
    
}
