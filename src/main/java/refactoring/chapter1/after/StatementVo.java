package refactoring.chapter1.after;

import refactoring.chapter1.data.Invoice;
import refactoring.chapter1.data.Performance;

import java.util.List;

public class StatementVo {
    private String customer;
    private List<Performance> performances;

    public StatementVo(Invoice invoice) {
        this.customer = invoice.customer();
        this.performances = invoice.performances();
    }

    public String customer() {
        return customer;
    }

    public List<Performance> performances() {
        return performances;
    }
}
