public class Note implements Runnable
{
   private Song song;
   private int pitch;
   private int velocity=70;
   private int duration;


   public Note(Song song)
   {
      this.song = song;
   }


   public void setPitch(String pitch)
   {
      this.pitch = Integer.parseInt(pitch);
   }


   public void setOctave(String octave)
   {
      pitch += 12*Integer.parseInt(octave);
   }


   public void setVelocity(String velocity)
   {
      if (velocity != null)
         this.velocity = Integer.parseInt(velocity);
   }



   public void setDuration(String duration)
   {
      this.duration =
               (int)( Double.parseDouble(duration) *
                      song.getTempo() );
   }


   public void setDotted(String dotted)
   {
      if (Boolean.getBoolean(dotted))
         duration = (int)(1.5 * duration);
   }


   public void run()
   {
      song.getMidiChannel().noteOn(pitch, velocity);
      try
      {
         Thread.sleep(duration);
      }
      catch (InterruptedException e)
      {
         e.printStackTrace();
      }
      song.getMidiChannel().noteOff(pitch);
   }
}
