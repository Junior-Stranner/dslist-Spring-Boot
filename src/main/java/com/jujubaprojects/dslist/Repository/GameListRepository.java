package com.jujubaprojects.dslist.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jujubaprojects.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository <GameList, Long>{

    
}
