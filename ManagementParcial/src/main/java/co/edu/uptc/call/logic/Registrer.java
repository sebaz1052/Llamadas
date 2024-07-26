package co.edu.uptc.call.logic;

import java.util.List;

import co.edu.uptc.call.dto.CallDTO;
import co.edu.uptc.call.enums.Type;

public class Registrer {

    public int price(Type type, CallDTO call) {
        switch (type) {
            case SAME:
                call.setTotal(this.priceSame(call));
                break;
            case OTHER:
                call.setTotal(this.priceOther(call));
                break;
            case NATIONAL:
                call.setTotal(this.priceNational(call));
                break;
            case INTERNATIONAL:
                call.setTotal(this.priceInternational(call));
                break;
        }
        return call.getTotal();
    }

    public int priceSame(CallDTO call) {
        return call.getMinutoPrice() * call.getTime(); 
    }

    public int priceOther(CallDTO call) {
        int price = call.getMinutoPrice() * call.getTime();
        return (int) (price * 1.05); 
    }

    public int priceNational(CallDTO call) {
        int price = call.getMinutoPrice() * call.getTime();
        return (int) (price * 1.10); 
    }

    public int priceInternational(CallDTO call) {
        int price = call.getMinutoPrice() * call.getTime();
        return (int) (price * 1.15); 
    }

    public int totalPrice(List<CallDTO> calls) {
        int suma = 0;
        for (CallDTO call : calls) {
            suma += call.getTotal();
        }
        return suma;
    }

    public int totalTime(List<CallDTO> calls) {
        int suma = 0;
        for (CallDTO call : calls) {
            suma += call.getTime();
        }
        return suma;
    }
}

