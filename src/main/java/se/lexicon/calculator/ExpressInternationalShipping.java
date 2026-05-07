package se.lexicon.calculator;

import se.lexicon.model.Destination;
import se.lexicon.model.ShippingRequest;
import se.lexicon.model.Speed;
import se.lexicon.service.ShippingCostCalculator;

import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;

@Component
public class ExpressInternationalShipping implements ShippingCostCalculator {

    @Override
    public boolean supports(ShippingRequest r) {
        return r.destination() == Destination.INTERNATIONAL && r.speed() == Speed.EXPRESS;
    }

    @Override
    public double calculate(ShippingRequest r) {
        return 25 + 4.5 * r.weightKg();
    }

    @PostConstruct
    public void init() {
        System.out.println("Bean " + this.getClass().getSimpleName() + " has been created");
    }
}