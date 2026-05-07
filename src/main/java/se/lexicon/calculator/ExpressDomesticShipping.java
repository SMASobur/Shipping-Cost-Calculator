package se.lexicon.calculator;

import org.springframework.stereotype.Component;
import se.lexicon.model.Destination;
import se.lexicon.model.ShippingRequest;
import se.lexicon.model.Speed;
import se.lexicon.service.ShippingCostCalculator;
import se.lexicon.service.ShippingService;
@Component
public class ExpressDomesticShipping implements ShippingCostCalculator {

    public boolean supports(ShippingRequest r) {
        return r.destination() == Destination.DOMESTIC && r.speed() == Speed.EXPRESS;
    }

    public double calculate(ShippingRequest r) {
        return 10 + 1.7 * r.weightKg();
    }

}
