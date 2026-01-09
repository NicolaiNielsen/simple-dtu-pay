package SimpleDTUPay.resource;

import java.net.URI;

import SimpleDTUPay.model.Customer;
import SimpleDTUPay.services.CustomerService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

import java.net.URI;

@Path("/customer")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerServiceResource {

    CustomerService customerService = new CustomerService();

    @Context
    UriInfo uriInfo;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCustomer(Customer customer) {
        if (customer == null || customer.getFirstName() == null || customer.getLastName() == null
                || customer.getCPR() == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        String id = customerService.createCustomer(customer);
        URI location = uriInfo.getAbsolutePathBuilder().path(id).build();
        return Response.created(location).entity(id).build();
    }

    @GET
    public Response getAllCustomers() {
        return Response.ok(customerService.findAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response getCustomerById(@PathParam("id") String id) {
        System.out.println("checking if customer with id " + id + " exists");
        return customerService.getCustomerById(id)
                .map(customer -> Response.ok(customer).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @PUT
    @Path("{id}/bankaccount")
    public Response changeCity(@PathParam("id") String id, Customer customer) {
        if (customer == null || customer.getBankAccountId() == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return customerService.updateCustomerBankAccount(id, customer)
                .map(s -> Response.ok(s).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }
}