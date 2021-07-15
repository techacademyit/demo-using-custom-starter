package techacademy.example.demo;
 
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Flux;
import techacademy.example.customstarter.WebfluxClient;

@Component
public class ProductProxy {
    
    private String baseUrl;
    private WebfluxClient clientFactory;

    public ProductProxy(WebfluxClient clientFactory, @Value("${url}") String baseUrl){
        this.baseUrl = baseUrl;
        this.clientFactory = clientFactory;
    }
    
    public Flux<ProductByCustomer> product(){
        return clientFactory.builder()
                            .baseUrl(baseUrl)
                            .build()
                            .get()
                            .uri("/product")
                            .exchangeToFlux(response -> {
                                if (response.statusCode().equals(HttpStatus.OK)) {
                                    return response.bodyToFlux(ProductByCustomer.class);
                                }else{
                                    return Flux.error(new RuntimeException());
                                }
                            });
    }
 }
