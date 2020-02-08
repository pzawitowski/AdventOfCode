package com.advent.daySeven;

import java.util.LinkedList;
import java.util.List;

public class AmplifierSeries {
    private  List<Amplifier> amplifiers = new LinkedList<Amplifier>();

    public AmplifierSeries(int amplifierNumbers, String opcode) {
        for (int i = 0; i < amplifierNumbers; i++) {
            amplifiers.add(new Amplifier(opcode));
        }
    }

    public int findLargestOutput() {
        int largestOutput = 0;

        do {
            int output = calculateOutputWithCurrentSettings();
            if (output > largestOutput) {
                largestOutput = output;
            }
            increasePhaseSettingsToUniqueCombination();
        } while (!isMinSetting());

        return largestOutput;
    }

    public int calculateOutputWithCurrentSettings() {
        int input = 0;
        for (Amplifier amplifier : amplifiers) {
            input = amplifier.calculateOutput(input);
        }
        return input;
    }

    public void increasePhaseSettingsToUniqueCombination() {
        increasePhaseSettings();
        while(!isSettingsUnique() && !isMinSetting()) {
            increasePhaseSettings();
        }
    }

    public void increasePhaseSettings() {
        int position = 0;
        while (position < amplifiers.size() && amplifiers.get(position).increasePhaseSetting() == 0) {
            position++;
        }
    }

    private boolean isSettingsUnique() {
        long distinctSettings = amplifiers.stream()
            .mapToInt(Amplifier::getPhaseSetting)
            .distinct()
            .count();

        return distinctSettings == amplifiers.size();
    }

    private boolean isMaxSettings() {
        return amplifiers.stream().allMatch(a -> a.getPhaseSetting() == 4);
    }

    private boolean isMinSetting() {
        return amplifiers.stream().allMatch(a -> a.getPhaseSetting() == 0);
    }

    public List<Amplifier> getAmplifiers() {
        return amplifiers;
    }

    public void setAmplifiers(List<Amplifier> amplifiers) {
        this.amplifiers = amplifiers;
    }
}
