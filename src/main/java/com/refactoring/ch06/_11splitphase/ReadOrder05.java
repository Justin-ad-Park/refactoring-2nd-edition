package com.refactoring.ch06._11splitphase;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

public class ReadOrder05 {

    public static long run(String[] args) throws IOException {
        if (args.length == 0) throw new RuntimeException("파일명을 입력하세요.");
        CommandLine commandLine = new CommandLine();
        String filename = args[args.length - 1];

        return countOrders(commandLine, args, filename);
    }

    private static long countOrders(CommandLine commandLine, String[] args, String filename) throws IOException {
        File input = new ClassPathResource(filename).getFile();
        ObjectMapper mapper = new ObjectMapper();
        Order[] orders = mapper.readValue(input, Order[].class);

        // args를 CommandLine으로 이동하기 위해 args를 사용하는 부분을 추출한다.
        boolean onlyCountReady = Stream.of(args).anyMatch(arg -> "-r".equals(arg));
        if (onlyCountReady)
            return (Stream.of(orders)
                    .filter(o -> "ready".equals(o.getStatus()))
                    .count());
        else
            return orders.length;
    }

    private static class CommandLine {
    }
}
