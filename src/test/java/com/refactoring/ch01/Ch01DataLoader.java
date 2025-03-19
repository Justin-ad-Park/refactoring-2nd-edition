package com.refactoring.ch01;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import com.refactoring.ch01.data.Invoice;
import com.refactoring.ch01.data.Play;

public final class Ch01DataLoader {

    private final ObjectMapper mapper;

    public Ch01DataLoader() {
        this.mapper = new ObjectMapper();
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
