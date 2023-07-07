package chkn;

import java.applet.AudioClip;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Random;
import javax.sound.sampled.*;

public class Sound_fx extends Thread {
    private Clip attackSound, attackSoundTwo, moveSound, buttonSound, backroundMusic, specialSound;
    private AudioInputStream moveAudio, buttonAudio, bgm, attackAudio, attackAudioTwo, specialAudio;

    public Sound_fx() {
        initializeSounds();
    }

    // Get all sound effects in que
    public void initializeSounds() {
        // Create sound variables
        try {
            //Attack sounds first
            this.attackAudio = AudioSystem.getAudioInputStream(new File("src\\Sounds\\SwordSlashOne.wav").getAbsoluteFile());
            this.attackSound = AudioSystem.getClip();
            this.attackSound.open(attackAudio);

            // Attack sound two
            this.attackAudioTwo = AudioSystem.getAudioInputStream(new File("src\\Sounds\\SwordSlashTwo.wav").getAbsoluteFile());
            this.attackSoundTwo = AudioSystem.getClip();
            this.attackSoundTwo.open(attackAudioTwo);

            // Move sound
            this.moveAudio = AudioSystem.getAudioInputStream(new File("src\\Sounds\\MoveSound.wav").getAbsoluteFile());
            this.moveSound = AudioSystem.getClip();
            this.moveSound.open(moveAudio);

            // Button sound
            this.buttonAudio = AudioSystem.getAudioInputStream(new File("src\\Sounds\\ButtonClick.wav").getAbsoluteFile());
            this.buttonSound = AudioSystem.getClip();
            this.buttonSound.open(buttonAudio);

            // Special sound
            this.specialAudio = AudioSystem.getAudioInputStream(new File("src\\Sounds\\SpecialSound.wav").getAbsoluteFile());
            this.specialSound = AudioSystem.getClip();
            this.specialSound.open(specialAudio);

            // Backround music
            this.bgm = AudioSystem.getAudioInputStream(new File("src\\Sounds\\Royal Sunrise, Poly Bridge 2, Cover.wav").getAbsoluteFile());
            this.backroundMusic = AudioSystem.getClip();
            

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Sound files failed to load");
        }       
    }

    // Play backround music
    protected void bgmPlay() {
        // intialize audio
        try {
            this.backroundMusic.open(bgm);
            this.backroundMusic.start();
            this.backroundMusic.loop(Clip.LOOP_CONTINUOUSLY);
            setVolume(backroundMusic, -13);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // Play attack sound effect
    protected void attackSound() {
        // Set audio time to zero
        this.attackSound.setFramePosition(0);
        this.attackSoundTwo.setFramePosition(0);
        setVolume(attackSound, 6);
        setVolume(attackSoundTwo, 6);

        // Random between the two
        double random = Math.random();
        if(random > 0.5) {
            this.attackSound.start();
        }else {
            this.attackSoundTwo.start();
        }
    }

    // Play move sound effect
    protected void moveSound() {
        // Set audio time to zero
        this.moveSound.setFramePosition(0);
        setVolume(moveSound, 6);
        this.moveSound.start();
    }

    // Play button sound
    public void buttonSound() {
        // Set audio time to zero
        this.buttonSound.setFramePosition(0);
        setVolume(buttonSound, 2);
        this.buttonSound.start();
    }

    // Sound for special button
    public void specialButtonSound() {
        // Set audio time to zero
        this.specialSound.setFramePosition(0);
        setVolume(specialSound, -5);
        this.specialSound.start();
    }

    // Set volume level of a clip
    private static void setVolume(Clip clip, int level) {
        Objects.requireNonNull(clip);
        FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        volume.setValue((float) level);
    }
}
