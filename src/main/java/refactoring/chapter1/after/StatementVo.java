package refactoring.chapter1.after;

import refactoring.chapter1.data.Invoice;
import refactoring.chapter1.data.Play;

import java.util.Map;

public class StatementVo {
    private String customer;

    public StatementVo(String customer) {
        this.customer = customer;
    }

    public String getCustomer() {
        return customer;
    }
}
