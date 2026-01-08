package SimpleDTUPay.resource;

import java.net.URI;

import SimpleDTUPay.Payment;
import SimpleDTUPay.model.Customer;
import SimpleDTUPay.model.Merchant;
import SimpleDTUPay.services.CustomerService;
import SimpleDTUPay.services.MerchantService;
import SimpleDTUPay.services.PaymentService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

import java.net.URI;

@Path("/payments")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PaymentServiceResource {

    PaymentService paymentService = new PaymentService();

    @Context
    UriInfo uriInfo;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response makePayment(Payment payment) {
        System.out.println(payment.getMerchantId() + "recieved payment from" + payment.getCustomerId() + "for amount" + payment.getAmount() );
        if (payment == null || payment.getMerchantId() == null || payment.getCustomerId() == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        
        String id = paymentService.createPayment(payment);
        URI location = uriInfo.getAbsolutePathBuilder().path(id).build();
        return Response.created(location).entity(id).build();
    }

    @GET
    public Response getAllPayments() {
        return Response.ok(paymentService.findAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response getPaymentByID(@PathParam("id") String id) {
        return paymentService.getPaymentById(id)
                .map(payment -> Response.ok(payment).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }
}