package com.refactoring.ch06._11splitphase;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

public class ReadOrder23 {

    public static long run(String[] args) throws IOException {
        CommandLine commandLine = new CommandLine(args);

        return countOrders(commandLine, args);
    }

    private static long countOrders(CommandLine commandLine, String[] args ) throws IOException {
        File input = new ClassPathResource(commandLine.filename()).getFile();
        ObjectMapper mapper = new ObjectMapper();
        Order[] orders = mapper.readValue(input, Order[].class);

        if (Stream.of(args).anyMatch(arg -> "-r".equals(arg)))
            return (Stream.of(orders)
                    .filter(o -> "ready".equals(o.getStatus()))
                    .count());
        else
            return orders.length;
    }

    private static class CommandLine {
        String[] args;

        public CommandLine(String[] args) {
            // args가 없을 때 예외를 던지는 코드를 옮긴다.
            if (args.length == 0) throw new RuntimeException("파일명을 입력하세요.");
            this.args = args;
        }

        String filename() {
            return args[args.length - 1];
        }
    }
}
