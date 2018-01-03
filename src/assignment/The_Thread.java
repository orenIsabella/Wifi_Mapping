package assignment;

import java.io.File;

public class The_Thread extends Thread{


	private File file =new File("ScanInput");;
	private long timeStamp=file.lastModified();


	private boolean isFileUpdated( File file ) {

		if( file.lastModified() != timeStamp ) {
			this.timeStamp = file.lastModified();
			//Yes, file is updated
			return true;
		}
		//No, file is not updated
		return false;
	}


	@Override
	public void run() {
		while(true) {

			if(isFileUpdated(file)) {
				System.out.println("changed!");
			}else System.out.println("noting new");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
