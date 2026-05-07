package se.lexicon.calculator;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import se.lexicon.model.Destination;
import se.lexicon.model.ShippingDetails;
import se.lexicon.model.ShippingRequest;
import se.lexicon.model.Speed;
import se.lexicon.service.ShippingCostCalculator;

@Component
public class ExpressDomesticShipping implements ShippingCostCalculator {

    private final ShippingDetails shippingDetails;

    public ExpressDomesticShipping(ShippingDetails shippingDetails) {
        this.shippingDetails = shippingDetails;
    }

    public boolean supports(ShippingRequest r) {
        return r.destination() == Destination.DOMESTIC && r.speed() == Speed.EXPRESS;
    }

    public double calculate(ShippingRequest r) {
        return shippingDetails.getDomesticExpressBaseCost() + shippingDetails.getDomesticExpressCostPerKg() * r.weightKg();
    }

    @PostConstruct
    public void init() {
        System.out.println("Bean " + this.getClass().getSimpleName() + " has been created");
    }
}
