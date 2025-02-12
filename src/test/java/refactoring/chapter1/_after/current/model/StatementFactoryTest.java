package refactoring.chapter1._after.current.model;

import static org.assertj.core.api.Assertions.assertThat;

import refactoring.chapter1.Ch01Test;
import refactoring.chapter1._after.current.model.PerformanceCalculator;
import refactoring.chapter1._after.current.model.StatementFactory;
import refactoring.chapter1._after.current.model.calculator.PerformanceCalculatorComposite;
import refactoring.chapter1._after.current.model.data.Statement;
import refactoring.chapter1.data.Invoice;
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
