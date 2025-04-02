package com.refactoring.ch06._11splitphase;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.util.stream.Stream;

public class ReadOrder {
    public static void main(String[] args) {
        try {
            if (args.length == 0) throw new RuntimeException("파일명을 입력하세요.");
            String filename = args[args.length - 1];
            File input = new ClassPathResource(filename).getFile();

            System.out.println(input.getAbsolutePath());

            ObjectMapper mapper = new ObjectMapper();
            Order[] orders = mapper.readValue(input, Order[].class);

            if (Stream.of(args).anyMatch(arg -> "-r".equals(arg)))
                System.out.println(Stream.of(orders)
                        .filter(o -> "ready".equals(o.getStatus()))
                        .count());
            else
                System.out.println(orders.length);

        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
