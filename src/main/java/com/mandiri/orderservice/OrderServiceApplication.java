package com.mandiri.orderservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mandiri.orderservice.model.Product;
import com.mandiri.orderservice.model.orderModel;
import com.mandiri.orderservice.repository.orderRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
@RestController
public class OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

    @Autowired
    orderRepository orderRepository;

    private RestTemplate restTemplate = new RestTemplate();
    ObjectMapper objectMapper = new ObjectMapper();
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    Date today = new Date();

    @GetMapping("/product")
    public String allProduct() {
        String url = "http://localhost:8080/api/products";
        String result = restTemplate.getForObject(url, String.class);
        return result;
    }
    @GetMapping("/find")
    private String getProduct(@RequestParam(value = "productId", defaultValue = "Kosong") String id){
        if(id.equals("Kosong")) {
            return "Product ID tidak boleh kosong";
        }
        String url = "http://localhost:8080/api/products/" + id;
        String result = restTemplate.getForObject(url, String.class);
        Product product = restTemplate.getForObject(url, Product.class);
        System.out.println("Find success: " + result);
//        System.out.println("test: " + product.getId() + product.getNama() + product.getPrice() + product.getQty() + product.toString());
//        orderModel _orderModel = orderRepository.save(new orderModel());

//        Order order = objectMapper.readValue(product, Order.class);
//
        //Product product1 = new Product(product.getId(),product.getNama(), product.getPrice(), product.getQty());

        return result;
    }

    @GetMapping("/order")
    private String getOrder(@RequestParam(value = "productId", defaultValue = "Kosong") String id,
                            @RequestParam(value = "buyerNama") String buyerNama,
                            @RequestParam(value = "address") String address){
//        System.out.println(orderItem);
        if(id.equals("Kosong")) {
            return "Product ID tidak boleh kosong";
        }
        String url = "http://localhost:8080/api/products/" + id;
        String result = restTemplate.getForObject(url, String.class);
        Product product = restTemplate.getForObject(url, Product.class);
        System.out.println("Order success: " + result);

        if (result.isEmpty()) {
            System.out.println("Gagal menyimpan karena data kosong");
        } else {
            orderModel orderModel = new orderModel();
            orderModel.setOrderid(formatter.format(today) + buyerNama + product.getId());
            orderModel.setNama(buyerNama);
            orderModel.setOrderdate(formatter.format(today));
            orderModel.setAddress(address);
            orderModel.setProductitem(product.getNama());
            orderRepository.save(orderModel);
        }
        return result;
    }

    @Getter
    @Setter
    public class orderItem {
        private String productId;
        private String orderId;
        private String nama;
        private String address;

    }//    public String productName(@RequestParam(value = "productId", defaultValue = "Kosong") String name) {
//        return String.format("Product %s!", name);
//    }
}
