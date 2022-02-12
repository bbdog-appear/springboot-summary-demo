package com.bbdog.study.springboot.summary.demo.web.javabase.headfirstjava.异常处理;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;

/**
 * <p>
 *
 * </p>
 *
 * @author cheng.wang
 * @version Id：MusicTest1.java Date：2022/2/12 14:27 Version：1.0
 */
public class MusicTest1 {

    public static void main(String[] args) throws MidiUnavailableException {
        MusicTest1 mt = new MusicTest1();
        mt.play();
    }

    public void play() throws MidiUnavailableException {
        Sequencer sequencer = MidiSystem.getSequencer();
        System.out.println("We got a sequencer");
    }

}
