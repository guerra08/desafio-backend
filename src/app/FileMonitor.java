package app;

//Code from https://javapapers.com/core-java/monitor-a-folder-using-java/

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class FileMonitor {

	public void monitorFolder(String pathToFolder) throws IOException, InterruptedException {
		FileOperations fop = new FileOperations();
		Path dataFolder = Paths.get(pathToFolder);
		WatchService watchService = FileSystems.getDefault().newWatchService();
		dataFolder.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);
		boolean valid = true;
		do {
			WatchKey watchKey = watchService.take();
			for (WatchEvent event : watchKey.pollEvents()) {
				WatchEvent.Kind kind = event.kind();
				if (StandardWatchEventKinds.ENTRY_CREATE.equals(event.kind())) {
					System.out.println("entered monitor");
					DataCounter doc = fop.processAllFolder(dataFolder.toFile());
            		System.out.println(doc.getCountSalesmen() + " - " + doc.getCountCustomers());
				}
			}
			valid = watchKey.reset();

		} while (valid);
	}
}