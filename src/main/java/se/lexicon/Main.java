package se.lexicon;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.config.AppConfig;
import se.lexicon.model.Destination;
import se.lexicon.model.ShippingRequest;
import se.lexicon.model.Speed;
import se.lexicon.service.ShippingCalculatorFactory;
import se.lexicon.service.ShippingService;

public class Main {
    public static void main(String[] args) {

        ApplicationContext  context = new AnnotationConfigApplicationContext(AppConfig.class);

        ShippingCalculatorFactory factory = context.getBean(ShippingCalculatorFactory.class);

        ShippingService shippingService = context.getBean(ShippingService.class);

        ShippingRequest domesticStandardRequest = new ShippingRequest(Destination.DOMESTIC, Speed.STANDARD, 10.0);
        System.out.println("Shipping cost: " + shippingService.quote(domesticStandardRequest));

        ShippingRequest internationalExpressRequest = new ShippingRequest(Destination.INTERNATIONAL, Speed.EXPRESS, 15.0);
        System.out.println("Shipping cost: " + shippingService.quote(internationalExpressRequest));

        ShippingRequest lightDomesticRequest = new ShippingRequest(Destination.DOMESTIC, Speed.STANDARD, 5.0);
        System.out.println("Shipping cost: " + shippingService.quote(lightDomesticRequest));

        ShippingRequest heavyInternationalExpressRequest = new ShippingRequest(Destination.INTERNATIONAL, Speed.EXPRESS, 20.0);
        System.out.println("Shipping cost: " + shippingService.quote(heavyInternationalExpressRequest));

        ShippingRequest heavyDomesticRequest = new ShippingRequest(Destination.DOMESTIC, Speed.EXPRESS, 10);
        System.out.println("Shipping cost: " + shippingService.quote(heavyDomesticRequest));

        ShippingRequest lightInternationalRequest = new ShippingRequest(Destination.INTERNATIONAL, Speed.STANDARD, 16.2);
        System.out.println("Shipping cost: " + shippingService.quote(lightInternationalRequest));
    }
}
