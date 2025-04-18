package com.refactoring.ch12.class10.step02;

import java.util.List;

public class PremiumBookingDelegate {
    private final Booking host;
    private final List<Extra> extras;

    public PremiumBookingDelegate(Booking hostBooking, List<Extra> extras) {
        this.host = hostBooking;
        this.extras = extras;
    }

    // 프리미엄 클래스 역할이 위임된 클래스에서 hasTakback() 메서드를 제공한다.
    public boolean hasTalkback() {
        return host.show.hasOwnProperty("talkback");
    }

    public int basePrice() {
        return Math.round(host.defaultBasePrice() + getTotalFee());
    }

    private int getTotalFee() {
        return this.extras.stream()
                .mapToInt(Extra::getFee)
                .sum();
    }

    public boolean hasDinner() {
        boolean hasDinner = extras.stream()
                .anyMatch(e -> e.hasOwnProperty("dinner"));

        return hasDinner && !this.host.isPeakDay();
    }


}
