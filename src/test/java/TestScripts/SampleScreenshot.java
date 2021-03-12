package TestScripts;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class SampleScreenshot extends TestBase{
	
	@Test
	public void Fullpagescreenshot() throws IOException {
		
		
		AShot screen = new AShot();
		Screenshot SShot = screen.shootingStrategy(ShootingStrategies.viewportPasting(200)).takeScreenshot(driver);
		
		String dest = System.getProperty("user.dir")+"/Screenshot/" + "Fullpage" + ".jpg";
		
		File FinalDestination = new File(dest);
		
		ImageIO.write(SShot.getImage(), "jpg", FinalDestination);
	}
	
	
	
	

}
