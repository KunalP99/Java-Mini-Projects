# Bitmap Message
This program uses a multiline string as a bitmap, a 2D image with only two possible colors for each pixel, to determine how it should display a message from the user. In this bitmap, space characters represent an empty space, and all other characters are replaced by characters in the user’s message. The provided bitmap resembles a world map which can be found in the `bitmap.txt` file.
## Original Bitmap
```plaintext
....................................................................
   **************   *  *** **  *      ******************************
  ********************* ** ** *  * ****************************** *
 **      *****************       ******************************
          *************          **  * **** ** ************** *
           *********            *******   **************** * *
            ********           ***************************  *
   *        * **** ***         *************** ******  ** *
               ****  *         ***************   *** ***  *
                 ******         *************    **   **  *
                 ********        *************    *  ** ***
                   ********         ********          * *** ****
                   *********         ******  *        **** ** * **
                   *********         ****** * *           *** *   *
                     ******          ***** **             *****   *
                     *****            **** *            ********
                    *****             ****              *********
                    ****              **                 *******   *
                    ***                                       *    *
                    **     *                    *
....................................................................
```

You can change the image by editing the `bitmap.txt` file.

## Example
```plaintext
Enter the message to display with the bitmap. java

javajavajavajavajavajavajavajavajavajavajavajavajavajavajavajavajava
   ajavajavajavaj   j  aja aj  a      vajavajavajavajavajavajavajava
  vajavajavajavajavajav ja aj v  a ajavajavajavajavajavajavajavaj v
 av      avajavajavajavaja       avajavajavajavajavajavajavajav
          vajavajavajav          av  a ajav ja ajavajavajavaj v
           ajavajava            javajav   vajavajavajavaja a a
            javajava           ajavajavajavajavajavajavaja  j
   a        j vaja aja         ajavajavajavaja ajavaj  aj v
               ajav  a         ajavajavajavaja   ava ava  v
                 avajav         javajavajavaj    av   va  v
                 avajavaj        avajavajavaja    v  av jav
                   ajavajav         javajava          v jav java
                   ajavajava         avajav  a        vaja aj v ja
                   ajavajava         avajav j v           vaj v   v
                     avajav          avaja aj             vajav   v
                     avaja            vaja a            javajava
                    javaj             vaja              javajavaj
                    java              va                 avajava   a
                    jav                                       v    a
                    ja     a                    j
javajavajavajavajavajavajavajavajavajavajavajavajavajavajavajavajava
```