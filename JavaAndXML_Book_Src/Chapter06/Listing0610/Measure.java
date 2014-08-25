public class Measure
{
   private int beatlength;


   public Measure(Song song, String beatlength)
   {
      this.beatlength =
         (int)( song.getTempo() *
                Double.parseDouble(beatlength) );
   }


   public int getBeatlength ()
   {
      return beatlength;
   }
}
