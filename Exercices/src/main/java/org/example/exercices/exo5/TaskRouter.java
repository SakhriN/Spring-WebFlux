package org.example.exercices.exo5;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class TaskRouter {

    @Bean
    public RouterFunction<ServerResponse> taskRoutes(TaskHandler taskHandler) {
        return route(GET("/api/tasks"),taskHandler::getAllTasks)
                .andRoute(GET("/api/tasks/{id}"),taskHandler::getTaskById)
                .andRoute(POST("/api/tasks"),taskHandler::addTask)
                .andRoute(PUT("/api/tasks/{id}"),taskHandler::updatetask)
                .andRoute(DELETE("/api/tasks/{id}"),taskHandler::deleteTask);
    }
}
