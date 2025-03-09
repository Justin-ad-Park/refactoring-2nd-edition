package com.refactoring.ch01;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Map;
import com.refactoring.ch01.data.Invoice;
import com.refactoring.ch01.data.Play;
import org.junit.jupiter.api.BeforeEach;

public class Ch01Test {

    private static final Ch01DataLoader DATA_LOADER = new Ch01DataLoader(
            Ch01Test.class.getClassLoader(),
            new ObjectMapper()
    );

    protected Map<String, Play> plays;
    protected List<Invoice> invoices;

    @BeforeEach
    void loadData() {
        plays = DATA_LOADER.loadPlays();
        invoices = DATA_LOADER.loadInvoices();
    }

}
