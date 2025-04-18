package com.refactoring.ch12.class10.step02;

import java.time.LocalDate;
import java.util.List;

public class Booking {
    protected final Show show;
    protected final LocalDate date;
    protected List<Extra> extras;
    private PremiumBookingDelegate premiumDelegate;

    public static Booking createBooking(Show show, LocalDate date) {
        return new Booking(show, date);
    }

    public static Booking createPremiumBooking(Show show, LocalDate date, List<Extra> extras) {
        Booking result = new Booking(show, date);
        result.bePremium(extras);

        return result;
    }

    public void bePremium(List<Extra> extras) {
        this.premiumDelegate = new PremiumBookingDelegate(this, extras);
    }

    public Booking(Show show, LocalDate date) {
        this.show = show;
        this.date = date;
    }

    public Show getShow() {
        return show;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getPrice() {
        return show.getPrice();
    }

    // date가 7월 1일 ~ 8월 1일 사이인지 여부 검사
    protected boolean isPeakDay() {
        // 7월 1일
        LocalDate start = LocalDate.of(date.getYear(), 7, 1);
        // 8월 31일
        LocalDate end = LocalDate.of(date.getYear(), 8, 31);

        // 주어진 날짜가 7월 1일 이후이고, 8월 31일 이전이거나 같은지 확인
        return betweenDate(start, end);
    }

    private boolean betweenDate(LocalDate start, LocalDate end) {
        return (date.isEqual(start) || date.isAfter(start)) && (date.isEqual(end) || date.isBefore(end));
    }

    public boolean hasTalkback() {
        return this.premiumDelegate != null ?
                this.premiumDelegate.hasTalkback() : this.show.hasOwnProperty("talkback") && !this.isPeakDay();
    }

    public int basePrice() {
        return premiumDelegate != null ? premiumDelegate.basePrice() : this.defaultBasePrice();
    }

    protected int defaultBasePrice() {
        int result = this.show.getPrice();

        if (this.isPeakDay()) {
            result += Math.round(result * 0.15);
        }
        return result;
    }

    public boolean hasDinner() {
        return this.premiumDelegate != null ? this.premiumDelegate.hasDinner() : false;
    }
}
