package com.refactoring.ch01._after.current.controller;

import java.util.Map;
import com.refactoring.ch01._after.current.model.StatementFactory;
import com.refactoring.ch01._after.current.view.OutputView;
import com.refactoring.ch01.data.Invoice;
import com.refactoring.ch01.data.Play;

public class StatementController {

    private final StatementFactory factory;
    private final OutputView view;

    public StatementController(final StatementFactory statementFactory, final OutputView outputView) {
        this.factory = statementFactory;
        this.view = outputView;
    }

    public String statement(final Invoice invoice, final Map<String, Play> plays) {
        return view.renderPlainText(factory.createStatement(invoice, plays));
    }

    public String htmlStatement(final Invoice invoice, final Map<String, Play> plays) {
        return view.renderHtml(factory.createStatement(invoice, plays));
    }

}
