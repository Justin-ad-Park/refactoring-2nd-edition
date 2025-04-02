package com.refactoring.ch06._11splitphase;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;


/**
 * ReadOrder04 부터 다른 방식으로 리팩터링 해본다.
 * 중간 데이터 구조를 클래스+메서드 제공 방식으로 리팩터링.
 */
public class ReadOrder21 {

    public static long run(String[] args) throws IOException {
        if (args.length == 0) throw new RuntimeException("파일명을 입력하세요.");
        //args를 생성자로 넣는다.
        CommandLine commandLine = new CommandLine(args);
        String filename = args[args.length - 1];


        return countOrders(commandLine, args, filename);
    }

    private static long countOrders(CommandLine commandLine, String[] args, String filename) throws IOException {
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

    //중간 데이터 구조의 클래스를 추가한다.
    private static class CommandLine {
        String[] args;

        public CommandLine(String[] args) {
            this.args = args;
        }
    }
}
