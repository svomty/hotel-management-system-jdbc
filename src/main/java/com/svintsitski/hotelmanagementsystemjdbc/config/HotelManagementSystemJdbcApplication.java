package com.svintsitski.hotelmanagementsystemjdbc.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class HotelManagementSystemJdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelManagementSystemJdbcApplication.class, args);
        try {
            openHomePage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void openHomePage() throws IOException {
        Runtime rt = Runtime.getRuntime();
        rt.exec("rundll32 url.dll,FileProtocolHandler " + "http://localhost:8181");
    }
}
