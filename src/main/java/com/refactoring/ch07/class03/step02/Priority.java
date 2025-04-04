package com.refactoring.ch07.class03.step02;

public enum Priority {
    LOW(1),
    MEDIUM(2),
    HIGH(3),
    RUSH(4);

    Priority(int priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    private final int priorityLevel;

    public boolean isHigherThen(Priority other) {
        return this.priorityLevel > other.priorityLevel;
    }

    public boolean isLowerThen(Priority other) {
        return this.priorityLevel < other.priorityLevel;
    }

    public boolean isLowest() {
        return this.priorityLevel == LOW.priorityLevel;
    }

}
