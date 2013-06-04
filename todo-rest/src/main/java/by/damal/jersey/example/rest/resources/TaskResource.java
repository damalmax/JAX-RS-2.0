package by.damal.jersey.example.rest.resources;

import by.damal.jersey.example.domain.Task;
import by.damal.jersey.example.service.TaskService;
import javax.ws.rs.BeanParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST resource.
 * <p/>
 *
 * @author Maksim Dadzerkin
 */
@Path("tasks")
public class TaskResource {

    private TaskService taskService;

    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    @GET
    @Path("{id://d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Integer id) {
        Task task = taskService.read(id);
        if(task == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return Response.ok().build();
    }

    @DELETE
    @Path("{id://d+}")
    public Response deleteById(@PathParam("id") Integer id) {
        taskService.delete(id);
        return Response.ok().build();
    }

    @PUT
    public Response update(@BeanParam Task task) {
        taskService.save(task);
        return Response.ok().build();
    }

    @POST
    public Response create(@BeanParam Task task) {
        taskService.save(task);
        return Response.ok().build();
    }
}
