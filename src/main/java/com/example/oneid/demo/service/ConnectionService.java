package com.example.oneid.demo.service;

import com.example.oneid.demo.entity.Connection;
import com.example.oneid.demo.repository.ConnectionRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConnectionService {

    private final ConnectionRepository connectionRepository;

    public ConnectionService(ConnectionRepository connectionRepository) {
        this.connectionRepository = connectionRepository;
    }

    public void createConnection(Connection connection){
        connectionRepository.save(connection);
    }

    public void updateConnection(Connection connection){
        Optional<Connection> dbConnection = connectionRepository.findById(connection.getId());
        dbConnection.get().setName(connection.getName());
        dbConnection.get().setAtmProperty(connection.getAtmProperty());
        connectionRepository.save(dbConnection.get());
    }
}
