package com.example.oneid.demo.api;

import com.example.oneid.demo.entity.Connection;
import com.example.oneid.demo.service.ConnectionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/connection")
@RestController
public class ConnectionController {

    public ConnectionController(ConnectionService connectionService) {
        this.connectionService = connectionService;
    }

    private final ConnectionService connectionService;

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public ResponseEntity createConnection(@RequestBody Connection connection) {
        connectionService.createConnection(connection);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public ResponseEntity updateConnection(@RequestBody Connection connection) {
        connectionService.updateConnection(connection);
        return ResponseEntity.ok().build();
    }
}
