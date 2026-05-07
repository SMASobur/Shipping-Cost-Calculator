package se.lexicon.calculator;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import se.lexicon.model.Destination;
import se.lexicon.model.ShippingDetails;
import se.lexicon.model.ShippingRequest;
import se.lexicon.model.Speed;
import se.lexicon.service.ShippingCostCalculator;
@Component
public class StandardInternationalShipping implements ShippingCostCalculator {

    private final ShippingDetails shippingDetails;

    public StandardInternationalShipping(ShippingDetails shippingDetails) {
        this.shippingDetails = shippingDetails;
    }

    public boolean supports(ShippingRequest r) {
        return r.destination() == Destination.INTERNATIONAL && r.speed() == Speed.STANDARD;
    }

    public double calculate(ShippingRequest r) {
        return shippingDetails.getInternationalStandardBaseCost() + shippingDetails.getInternationalStandardCostPerKg() * r.weightKg();
    }

    @PostConstruct
    public void init() {
        System.out.println("Bean " + this.getClass().getSimpleName() + " has been created");
    }
}
