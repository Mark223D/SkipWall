import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.LinkOption;

/**
 * This class contains the main method of the program.
 * It does not contain a SkipWall constructor.
 * 
 * @author Mark Debbane
 * @version 1.0
 *
 */
public class SkipWall
{
	/**
	 * A Path Object is created to store the Path of the folder containing the images.
	 * Fills an array of Files by calling the {@code fillArray()} method.
	 * Provides a random that will indicate the index of the image that will be set as the Desktop Background.
	 * Creates a {@code Wallpaper} Object and sets it as the Desktop Background, using the {@code setWallpaper()} method
	 * 
	 * @param args
	 * Array of Strings
	 * 
	 * @throws Exception
	 * Throws all kinds of exception
	 */
	public static void main(String[] args) throws Exception
	{
		Path file = Paths.get("/Library/Desktop Pictures");

		Path[] pathList = fillArray(file);

		int random = 2 + (int) (Math.random() * (pathList.length - 1));

		Wallpaper desktopBackground = new Wallpaper(pathList[random]);

		desktopBackground.setWallpaper();
	}

	/**
	 * Counts the files inside of the folder containing the images.
	 * Checks if the folder exists.
	 * Gets the path of the folder.
	 * Fills an array with the File Object.
	 * 
	 * @param dir
	 * Path Object representing the path to the folder containing the images.
	 * 
	 * @return 
	 * Integer representing the number of files inside the folder.
	 * 
	 * @throws IOException
	 * In case folder is not found.
	 * 
	 */
	public static int getFilesCount(Path dir) throws IOException
	{
		int count = 0;
		if(Files.exists(dir,LinkOption.NOFOLLOW_LINKS)) {
			File wallpaperDir = new File(dir.toString());
			File[] arr = wallpaperDir.listFiles();
			count = arr.length;
		}
		
		return count;
	}

	/**
	 * Sets the size of the array using the {@code getFilesCount()} method.
	 * Checks if the folder exists.
	 * Fills a temporary array containing the paths of the images as Strings.
	 * Fills an array with the Paths to all the images inside of the folder.
	 *
	 * @param dir
	 * Path Object representing the path to the folder containing the images.
	 * 
	 * @return
	 *  Array of type Path containing the paths to the images.
	 * 
	 * @throws IOException
	 * In case folder or image is not found. 
	 */
	public static Path[] fillArray(Path dir) throws IOException
	{
		Path[] pathList = new Path[getFilesCount(dir)];

		if(Files.exists(dir,LinkOption.NOFOLLOW_LINKS)) 
		{
			File wallpaperDir = new File(dir.toString());
			File[] arr = wallpaperDir.listFiles();
			int count = 0;
			for(File x: arr)
			{
				Path temp = Paths.get(x.toString());
				pathList[count] = temp;
				count++;
			}
		}
		return pathList;
	}
}
