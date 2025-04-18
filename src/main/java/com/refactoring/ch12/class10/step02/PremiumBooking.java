package com.refactoring.ch12.class10.step02;

import java.time.LocalDate;
import java.util.List;

//public class PremiumBooking extends Booking {
//    private final List<Extra> extras;
//
//    public static PremiumBooking createPremiumBooking(Show show, LocalDate date, List<Extra> extras) {
//        return new PremiumBooking(show, date, extras);
//    }
//
//    protected PremiumBooking(Show show, LocalDate date, List<Extra> extras) {
//        super(show, date);
//        this.extras = extras;
//    }
//
//    public List<Extra> getExtras() {
//        return extras;
//    }
//
////    @Override
////    public boolean hasTalkback() {
////        return show.hasOwnProperty("talkback");
////    }
//
////    @Override
////    public int basePrice() {
////        return Math.round(super.basePrice() + getTotalFee());
////    }
//
////    private int getTotalFee() {
////        return this.extras.stream()
////                .mapToInt(Extra::getFee)
////                .sum();
////    }
//
////    public boolean hasDinner() {
////        boolean hasDinner = extras.stream()
////                .anyMatch(e -> e.hasOwnProperty("dinner"));
////
////        return hasDinner && !this.isPeakDay();
////    }
//
//
//}
