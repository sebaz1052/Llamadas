package co.edu.uptc.call.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import co.edu.uptc.call.dto.Call;
import co.edu.uptc.call.dto.CallDTO;
import co.edu.uptc.call.enums.Type;
import co.edu.uptc.call.logic.Registrer;
 
@Path("/Management")
public class Management {

    public static Map<Integer, CallDTO> calls = new HashMap<>();
    public static int code = 0;
    public static String phoneNumber = "3148819367";
    public static int priceMinute = 100;
    public static Registrer regis = new Registrer();

    @POST
    @Path("/addCall")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean addCall(CallDTO call) {
        code++;
        call.setMinutoPrice(priceMinute);
        call.setOwnNumber(phoneNumber);
        call.setCode(code);
        regis.price(call.getType(), call);
        boolean confirmation = false;
        if (call != null) {
            calls.put(code, call);
            confirmation = true;
        }
        return confirmation;
    }

    @GET
    @Path("/getCallByCode")
    @Produces(MediaType.APPLICATION_JSON)
    public Call getCallByCode(@QueryParam("code") int code) {
        if (calls.containsKey(code)) {
            CallDTO callDTO = calls.get(code);
            return new Call(phoneNumber, callDTO.getNumber(), callDTO.getTotal());
        }
        return null;
    }

    @GET
    @Path("/getTotalCashByType")
    @Produces(MediaType.APPLICATION_JSON)
    public int getTotalCashByType(@QueryParam("type") String type) {
        int sum = 0;
        Type callType = Type.valueOf(type);

        for (CallDTO call : calls.values()) {
            if (call.getType().equals(callType)) {
                sum += call.getTotal();
            }
        }

        if (sum == 0) {
            for (CallDTO call : calls.values()) {
                sum += call.getTotal();
            }
        }
        return sum;
    }

    @GET
    @Path("/getTotalMinutesByType")
    @Produces(MediaType.APPLICATION_JSON)
    public int getTotalMinutesByType(@QueryParam("type") String type) {
        int sum = 0;
        Type callType = Type.valueOf(type);

        for (CallDTO call : calls.values()) {
            if (call.getType().equals(callType)) {
                sum += call.getTime();
            }
        }

        if (sum == 0) {
            for (CallDTO call : calls.values()) {
                sum += call.getTime();
            }
        }
        return sum;
    }

    @POST
    @Path("/getCallsByFilter")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CallDTO> getCallsByFilter(CallDTO filter) {
        List<CallDTO> result = new ArrayList<CallDTO>();

        for (CallDTO call : calls.values()) {
            boolean matches = true;

            if (filter.getNumber() != null && !filter.getNumber().equals(call.getNumber())) {
                matches = false;
            }

            if (filter.getType() != null && !filter.getType().equals(call.getType())) {
                matches = false;
            }

            if (matches) {
                result.add(call);
            }
        }

        return result;
    }
    
    @DELETE
    @Path("/deleteAllCalls")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean deleteAllCalls() {
        calls.clear(); 
        return true; 
    }
}
