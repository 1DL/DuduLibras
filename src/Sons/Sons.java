/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sons;
import java.applet.AudioClip;

/**
 *
 * @author Aluno
 */
public class Sons {
    
    public AudioClip quack;
    public AudioClip musica;
    
    public void tocarQuack (){
        quack = java.applet.Applet.newAudioClip(getClass().getResource("/Sons/passaro.wav"));
        quack.play();
    }
    
    public void pararQuack () {
        quack.stop();
    }
    
    public void tocarCardPlace() {
        quack = java.applet.Applet.newAudioClip(getClass().getResource("/Sons/cardSlide6.wav"));
        quack.play();
    }
    
    public void tocarCardTakeOut() {
        quack = java.applet.Applet.newAudioClip(getClass().getResource("/Sons/cardTakeOutPackage1.wav"));
        quack.play();
    }
    
    public void tocarCardPlace2() {
        quack = java.applet.Applet.newAudioClip(getClass().getResource("/Sons/cardSlide7.wav"));
        quack.play();
    }
    
    public void tocarMusica () {
        musica = java.applet.Applet.newAudioClip(getClass().getResource("/Sons/glow in the dark.wav"));
        musica.play();
    }
    
    public void pararMusica () {
        
        musica.stop();
    }
    
    
    
}
