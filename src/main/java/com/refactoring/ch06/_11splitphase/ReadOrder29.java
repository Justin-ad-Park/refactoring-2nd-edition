package com.refactoring.ch06._11splitphase;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.refactoring.ch06._11splitphase._27strategy.CountOrders;
import com.refactoring.ch06._11splitphase._27strategy.CountOrdersAll;
import com.refactoring.ch06._11splitphase._27strategy.CountOrdersOnlyReady;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

public class ReadOrder29 {

    public static long run(String[] args) throws IOException {
        return countOrders(new CommandLine(args));
    }

    private static long countOrders(CommandLine commandLine) throws IOException {
        // gerOrders 메서드 추출
        Order[] orders = getOrders(commandLine);
        CountOrders countOrders = createCountOrders(commandLine);

        return countOrders.count(orders);
    }

    // getOrders 메서드 추출
    private static Order[] getOrders(CommandLine commandLine) throws IOException {
        File input = new ClassPathResource(commandLine.filename()).getFile();
        ObjectMapper mapper = new ObjectMapper();
        Order[] orders = mapper.readValue(input, Order[].class);
        return orders;
    }

    private static CountOrders createCountOrders(CommandLine commandLine) {
        if (commandLine.onlyCountReady())
            return new CountOrdersOnlyReady();
        else
            return new CountOrdersAll();
    }

    private static class CommandLine {
        String[] args;

        public CommandLine(String[] args) {
            if (args.length == 0) throw new RuntimeException("파일명을 입력하세요.");
            this.args = args;
        }

        String filename() {
            return args[args.length - 1];
        }

        boolean onlyCountReady() {
            return Stream.of(args).anyMatch(arg -> "-r".equals(arg));
        }
    }

}
