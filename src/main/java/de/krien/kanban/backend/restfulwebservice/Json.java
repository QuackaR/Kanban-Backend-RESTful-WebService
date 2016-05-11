package de.krien.kanban.backend.restfulwebservice;

import jersey.repackaged.com.google.common.collect.Lists;
import model.Task;
import model.TaskStatus;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Path("/json")
public class Json {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response sayPlainTextHello() {

        List<Task> tasks = generateTestTasks();

        System.out.println("WS was called!");

        Task[] returnArray = tasks.toArray(new Task[tasks.size()]);

        return Response.status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .entity(returnArray)
                .build();
    }

    private List<Task> generateTestTasks() {
        List<Task> tasks = new ArrayList<>();

        for(TaskStatus status : TaskStatus.values()) {
            int count = 1;
            for(int i = 0; i < 5; i++) {
                Task newTask = new Task();
                newTask.setId(count);
                newTask.setName("Test Task " + count++);
                newTask.setDescription("This is a task to test the kanban board application");
                newTask.setDueDate(new Date());
                newTask.setStatus(status.getName());
                tasks.add(newTask);
            }
        }
        return tasks;
    }

}
