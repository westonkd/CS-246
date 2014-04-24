
import java.io.RandomAccessFile;

public class SplitDBF
{
   public static byte[] getDataAndOffsets(String filename, int[] offsets)
      throws Exception
   {
      // TODO: initialize buffer correctly, then store and return
      //       in the buffer byte array all of the data in the file,
      //       scanning it to get the offsets before returning.

      RandomAccessFile file = new RandomAccessFile(filename,"r");

      byte[] buffer = new byte[(int) file.length()]; //array to store data
      int[] tempOffset = new int[7];

      //read the file
      file.readFully(buffer);

      //for each file
      int j = 0;
      for (int i = 0; i < buffer.length; i++) {
         if (buffer[i] == 3 && buffer[i + 30] == 0 && buffer[i + 31] == 0) {
            System.out.println(i);
            offsets[j++] = i;
         }
      }

      //set the last offset
      offsets[7] = (int) file.length() - 1;

       //close the file
      file.close();

      return buffer;
   }

   // DON'T TOUCH ANYTHING below here!

   private static String[] cFileNames =
   {
      "acctno", "check", "claimno", "dicode", "policy", "recall", "trcode",
   };

   public static String filename(int i)
   {
      return cFileNames[i] + ".dbf";
   }

   public static void main(String[] args)
      throws Exception
   {
      String filename = ((args.length > 0) ? args[0] : "/home/cs246/files/backup");

      int[] offsets = new int[cFileNames.length + 1];
      byte[] buffer = getDataAndOffsets(filename, offsets);

      for (int i = 0; i < offsets.length - 1; i++)
      {
         int offset = offsets[i];
         int len = offsets[i + 1] - offset;
         RandomAccessFile newfile = new RandomAccessFile(filename(i), "rw");
         newfile.write(buffer, offset, len);
         newfile.write((byte) 26); // write the ^Z terminator
         newfile.close();
      }
   }
}
