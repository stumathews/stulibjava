import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;

class MyContentHandler extends DefaultHandler
{
   Song song;
   Measure measure;


   public void startDocument()
   {
      song = new Song();
   }


   public void startElement(String uri,
                            String localName,
                            String qualName,
                            Attributes attribs)
   {
      if (qualName.equals("song"))
         song.setTempo(attribs.getValue("tempo"));
      if (qualName.equals("measure"))
         measure = new Measure
            (song, attribs.getValue("beatlength"));
      if (qualName.equals("note"))
      {
         Note note = new Note(song);

         note.setPitch (attribs.getValue("pitch"));
         note.setOctave (attribs.getValue("octave"));
         note.setVelocity (attribs.getValue("velocity"));
         note.setDuration (attribs.getValue("duration"));
         note.setDotted (attribs.getValue("dotted"));

         Thread noteThread = new Thread(note);
         noteThread.start();
      }
   }


   public void endElement(String uri,
                          String localName,
                          String qualName)
   {
      if (qualName.equals("beat"))
      {
         try
         {
            Thread.sleep(measure.getBeatlength());
         }
         catch (InterruptedException e)
         {
            e.printStackTrace();
         }
      }
   }


   public void endDocument()
   {
      System.exit(0);
   }

}
