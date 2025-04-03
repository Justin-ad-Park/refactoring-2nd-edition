package com.refactoring.ch06._11splitphase;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.refactoring.ch06._11splitphase._27strategy.CountOrders;
import com.refactoring.ch06._11splitphase._27strategy.CountOrdersAll;
import com.refactoring.ch06._11splitphase._27strategy.CountOrdersOnlyReady;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

public class ReadOrder27 {

    public static long run(String[] args) throws IOException {
        //변수 인라인화
        return countOrders(new CommandLine(args));
    }

    private static long countOrders(CommandLine commandLine) throws IOException {
        File input = new ClassPathResource(commandLine.filename()).getFile();
        ObjectMapper mapper = new ObjectMapper();
        Order[] orders = mapper.readValue(input, Order[].class);

        // 전략패턴 적용
        CountOrders countOrders;
        if (commandLine.onlyCountReady())
            countOrders = new CountOrdersOnlyReady();
        else
            countOrders = new CountOrdersAll();


        return countOrders.count(orders);
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
