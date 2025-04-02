package com.refactoring.ch06._11splitphase;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

public class ReadOrder10 {

    public static long run(String[] args) throws IOException {
        // 변수 인라인화
        return countOrders(parseCommandLine(args));
    }

    private static CommandLine parseCommandLine(String[] args) {
        if (args.length == 0) throw new RuntimeException("파일명을 입력하세요.");

        // commandLine -> result로 변수명 변경
        CommandLine result = new CommandLine();
        result.onlyCountReady = Stream.of(args).anyMatch(arg -> "-r".equals(arg));
        result.filename = args[args.length - 1];
        return result;
    }

    private static long countOrders(CommandLine commandLine) throws IOException {
        File input = new ClassPathResource(commandLine.filename).getFile();
        ObjectMapper mapper = new ObjectMapper();
        Order[] orders = mapper.readValue(input, Order[].class);

        if (commandLine.onlyCountReady)
            return (Stream.of(orders)
                    .filter(o -> "ready".equals(o.getStatus()))
                    .count());
        else
            return orders.length;
    }

    private static class CommandLine {
        boolean onlyCountReady;
        String filename;
    }
}
