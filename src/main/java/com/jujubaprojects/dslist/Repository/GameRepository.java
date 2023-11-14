package com.jujubaprojects.dslist.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jujubaprojects.dslist.entities.Game;

public interface GameRepository extends JpaRepository <Game,Long>{
    
}
