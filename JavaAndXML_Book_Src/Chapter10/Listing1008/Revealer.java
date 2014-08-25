class Revealer
{
   static String reveal(String string)
   {
      return
      string.replaceAll("\n", "[cr]").replaceAll(" ", ".");
   }
}
