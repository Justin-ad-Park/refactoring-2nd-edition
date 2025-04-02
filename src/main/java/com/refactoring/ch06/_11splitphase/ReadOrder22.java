package com.refactoring.ch06._11splitphase;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

public class ReadOrder22 {

    public static long run(String[] args) throws IOException {
        if (args.length == 0) throw new RuntimeException("파일명을 입력하세요.");
        CommandLine commandLine = new CommandLine(args);
        //String filename = args[args.length - 1];

        return countOrders(commandLine, args);
    }

    private static long countOrders(CommandLine commandLine, String[] args ) throws IOException {
        // filename 파라미터를 없애고, commandLine.filename()을 사용한다.
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
            this.args = args;
        }

        //filename을 반환하는 메서드를 추가한다.
        String filename() {
            return args[args.length - 1];
        }
    }
}
