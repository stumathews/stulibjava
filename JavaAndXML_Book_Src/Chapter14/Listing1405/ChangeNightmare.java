import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

import javax.xml.bind.UnmarshalException;
import javax.xml.bind.StructureValidationException;


class ChangeNightmare
{
   static Nightmare nightmare;

   public static void main(String args[])
      throws IOException, UnmarshalException
   {
      nightmare = readNightmare();

      String severity = nightmare.getSeverity();

      nightmare.setSubject("telemarketing");
      nightmare.setSeverity("very " + severity);

      writeNightmare();
   }


   static Nightmare readNightmare()
      throws FileNotFoundException, UnmarshalException
   {
      FileInputStream nightmareIn =
         new FileInputStream("Nightmare.xml");

      nightmare = Nightmare.unmarshal(nightmareIn);

      return nightmare;
   }


   static void writeNightmare()
      throws IOException, StructureValidationException
   {
      FileOutputStream nightmareOut =
         new FileOutputStream("Nightmare.xml");

      nightmare.validate();
      nightmare.marshal(nightmareOut);
   }
}
