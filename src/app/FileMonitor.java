package app;

//Code from https://javapapers.com/core-java/monitor-a-folder-using-java/, modified to a function form.

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;

public class FileMonitor {

	public void monitorFolder(String pathToFolder) throws IOException, InterruptedException {
		System.out.println("Aguardando novos arquivos .dat...");
		FileOperations fop = new FileOperations();
		Path dataFolder = Paths.get(pathToFolder);
		WatchService watchService = FileSystems.getDefault().newWatchService();
		dataFolder.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);
		boolean valid = true;
		do {
			WatchKey watchKey = watchService.take();
			List<WatchEvent<?>> iterate = watchKey.pollEvents();
			for(WatchEvent event : iterate) {
				if (StandardWatchEventKinds.ENTRY_CREATE.equals(event.kind())) {
					File toProcess = dataFolder.toFile();
					System.out.println("Processando novo arquivo...");
					fop.processAllFolder(toProcess);
					System.out.println("Aguardando novos arquivos .dat...");
				}
			}
			valid = watchKey.reset();

		} while (valid);
	}
}