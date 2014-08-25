import javax.sound.midi.MidiChannel;
import javax.sound.midi.Synthesizer;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;

public class Song
{
   private MidiChannel channel;
   private int tempo;
   private final int altoSax = 65;


   public Song ()
   {
      MidiChannel[] channels = null;

      try
      {
         Synthesizer synth = MidiSystem.getSynthesizer();
         synth.open();
         channels = synth.getChannels();
      }
      catch (MidiUnavailableException e)
      {
         e.printStackTrace();
      }

      channel = channels[0];
      channel.programChange(altoSax);
   }


   public MidiChannel getMidiChannel()
   {
      return channel;
   }


   public void setTempo(String tempo)
   {
      this.tempo = Integer.parseInt(tempo);
   }


   public int getTempo()
   {
      return tempo;
   }
}
