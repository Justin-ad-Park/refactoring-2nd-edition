package com.refactoring.ch01.makeTestSource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.refactoring.ch01.Ch01DataLoader;
import com.refactoring.ch01.Ch01Test;
import com.refactoring.ch01.before.Statement;
import com.refactoring.ch01.data.Invoice;
import com.refactoring.ch01.data.Play;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class StatementTestReverseFactoringStep01 {
    protected Map<String, Play> plays;
    protected List<Invoice> invoices;

    private Statement sut;
    private Invoice invoice;

    private static final Ch01DataLoader DATA_LOADER = new Ch01DataLoader(
            Ch01Test.class.getClassLoader(),
            new ObjectMapper()
    );


    @BeforeEach
    void loadData() {
        plays = DATA_LOADER.loadPlays();
        invoices = DATA_LOADER.loadInvoices();

        sut = new Statement();
        invoice = invoices.get(0);
    }


    @Test
    void statement() {
        // given
        final String expected = """
                청구 내역 (고객명: BigCo)
                  Hamlet: $650.00원 (55석)
                  As You Like It: $580.00원 (35석)
                  Othello: $500.00원 (40석)
                총액: $1,730.00원
                적립 포인트: 47점
                """;

        // when
        final String result = sut.statement(invoice, plays);

        // then
        assertThat(result).isEqualTo(expected);
    }
}
