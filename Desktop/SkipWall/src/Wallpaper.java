import java.io.File;
import java.nio.file.Path;

/**
 * This class creates a Wallpaper Object.
 * It is composed of only one field, which is a private Path Object representing the path to a certain image.
 * 
 * @author Mark Debbane
 * @version 1.0
 *
 */
public class Wallpaper
{
  private Path path;
  
  /**
   * The constructor sets the field to the inputed path.
   * 
   * @param path
   * Inputed path representing the location of the image.
   */
  public Wallpaper(Path path)
  {
    this.path = path;
  }
  
  /**
   * Gets the path of the image.
   * 
   * @return
   * Path object representing the path to the location of the image.
   */
  public Path getPath()
  {
    return path;
  }
  
  /**
   * This method allows the program to set the image as the Desktop Background.
   * This is possible using AppleScript.
   * 
   * @throws Exception
   * Throws all kinds of exceptions.
   */
  public void setWallpaper() throws Exception
  {
    File file = new File(path.toString());
    
    //AppleScript
    String[] as = {
      "osascript", 
      "-e", "tell application \"Finder\"", 
      "-e", "set desktop picture to POSIX file \"" + file.getAbsolutePath() + "\"", 
      "-e", "end tell" };
    
    //Getting Information about the Runtime environment
    Runtime runtime = Runtime.getRuntime();
    
    //Executes AppleScript
    @SuppressWarnings("unused")
	Process process= runtime.exec(as);
  }
}
