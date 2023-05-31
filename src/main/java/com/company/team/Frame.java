package com.company.team;


public class Frame {
    private final FrameType frameType;
    private int firstThrow;
    private int secondThrow;
    private int thirdThrow;
    private Frame nextFrame;

    public Frame(String frame) {
        if (frame.charAt(0) == 'X') {
            this.frameType = FrameType.STRIKE;
            this.firstThrow = 10;
            this.secondThrow = 0;
        } else if (frame.charAt(1) == '/') {
            this.frameType = FrameType.SPARE;
            this.firstThrow = parseThrowScore(frame.charAt(0), 0);
            this.secondThrow = parseThrowScore(frame.charAt(1), this.firstThrow);
        } else {
            this.frameType = FrameType.REGULAR;
            this.firstThrow = parseThrowScore(frame.charAt(0), 0);
            this.secondThrow = parseThrowScore(frame.charAt(1), this.firstThrow);
        }

        if (frame.length() == 3) {
            this.firstThrow = parseThrowScore(frame.charAt(0), 0);
            this.secondThrow = parseThrowScore(frame.charAt(1), this.firstThrow);
            this.thirdThrow = parseThrowScore(frame.charAt(2), this.secondThrow);
        }
    }

    private int parseThrowScore(char c, int previousThrowScore) {
        if (c == 'X') {
            return 10;
        }

        if (c == '/') {
            return 10 - previousThrowScore;
        }

        return Integer.parseInt(String.valueOf(c));
    }

    public int calculateBonus() {

        if (this.frameType.equals(FrameType.STRIKE)) {
            if (this.nextFrame == null) {
                return 0;
            }

            if (nextFrame.frameType.equals(FrameType.STRIKE)) {
                if (nextFrame.nextFrame != null) {
                    return nextFrame.firstThrow + nextFrame.nextFrame.firstThrow;
                } else {
                    return nextFrame.firstThrow + nextFrame.secondThrow;
                }
            }

            return nextFrame.firstThrow + nextFrame.secondThrow;
        }

        if (this.frameType.equals(FrameType.SPARE)) {
            if (this.nextFrame != null) {
                return nextFrame.firstThrow;
            }

            return 0;
        }

        return 0;
    }

    public void setNextFrame(Frame nextFrame) {
        this.nextFrame = nextFrame;
    }

    public int getTotalScore() {
        return this.firstThrow + this.secondThrow + this.thirdThrow + this.calculateBonus();
    }
}
