package SimpleDTUPay.resource;

import java.net.URI;

import SimpleDTUPay.model.Customer;
import SimpleDTUPay.model.Merchant;
import SimpleDTUPay.services.CustomerService;
import SimpleDTUPay.services.MerchantService;
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

@Path("/merchants")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MerchantServiceResource {

    MerchantService merchantService = new MerchantService();

    @Context
    UriInfo uriInfo;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createMerchant(Merchant merchant) {
        System.out.println("Received merchant creation request for: " + merchant.getFirstName());
        if (merchant == null || merchant.getFirstName() == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        String id = merchantService.createMerchant(merchant);
        URI location = uriInfo.getAbsolutePathBuilder().path(id).build();
        return Response.created(location).entity(id).build();
    }

    @GET
    public Response getAllMerchant() {
        return Response.ok(merchantService.findAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response getMerchantById(@PathParam("id") String id) {
        return merchantService.getMerchantById(id)
                .map(merchant -> Response.ok(merchant).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    @PUT
    @Path("{id}/bankaccount")
    public Response changeCity(@PathParam("id") String id, Merchant merchant) {
        if (merchant == null || merchant.getBankAccountId() == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return merchantService.updateMerchantBankAccount(id, merchant)
                .map(s -> Response.ok(s).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }
}