package com.tchandak.instranate;

import com.tchandak.instranate.domain.Donor;
import com.tchandak.instranate.repository.DonorRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootApplication
public class InstranateApplication {

    public static void main(String[] args) {
        SpringApplication.run(InstranateApplication.class, args);

    }
}
