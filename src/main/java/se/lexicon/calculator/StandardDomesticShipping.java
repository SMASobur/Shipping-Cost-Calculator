package se.lexicon.calculator;

import se.lexicon.model.Destination;
import se.lexicon.model.ShippingDetails;
import se.lexicon.model.ShippingRequest;
import se.lexicon.model.Speed;
import se.lexicon.service.ShippingCostCalculator;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;

@Component
public class StandardDomesticShipping implements ShippingCostCalculator {

    private final ShippingDetails shippingDetails;

    public StandardDomesticShipping(ShippingDetails shippingDetails) {
        this.shippingDetails = shippingDetails;
    }

    @Override
    public boolean supports(ShippingRequest r) {
        return r.destination() == Destination.DOMESTIC && r.speed() == Speed.STANDARD;
    }

    @Override
    public double calculate(ShippingRequest r) {
        return shippingDetails.getDomesticStandardBaseCost() + shippingDetails.getDomesticStandardCostPerKg() * r.weightKg();
    }

    @PostConstruct
    public void init() {
        System.out.println("Bean " + this.getClass().getSimpleName() + " has been created");
    }
}