package com.refactoring.ch01._after.current.model.data;

import java.util.List;

public record Statement(
        String customer,
        List<EnrichPerformance> performances,
        int totalAmount,
        int totalVolumeCredits
) {
}
