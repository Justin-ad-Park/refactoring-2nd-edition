package com.refactoring.ch01.makeTestSource;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.refactoring.ch01.before.Statement;
import com.refactoring.ch01.data.Invoice;
import com.refactoring.ch01.data.Play;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

class StatementTestReverseFactoringStep02 {
    protected Map<String, Play> plays;
    protected List<Invoice> invoices;

    private Statement sut;
    private Invoice invoice;


    @BeforeEach
    void loadData() {
        plays = loadPlays();
        invoices = loadInvoices();

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


    public Map<String, Play> loadPlays() {
        return loadResource("/chapter1/plays.json", new TypeReference<>() {
        });
    }

    public List<Invoice> loadInvoices() {
        return loadResource("/chapter1/invoices.json", new TypeReference<>() {
        });
    }

    private <T> T loadResource(String path, TypeReference<T> typeReference) {
        final ObjectMapper mapper = new ObjectMapper();

        try (InputStream inputStream = getClass().getResourceAsStream(path)) {
            if (Objects.isNull(inputStream)) {
                throw new IllegalStateException("테스트 리소스가 없습니다!: " + path);
            }
            return mapper.readValue(inputStream, typeReference);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
