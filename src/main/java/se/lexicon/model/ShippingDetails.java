package se.lexicon.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ShippingDetails {

    @Value("${domestic.standard.base}")
    private double domesticStandardBaseCost;

    @Value("${domestic.standard.perKg}")
    private double domesticStandardCostPerKg;

    @Value("${international.express.base}")
    private double internationalExpressBaseCost;

    @Value("${international.express.perKg}")
    private double internationalExpressCostPerKg;

    @Value("${international.standard.base}")
    private double internationalStandardBaseCost;

    @Value("${international.standard.perKg}")
    private double internationalStandardCostPerKg;

    @Value("${domestic.express.base}")
    private double domesticExpressBaseCost;

    @Value("${domestic.express.perKg}")
    private double domesticExpressCostPerKg;

    public double getDomesticExpressBaseCost() {
        return domesticExpressBaseCost;
    }

    public double getInternationalStandardCostPerKg() {
        return internationalStandardCostPerKg;
    }

    public double getInternationalStandardBaseCost() {
        return internationalStandardBaseCost;
    }

    public double getInternationalExpressCostPerKg() {
        return internationalExpressCostPerKg;
    }

    public double getInternationalExpressBaseCost() {
        return internationalExpressBaseCost;
    }

    public double getDomesticStandardCostPerKg() {
        return domesticStandardCostPerKg;
    }

    public double getDomesticStandardBaseCost() {
        return domesticStandardBaseCost;
    }

    public double getDomesticExpressCostPerKg() {
        return domesticExpressCostPerKg;
    }
}
