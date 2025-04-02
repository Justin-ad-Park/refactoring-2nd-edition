package com.refactoring.ch06._11splitphase;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

public class ReadOrder07 {

    public static long run(String[] args) throws IOException {
        if (args.length == 0) throw new RuntimeException("파일명을 입력하세요.");
        CommandLine commandLine = new CommandLine();
        //onlyCountReady에 값을 설정하는 문장을 호출하는 곳으로 옮긴다.(8.4 문장을 호출한 곳으로 옮기기)
        commandLine.onlyCountReady = Stream.of(args).anyMatch(arg -> "-r".equals(arg));

        String filename = args[args.length - 1];

        //더 이상 사용하지 않는 args를 제거한다.
        return countOrders(commandLine, filename);
    }

    private static long countOrders(CommandLine commandLine, String filename) throws IOException {
        File input = new ClassPathResource(filename).getFile();
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
    }
}
