package com.company.team;

import java.util.ArrayList;
import java.util.List;

public class Bowling {

    public static int scoreGame(String score) {
        String[] frameStrings = score.split(" ");
        List<Frame> frames = new ArrayList<>();
        Frame previousFrame = null;

        for (String frameString : frameStrings) {
            Frame frame = new Frame(frameString);
            frames.add(frame);

            if (previousFrame != null) {
                previousFrame.setNextFrame(frame);
            }

            previousFrame = frame;
        }

        return frames.stream()
                .map(Frame::getTotalScore)
                .mapToInt(x -> x)
                .sum();
    }
}
