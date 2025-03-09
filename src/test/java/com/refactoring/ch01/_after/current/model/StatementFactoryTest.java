package com.refactoring.ch01._after.current.model;

import static org.assertj.core.api.Assertions.assertThat;

import com.refactoring.ch01.Ch01Test;
import com.refactoring.ch01._after.current.model.calculator.PerformanceCalculatorComposite;
import com.refactoring.ch01._after.current.model.data.Statement;
import com.refactoring.ch01.data.Invoice;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StatementFactoryTest extends Ch01Test {

    private StatementFactory sut;
    private Invoice invoice;

    @BeforeEach
    void setUp() {
        final PerformanceCalculator calculator = new PerformanceCalculatorComposite();
        sut = new StatementFactory(calculator);
        invoice = invoices.get(0);
    }

    @Test
    void createStatement() {
        // when
        final Statement actual = sut.createStatement(invoice, plays);

        // then
        SoftAssertions.assertSoftly(softly -> {
            assertThat(actual.customer()).isEqualTo(invoice.customer());
            assertThat(actual.performances()).hasSize(invoice.performances().size());
            assertThat(actual.totalAmount()).isEqualTo(173_000);
            assertThat(actual.totalVolumeCredits()).isEqualTo(47);
        });
    }

}
