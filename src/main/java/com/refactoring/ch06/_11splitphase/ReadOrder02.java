package com.refactoring.ch06._11splitphase;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

public class ReadOrder02 {

    // sout -> return으로 변경
    public static long run(String[] args) throws IOException {
        if (args.length == 0) throw new RuntimeException("파일명을 입력하세요.");
        String filename = args[args.length - 1];
        File input = new ClassPathResource(filename).getFile();

        ObjectMapper mapper = new ObjectMapper();
        Order[] orders = mapper.readValue(input, Order[].class);

        if (Stream.of(args).anyMatch(arg -> "-r".equals(arg)))
            return (Stream.of(orders)
                    .filter(o -> "ready".equals(o.getStatus()))
                    .count());
        else
            return orders.length;
    }
}
